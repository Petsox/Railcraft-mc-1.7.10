//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraft.item.*;

public interface ICraftingRecipeManager
{
    void addRecipe(final ItemStack p0, final Object... p1);
    
    void addShapelessRecipe(final ItemStack p0, final Object... p1);
}
