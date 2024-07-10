//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.world.*;

public class SafeTimeTracker
{
    private long lastMark;
    private long duration;
    private long randomRange;
    private long lastRandomDelay;
    private long internalDelay;
    
    @Deprecated
    public SafeTimeTracker() {
        this.lastMark = Long.MIN_VALUE;
        this.duration = -1L;
        this.randomRange = 0L;
        this.lastRandomDelay = 0L;
        this.internalDelay = 1L;
    }
    
    public SafeTimeTracker(final long delay) {
        this.lastMark = Long.MIN_VALUE;
        this.duration = -1L;
        this.randomRange = 0L;
        this.lastRandomDelay = 0L;
        this.internalDelay = 1L;
        this.internalDelay = delay;
    }
    
    public SafeTimeTracker(final long delay, final long random) {
        this.lastMark = Long.MIN_VALUE;
        this.duration = -1L;
        this.randomRange = 0L;
        this.lastRandomDelay = 0L;
        this.internalDelay = 1L;
        this.internalDelay = delay;
        this.randomRange = random;
    }
    
    public boolean markTimeIfDelay(final World world) {
        return this.markTimeIfDelay(world, this.internalDelay);
    }
    
    @Deprecated
    public boolean markTimeIfDelay(final World world, final long delay) {
        if (world == null) {
            return false;
        }
        final long currentTime = world.getTotalWorldTime();
        if (currentTime < this.lastMark) {
            this.lastMark = currentTime;
            return false;
        }
        if (this.lastMark + delay + this.lastRandomDelay <= currentTime) {
            this.duration = currentTime - this.lastMark;
            this.lastMark = currentTime;
            this.lastRandomDelay = (int)(Math.random() * this.randomRange);
            return true;
        }
        return false;
    }
    
    public long durationOfLastDelay() {
        return (this.duration > 0L) ? this.duration : 0L;
    }
    
    public void markTime(final World world) {
        this.lastMark = world.getTotalWorldTime();
    }
}
