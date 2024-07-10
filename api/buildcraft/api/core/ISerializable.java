//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import io.netty.buffer.*;

public interface ISerializable
{
    void writeData(final ByteBuf p0);
    
    void readData(final ByteBuf p0);
}
