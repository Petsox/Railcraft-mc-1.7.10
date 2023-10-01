//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import java.util.*;

public interface IMachineRecipeManager
{
    void addRecipe(final IRecipeInput p0, final NBTTagCompound p1, final ItemStack... p2);
    
    RecipeOutput getOutputFor(final ItemStack p0, final boolean p1);
    
    Map<IRecipeInput, RecipeOutput> getRecipes();
}
