//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import java.util.*;

public interface IArchitect
{
    ArrayList<BlockCoordinates> getArchitectBlocks(final ItemStack p0, final World p1, final int p2, final int p3, final int p4, final int p5, final EntityPlayer p6);
    
    boolean showAxis(final ItemStack p0, final World p1, final EntityPlayer p2, final int p3, final EnumAxis p4);
    
    public enum EnumAxis
    {
        X, 
        Y, 
        Z;
    }
}
