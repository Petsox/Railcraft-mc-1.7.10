//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import net.minecraft.world.*;
import net.minecraftforge.common.util.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import buildcraft.api.transport.pluggable.*;
import net.minecraft.item.*;
import buildcraft.api.core.*;

public interface IPipeTile extends IInjectable
{
    PipeType getPipeType();
    
    World getWorld();
    
    int x();
    
    int y();
    
    int z();
    
    boolean isPipeConnected(final ForgeDirection p0);
    
    Block getNeighborBlock(final ForgeDirection p0);
    
    TileEntity getNeighborTile(final ForgeDirection p0);
    
    IPipe getNeighborPipe(final ForgeDirection p0);
    
    IPipe getPipe();
    
    int getPipeColor();
    
    PipePluggable getPipePluggable(final ForgeDirection p0);
    
    boolean hasPipePluggable(final ForgeDirection p0);
    
    boolean hasBlockingPluggable(final ForgeDirection p0);
    
    void scheduleNeighborChange();
    
    void scheduleRenderUpdate();
    
    int injectItem(final ItemStack p0, final boolean p1, final ForgeDirection p2, final EnumColor p3);
    
    @Deprecated
    int injectItem(final ItemStack p0, final boolean p1, final ForgeDirection p2);
    
    public enum PipeType
    {
        ITEM, 
        FLUID, 
        POWER, 
        STRUCTURE;
    }
}
