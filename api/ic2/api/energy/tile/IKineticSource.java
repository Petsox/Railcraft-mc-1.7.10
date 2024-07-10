//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy.tile;

import net.minecraftforge.common.util.*;

public interface IKineticSource
{
    int maxrequestkineticenergyTick(final ForgeDirection p0);
    
    int requestkineticenergy(final ForgeDirection p0, final int p1);
}
