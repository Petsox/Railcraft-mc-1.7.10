//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraftforge.fluids.*;
import java.util.*;

public interface ISemiFluidFuelManager extends ILiquidAcceptManager
{
    void addFluid(final String p0, final int p1, final double p2);
    
    BurnProperty getBurnProperty(final Fluid p0);
    
    Map<String, BurnProperty> getBurnProperties();
    
    public static class BurnProperty
    {
        public final int amount;
        public final double power;
        
        public BurnProperty(final int amount1, final double power1) {
            this.amount = amount1;
            this.power = power1;
        }
    }
}
