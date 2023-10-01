//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraft.item.*;
import java.util.*;

public class RecipeInputItemStack implements IRecipeInput
{
    public final ItemStack input;
    public final int amount;
    
    public RecipeInputItemStack(final ItemStack aInput) {
        this(aInput, aInput.stackSize);
    }
    
    public RecipeInputItemStack(final ItemStack aInput, final int aAmount) {
        if (aInput.getItem() == null) {
            throw new IllegalArgumentException("Invalid item stack specfied");
        }
        this.input = aInput.copy();
        this.amount = aAmount;
    }
    
    @Override
    public boolean matches(final ItemStack subject) {
        return subject.getItem() == this.input.getItem() && (subject.getItemDamage() == this.input.getItemDamage() || this.input.getItemDamage() == 32767);
    }
    
    @Override
    public int getAmount() {
        return this.amount;
    }
    
    @Override
    public List<ItemStack> getInputs() {
        return Arrays.asList(this.input);
    }
    
    @Override
    public String toString() {
        final ItemStack stack = this.input.copy();
        this.input.stackSize = this.amount;
        return "RInputItemStack<" + stack + ">";
    }
}
