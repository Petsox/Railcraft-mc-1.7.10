//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.tile;

import net.minecraftforge.common.util.*;

public interface IEnergyStorage
{
    int getStored();
    
    void setStored(final int p0);
    
    int addEnergy(final int p0);
    
    int getCapacity();
    
    int getOutput();
    
    double getOutputEnergyUnitsPerTick();
    
    boolean isTeleporterCompatible(final ForgeDirection p0);
}
