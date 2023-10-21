//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.emblems;

import mods.railcraft.client.util.textures.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import mods.railcraft.common.util.misc.*;
import javax.imageio.*;
import net.minecraft.client.renderer.texture.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.nio.channels.*;

public class EmblemTexture extends Texture
{
    private final String identifier;
    private boolean cachedImage;
    private boolean triedDownloading;
    private final ResourceLocation location;
    
    public EmblemTexture(final String ident) {
        this.cachedImage = false;
        this.identifier = ident;
        this.location = new ResourceLocation("railcraft:textures/emblems/" + this.identifier);
    }
    
    public void loadTexture(final IResourceManager resourceManager) throws IOException {
        if (this.imageData == null && !this.loadEmblemTexture() && !this.triedDownloading) {
            this.triedDownloading = true;
            Game.log(Level.INFO, "Attempting to download Emblem - \"emblem-{0}\"", this.identifier);
            final EmblemDownloader downloader = new EmblemDownloader();
            downloader.setDaemon(true);
            downloader.setName("Emblem downloader (" + this.identifier + ")");
            downloader.start();
        }
    }
    
    private boolean loadEmblemTexture() throws IOException {
        final Emblem emblem = EmblemPackageManager.instance.getEmblem(this.identifier);
        if (emblem == null) {
            return false;
        }
        final InputStream istream = EmblemPackageManager.class.getResourceAsStream(emblem.textureFile);
        if (istream == null) {
            return false;
        }
        this.imageData = ImageIO.read(istream);
        istream.close();
        return true;
    }
    
    public int getGlTextureId() {
        final int textureIndex = super.getGlTextureId();
        if (!this.cachedImage && this.imageData != null) {
            TextureUtil.uploadTextureImage(textureIndex, this.imageData);
            this.cachedImage = true;
        }
        if (this.imageData == null) {
            return EmblemPackageManager.blankEmblem.getGlTextureId();
        }
        return textureIndex;
    }
    
    @Override
    public BufferedImage getImage() {
        if (this.imageData == null) {
            return EmblemPackageManager.blankEmblem.getImage();
        }
        return this.imageData;
    }
    
    public ResourceLocation getLocation() {
        return this.location;
    }
    
    public String toString() {
        return String.format("Emblem Texture - %s - Location: %s", this.identifier, this.location);
    }
    
    private class EmblemDownloader extends Thread
    {
        @Override
        public void run() {
            FileOutputStream fos = null;
            try {
                final URL url = new URL("https://dl.dropboxusercontent.com/u/38558957/Minecraft/Railcraft/Emblems/emblem-" + EmblemTexture.this.identifier + ".jar");
                final ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                fos = new FileOutputStream(EmblemPackageManager.instance.getEmblemFile(EmblemTexture.this.identifier));
                fos.getChannel().transferFrom(rbc, 0L, Long.MAX_VALUE);
                Game.log(Level.INFO, "Downloaded Emblem: \"emblem-{0}\"", EmblemTexture.this.identifier);
                EmblemPackageManager.instance.loadEmblem(EmblemTexture.this.identifier);
                EmblemTexture.this.loadEmblemTexture();
            }
            catch (Exception ex) {
                Game.log(Level.WARN, "Failed to download Emblem: \"emblem-{0}\". Reason: {1}", EmblemTexture.this.identifier, ex);
            }
            finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                }
                catch (IOException ex2) {}
            }
        }
    }
}
