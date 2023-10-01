//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy.tile;

public interface IEnergyConductor extends IEnergyAcceptor, IEnergyEmitter
{
    double getConductionLoss();
    
    double getInsulationEnergyAbsorption();
    
    double getInsulationBreakdownEnergy();
    
    double getConductorBreakdownEnergy();
    
    void removeInsulation();
    
    void removeConductor();
}
