//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements.containers;

import net.minecraftforge.common.util.*;

public interface IRedstoneStatementContainer
{
    int getRedstoneInput(final ForgeDirection p0);
    
    boolean setRedstoneOutput(final ForgeDirection p0, final int p1);
}