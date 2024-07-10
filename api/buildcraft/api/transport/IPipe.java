//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import net.minecraftforge.common.util.*;
import buildcraft.api.gates.*;

public interface IPipe
{
    IPipeTile getTile();
    
    IGate getGate(final ForgeDirection p0);
    
    boolean hasGate(final ForgeDirection p0);
    
    boolean isWired(final PipeWire p0);
    
    boolean isWireActive(final PipeWire p0);
}
