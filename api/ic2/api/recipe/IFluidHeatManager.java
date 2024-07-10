//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraftforge.fluids.*;
import java.util.*;

public interface IFluidHeatManager extends ILiquidAcceptManager
{
    void addFluid(final String p0, final int p1, final int p2);
    
    BurnProperty getBurnProperty(final Fluid p0);
    
    Map<String, BurnProperty> getBurnProperties();
    
    public static class BurnProperty
    {
        public final int amount;
        public final int heat;
        
        public BurnProperty(final int amount1, final int heat1) {
            this.amount = amount1;
            this.heat = heat1;
        }
    }
}
