//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy;

public class NodeStats
{
    protected double energyIn;
    protected double energyOut;
    protected double voltage;
    
    public NodeStats(final double energyIn, final double energyOut, final double voltage) {
        this.energyIn = energyIn;
        this.energyOut = energyOut;
        this.voltage = voltage;
    }
    
    public double getEnergyIn() {
        return this.energyIn;
    }
    
    public double getEnergyOut() {
        return this.energyOut;
    }
    
    public double getVoltage() {
        return this.voltage;
    }
}
