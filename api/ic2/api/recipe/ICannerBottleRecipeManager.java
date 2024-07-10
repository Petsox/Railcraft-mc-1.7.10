//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraft.item.*;
import java.util.*;

public interface ICannerBottleRecipeManager
{
    void addRecipe(final IRecipeInput p0, final IRecipeInput p1, final ItemStack p2);
    
    RecipeOutput getOutputFor(final ItemStack p0, final ItemStack p1, final boolean p2, final boolean p3);
    
    Map<Input, RecipeOutput> getRecipes();
    
    public static class Input
    {
        public final IRecipeInput container;
        public final IRecipeInput fill;
        
        public Input(final IRecipeInput container1, final IRecipeInput fill1) {
            this.container = container1;
            this.fill = fill1;
        }
        
        public boolean matches(final ItemStack container1, final ItemStack fill1) {
            return this.container.matches(container1) && this.fill.matches(fill1);
        }
    }
}
