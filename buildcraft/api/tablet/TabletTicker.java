//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tablet;

public class TabletTicker
{
    private final float tickTime;
    private float time;
    private int ticked;
    
    public TabletTicker(final float tickTime) {
        this.time = 0.0f;
        this.ticked = 0;
        this.tickTime = tickTime;
    }
    
    public void add(final float time) {
        this.time += time;
        while (this.time >= this.tickTime) {
            this.time -= this.tickTime;
            ++this.ticked;
        }
    }
    
    public int getTicks() {
        return this.ticked;
    }
    
    public boolean tick() {
        final boolean oldTicked = this.ticked > 0;
        this.ticked = 0;
        return oldTicked;
    }
    
    public void reset() {
        this.ticked = 0;
        this.time = 0.0f;
    }
}
