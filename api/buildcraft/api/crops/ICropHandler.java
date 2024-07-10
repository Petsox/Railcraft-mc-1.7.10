//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.crops;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import java.util.*;

public interface ICropHandler
{
    boolean isSeed(final ItemStack p0);
    
    boolean canSustainPlant(final World p0, final ItemStack p1, final int p2, final int p3, final int p4);
    
    boolean plantCrop(final World p0, final EntityPlayer p1, final ItemStack p2, final int p3, final int p4, final int p5);
    
    boolean isMature(final IBlockAccess p0, final Block p1, final int p2, final int p3, final int p4, final int p5);
    
    boolean harvestCrop(final World p0, final int p1, final int p2, final int p3, final List<ItemStack> p4);
}
