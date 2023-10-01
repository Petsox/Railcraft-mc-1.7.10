//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.block.*;
import java.lang.reflect.*;
import net.minecraft.world.*;
import java.util.*;

public final class BuildCraftAPI
{
    public static ICoreProxy proxy;
    public static final Set<Block> softBlocks;
    public static final HashMap<String, IWorldProperty> worldProperties;
    
    private BuildCraftAPI() {
    }
    
    public static String getVersion() {
        try {
            final Class<?> clazz = Class.forName("buildcraft.core.Version");
            final Method method = clazz.getDeclaredMethod("getVersion", (Class<?>[])new Class[0]);
            return String.valueOf(method.invoke(null, new Object[0]));
        }
        catch (Exception e) {
            return "UNKNOWN VERSION";
        }
    }
    
    public static IWorldProperty getWorldProperty(final String name) {
        return BuildCraftAPI.worldProperties.get(name);
    }
    
    public static void registerWorldProperty(final String name, final IWorldProperty property) {
        if (BuildCraftAPI.worldProperties.containsKey(name)) {
            BCLog.logger.warn("The WorldProperty key '" + name + "' is being overidden with " + property.getClass().getSimpleName() + "!");
        }
        BuildCraftAPI.worldProperties.put(name, property);
    }
    
    public static boolean isSoftBlock(final World world, final int x, final int y, final int z) {
        return BuildCraftAPI.worldProperties.get("soft").get(world, x, y, z);
    }
    
    static {
        softBlocks = new HashSet<Block>();
        worldProperties = new HashMap<String, IWorldProperty>();
    }
}
