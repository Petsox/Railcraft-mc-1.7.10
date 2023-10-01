//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.common.util.*;
import net.minecraft.entity.player.*;

public interface IStripesHandler
{
    StripesHandlerType getType();
    
    boolean shouldHandle(final ItemStack p0);
    
    boolean handle(final World p0, final int p1, final int p2, final int p3, final ForgeDirection p4, final ItemStack p5, final EntityPlayer p6, final IStripesActivator p7);
    
    public enum StripesHandlerType
    {
        ITEM_USE, 
        BLOCK_BREAK;
    }
}
