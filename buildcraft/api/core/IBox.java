//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

public interface IBox extends IZone
{
    IBox expand(final int p0);
    
    IBox contract(final int p0);
    
    Position pMin();
    
    Position pMax();
    
    void createLaserData();
}
