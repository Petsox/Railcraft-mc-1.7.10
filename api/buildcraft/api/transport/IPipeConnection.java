//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import net.minecraftforge.common.util.*;

public interface IPipeConnection
{
    ConnectOverride overridePipeConnection(final IPipeTile.PipeType p0, final ForgeDirection p1);
    
    public enum ConnectOverride
    {
        CONNECT, 
        DISCONNECT, 
        DEFAULT;
    }
}