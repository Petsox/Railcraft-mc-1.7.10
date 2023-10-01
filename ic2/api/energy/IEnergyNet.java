//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.common.util.*;

public interface IEnergyNet
{
    TileEntity getTileEntity(final World p0, final int p1, final int p2, final int p3);
    
    TileEntity getNeighbor(final TileEntity p0, final ForgeDirection p1);
    
    @Deprecated
    double getTotalEnergyEmitted(final TileEntity p0);
    
    @Deprecated
    double getTotalEnergySunken(final TileEntity p0);
    
    NodeStats getNodeStats(final TileEntity p0);
    
    double getPowerFromTier(final int p0);
    
    int getTierFromPower(final double p0);
}
