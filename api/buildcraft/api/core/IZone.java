//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import java.util.*;

public interface IZone
{
    double distanceTo(final BlockIndex p0);
    
    double distanceToSquared(final BlockIndex p0);
    
    boolean contains(final double p0, final double p1, final double p2);
    
    BlockIndex getRandomBlockIndex(final Random p0);
}
