//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraftforge.fluids.*;
import java.util.*;

public interface ILiquidHeatExchangerManager extends ILiquidAcceptManager
{
    void addFluid(final String p0, final String p1, final int p2);
    
    HeatExchangeProperty getHeatExchangeProperty(final Fluid p0);
    
    Map<String, HeatExchangeProperty> getHeatExchangeProperties();
    
    public static class HeatExchangeProperty
    {
        public final Fluid outputFluid;
        public final int huPerMB;
        
        public HeatExchangeProperty(final Fluid outputFluid, final int huPerMB) {
            this.outputFluid = outputFluid;
            this.huPerMB = huPerMB;
        }
    }
}
