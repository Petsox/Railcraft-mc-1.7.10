//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import thaumcraft.api.aspects.*;

public interface IArcaneRecipe
{
    boolean matches(final IInventory p0, final World p1, final EntityPlayer p2);
    
    ItemStack getCraftingResult(final IInventory p0);
    
    int getRecipeSize();
    
    ItemStack getRecipeOutput();
    
    AspectList getAspects();
    
    AspectList getAspects(final IInventory p0);
    
    String getResearch();
}
