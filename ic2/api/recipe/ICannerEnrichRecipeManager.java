//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraftforge.fluids.*;
import net.minecraft.item.*;
import java.util.*;

public interface ICannerEnrichRecipeManager
{
    void addRecipe(final FluidStack p0, final IRecipeInput p1, final FluidStack p2);
    
    RecipeOutput getOutputFor(final FluidStack p0, final ItemStack p1, final boolean p2, final boolean p3);
    
    Map<Input, FluidStack> getRecipes();
    
    public static class Input
    {
        public final FluidStack fluid;
        public final IRecipeInput additive;
        
        public Input(final FluidStack fluid1, final IRecipeInput additive1) {
            this.fluid = fluid1;
            this.additive = additive1;
        }
        
        public boolean matches(final FluidStack fluid1, final ItemStack additive1) {
            return (this.fluid == null || this.fluid.isFluidEqual(fluid1)) && this.additive.matches(additive1);
        }
    }
}
