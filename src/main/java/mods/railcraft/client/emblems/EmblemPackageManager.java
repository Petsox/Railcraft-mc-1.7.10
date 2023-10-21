//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.emblems;

import mods.railcraft.client.util.textures.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import java.util.zip.*;
import cpw.mods.fml.common.*;
import net.minecraft.launchwrapper.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import mods.railcraft.common.util.misc.*;
import java.util.jar.*;
import java.io.*;
import java.security.cert.*;
import java.util.*;

public class EmblemPackageManager implements IEmblemPackageManager
{
    public static final EmblemPackageManager instance;
    public static final Texture blankEmblem;
    private static final Map<String, Emblem> loadedEmblems;
    private static final Map<String, EmblemTexture> emblemTextures;
    
    public void init() {
    }
    
    @Override
    public EmblemTexture getEmblemTexture(final String identifier) {
        EmblemTexture texture = EmblemPackageManager.emblemTextures.get(identifier);
        if (texture == null) {
            texture = new EmblemTexture(identifier);
            EmblemPackageManager.emblemTextures.put(identifier, texture);
            Minecraft.getMinecraft().renderEngine.loadTexture(texture.getLocation(), (ITextureObject)texture);
        }
        return texture;
    }
    
    @Override
    public Emblem getEmblem(final String identifier) {
        return EmblemPackageManager.loadedEmblems.get(identifier);
    }
    
    @Override
    public ResourceLocation getEmblemTextureLocation(final String ident) {
        return this.getEmblemTexture(ident).getLocation();
    }
    
    public Emblem getEmblemOrLoad(final String identifier) {
        final Emblem emblem = EmblemPackageManager.loadedEmblems.get(identifier);
        if (emblem != null) {
            return emblem;
        }
        this.getEmblemTexture(identifier);
        return null;
    }
    
    public void loadEmblems() {
        final File emblems = new File(Minecraft.getMinecraft().mcDataDir, "mods/railcraft/emblems");
        if (!emblems.exists()) {
            emblems.mkdirs();
        }
        if (!emblems.isDirectory()) {
            return;
        }
        for (final File file : emblems.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                final String identifier = file.getName().replace(".jar", "").replace("emblem-", "");
                this.loadEmblem(file, identifier);
            }
        }
    }
    
    public File getEmblemFile(final String identifier) {
        final File emblems = new File(Minecraft.getMinecraft().mcDataDir, "mods/railcraft/emblems");
        if (!emblems.exists()) {
            emblems.mkdirs();
        }
        final File emblem = new File(emblems, "emblem-" + identifier + ".jar");
        return emblem;
    }
    
    public Emblem loadEmblem(final String identifier) {
        return this.loadEmblem(this.getEmblemFile(identifier), identifier);
    }
    
    public Emblem loadEmblem(final File file, final String identifier) {
        JarFile jar = null;
        try {
            if (file == null) {
                throw new IOException("Cannot find file.");
            }
            jar = new JarFile(file);
            final Manifest man = jar.getManifest();
            if (man == null) {
                throw new SecurityException("Emblem Jar is not signed!");
            }
            final List<JarEntry> jarEntries = new ArrayList<JarEntry>();
            final byte[] buffer = new byte[8192];
            final Enumeration entries = jar.entries();
            while (entries.hasMoreElements()) {
                final JarEntry entry = (JarEntry) entries.nextElement();
                jarEntries.add(entry);
                final InputStream is = jar.getInputStream(entry);
                while (is.read(buffer, 0, buffer.length) != -1) {}
                is.close();
            }
            for (final JarEntry entry2 : jarEntries) {
                if (entry2.isDirectory()) {
                    continue;
                }
                if (entry2.getName().endsWith(".class")) {
                    throw new SecurityException("Emblem Jars should not have code!");
                }
                final Certificate[] certs = entry2.getCertificates();
                if (certs == null || certs.length == 0) {
                    if (!entry2.getName().startsWith("META-INF")) {
                        throw new SecurityException("Emblem Jar is not signed!");
                    }
                    continue;
                }
                else {
                    if (!CertificateHelper.getFingerprint(certs[0]).equals("a0c255ac501b2749537d5824bb0f0588bf0320fa")) {
                        throw new SecurityException("Emblem Jar is not signed!");
                    }
                    continue;
                }
            }
            final LaunchClassLoader classLoader = (LaunchClassLoader)EmblemPackageManager.class.getClassLoader();
            classLoader.addURL(file.toURI().toURL());
            for (final JarEntry entry3 : jarEntries) {
                if (entry3.isDirectory()) {
                    continue;
                }
                if (!entry3.getName().endsWith(".meta")) {
                    continue;
                }
                final Properties emblemData = new Properties();
                final InputStream iStream = jar.getInputStream(entry3);
                try {
                    emblemData.load(iStream);
                }
                finally {
                    iStream.close();
                }
                int rarity = 0;
                try {
                    rarity = Integer.parseInt(emblemData.getProperty("rarity"));
                    final EnumRarity[] rarities = EnumRarity.values();
                    if (rarity >= rarities.length) {
                        rarity = rarities.length - 1;
                    }
                }
                catch (NumberFormatException ex3) {}
                final boolean hasEffect = Boolean.parseBoolean(emblemData.getProperty("effect"));
                final String texturePath = this.parseTexturePath(emblemData.getProperty("texture"), identifier);
                final Emblem emblem = new Emblem(identifier, texturePath, emblemData.getProperty("name"), rarity, hasEffect);
                EmblemPackageManager.loadedEmblems.put(emblem.identifier, emblem);
                Game.log(Level.INFO, "Loaded Emblem - \"{0}\"", emblem.displayName);
                return emblem;
            }
        }
        catch (IOException ex) {
            Game.log(Level.WARN, "Failed to load Emblem due to IO exception - \"{0}\"", file.getName().replace(".jar", ""));
            Game.log(Level.WARN, "Reason: {0}", ex);
            return null;
        }
        catch (SecurityException ex2) {
            Game.log(Level.WARN, "Failed to load Emblem due to security failure - \"{0}\"", file.getName().replace(".jar", ""));
            Game.log(Level.WARN, "Reason: {0}", ex2);
            return null;
        }
        finally {
            try {
                if (jar != null) {
                    jar.close();
                }
            }
            catch (IOException ex4) {}
        }
        return null;
    }
    
    private String parseTexturePath(String path, final String idenifier) {
        path = path.replace("%emblem%", "/assets/railcraft/textures/emblems/" + idenifier);
        path = path.replace("%minecraft_block%", "/assets/minecraft/textures/blocks");
        path = path.replace("%minecraft_item%", "/assets/minecraft/textures/items");
        path = path.replace("%railcraft_item%", "/assets/railcraft/textures/items");
        return path;
    }
    
    static {
        blankEmblem = (Texture)new BlankTexture();
        loadedEmblems = new HashMap<String, Emblem>();
        emblemTextures = new HashMap<String, EmblemTexture>();
        instance = new EmblemPackageManager();
        EmblemToolsClient.packageManager = EmblemPackageManager.instance;
        final ResourceLocation location = new ResourceLocation("railcraft:textures/emblems/placeholder");
        Minecraft.getMinecraft().renderEngine.loadTexture(location, (ITextureObject)EmblemPackageManager.blankEmblem);
    }
}
