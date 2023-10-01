//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraftforge.fluids.*;
import java.util.*;

public interface ILiquidAcceptManager
{
    boolean acceptsFluid(final Fluid p0);
    
    Set<Fluid> getAcceptedFluids();
}
