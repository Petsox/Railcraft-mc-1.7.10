//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tiles;

public interface IControllable
{
    Mode getControlMode();
    
    void setControlMode(final Mode p0);
    
    boolean acceptsControlMode(final Mode p0);
    
    public enum Mode
    {
        Unknown, 
        On, 
        Off, 
        Mode, 
        Loop;
    }
}
