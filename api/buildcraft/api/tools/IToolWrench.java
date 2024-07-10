//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tools;

import net.minecraft.entity.player.*;

public interface IToolWrench
{
    boolean canWrench(final EntityPlayer p0, final int p1, final int p2, final int p3);
    
    void wrenchUsed(final EntityPlayer p0, final int p1, final int p2, final int p3);
}
