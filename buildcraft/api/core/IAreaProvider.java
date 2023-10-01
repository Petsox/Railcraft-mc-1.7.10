//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

public interface IAreaProvider
{
    int xMin();
    
    int yMin();
    
    int zMin();
    
    int xMax();
    
    int yMax();
    
    int zMax();
    
    void removeFromWorld();
}
