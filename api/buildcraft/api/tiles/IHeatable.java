//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tiles;

public interface IHeatable
{
    double getMinHeatValue();
    
    double getIdealHeatValue();
    
    double getMaxHeatValue();
    
    double getCurrentHeatValue();
    
    double setHeatValue(final double p0);
}
