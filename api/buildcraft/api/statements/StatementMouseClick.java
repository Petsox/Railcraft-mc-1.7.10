//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

public final class StatementMouseClick
{
    private int button;
    private boolean shift;
    
    public StatementMouseClick(final int button, final boolean shift) {
        this.button = button;
        this.shift = shift;
    }
    
    public boolean isShift() {
        return this.shift;
    }
    
    public int getButton() {
        return this.button;
    }
}
