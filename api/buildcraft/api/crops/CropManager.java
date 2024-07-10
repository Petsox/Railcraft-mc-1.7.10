//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.crops;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import java.util.*;

public final class CropManager
{
    private static List<ICropHandler> handlers;
    private static ICropHandler defaultHandler;
    
    private CropManager() {
    }
    
    public static void registerHandler(final ICropHandler cropHandler) {
        CropManager.handlers.add(cropHandler);
    }
    
    public static void setDefaultHandler(final ICropHandler cropHandler) {
        CropManager.defaultHandler = cropHandler;
    }
    
    public static ICropHandler getDefaultHandler() {
        return CropManager.defaultHandler;
    }
    
    public static boolean isSeed(final ItemStack stack) {
        for (final ICropHandler cropHandler : CropManager.handlers) {
            if (cropHandler.isSeed(stack)) {
                return true;
            }
        }
        return CropManager.defaultHandler.isSeed(stack);
    }
    
    public static boolean canSustainPlant(final World world, final ItemStack seed, final int x, final int y, final int z) {
        for (final ICropHandler cropHandler : CropManager.handlers) {
            if (cropHandler.isSeed(seed) && cropHandler.canSustainPlant(world, seed, x, y, z)) {
                return true;
            }
        }
        return CropManager.defaultHandler.isSeed(seed) && CropManager.defaultHandler.canSustainPlant(world, seed, x, y, z);
    }
    
    public static boolean plantCrop(final World world, final EntityPlayer player, final ItemStack seed, final int x, final int y, final int z) {
        for (final ICropHandler cropHandler : CropManager.handlers) {
            if (cropHandler.isSeed(seed) && cropHandler.canSustainPlant(world, seed, x, y, z) && cropHandler.plantCrop(world, player, seed, x, y, z)) {
                return true;
            }
        }
        return CropManager.defaultHandler.plantCrop(world, player, seed, x, y, z);
    }
    
    public static boolean isMature(final IBlockAccess blockAccess, final Block block, final int meta, final int x, final int y, final int z) {
        for (final ICropHandler cropHandler : CropManager.handlers) {
            if (cropHandler.isMature(blockAccess, block, meta, x, y, z)) {
                return true;
            }
        }
        return CropManager.defaultHandler.isMature(blockAccess, block, meta, x, y, z);
    }
    
    public static boolean harvestCrop(final World world, final int x, final int y, final int z, final List<ItemStack> drops) {
        final Block block = world.getBlock(x, y, z);
        final int meta = world.getBlockMetadata(x, y, z);
        for (final ICropHandler cropHandler : CropManager.handlers) {
            if (cropHandler.isMature((IBlockAccess)world, block, meta, x, y, z)) {
                return cropHandler.harvestCrop(world, x, y, z, drops);
            }
        }
        return CropManager.defaultHandler.isMature((IBlockAccess)world, block, meta, x, y, z) && CropManager.defaultHandler.harvestCrop(world, x, y, z, drops);
    }
    
    static {
        CropManager.handlers = new ArrayList<ICropHandler>();
    }
}
