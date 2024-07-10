//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraftforge.fluids.*;

public final class StackKey
{
    public final ItemStack stack;
    public final FluidStack fluidStack;
    
    public StackKey(final FluidStack fluidStack) {
        this(null, fluidStack);
    }
    
    public StackKey(final ItemStack stack) {
        this(stack, null);
    }
    
    public StackKey(final ItemStack stack, final FluidStack fluidStack) {
        this.stack = stack;
        this.fluidStack = fluidStack;
    }
    
    public static StackKey stack(final Item item, final int amount, final int damage) {
        return new StackKey(new ItemStack(item, amount, damage));
    }
    
    public static StackKey stack(final Block block, final int amount, final int damage) {
        return new StackKey(new ItemStack(block, amount, damage));
    }
    
    public static StackKey stack(final Item item) {
        return new StackKey(new ItemStack(item, 1, 0));
    }
    
    public static StackKey stack(final Block block) {
        return new StackKey(new ItemStack(block, 1, 0));
    }
    
    public static StackKey stack(final ItemStack itemStack) {
        return new StackKey(itemStack);
    }
    
    public static StackKey fluid(final Fluid fluid, final int amount) {
        return new StackKey(new FluidStack(fluid, amount));
    }
    
    public static StackKey fluid(final Fluid fluid) {
        return new StackKey(new FluidStack(fluid, 1000));
    }
    
    public static StackKey fluid(final FluidStack fluidStack) {
        return new StackKey(fluidStack);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != StackKey.class) {
            return false;
        }
        final StackKey k = (StackKey)o;
        return !(this.stack == null ^ k.stack == null) && !(this.fluidStack == null ^ k.fluidStack == null) && (this.stack == null || (this.stack.getItem() == k.stack.getItem() && (!this.stack.getHasSubtypes() || this.stack.getItemDamage() == k.stack.getItemDamage()) && this.objectsEqual(this.stack.getTagCompound(), k.stack.getTagCompound()))) && (this.fluidStack == null || (this.fluidStack.getFluid().getID() == k.fluidStack.getFluid().getID() && this.fluidStack.amount == k.fluidStack.amount && this.objectsEqual(this.fluidStack.tag, k.fluidStack.tag)));
    }
    
    @Override
    public int hashCode() {
        int result = 7;
        if (this.stack != null) {
            result = 31 * result + this.stack.getItem().hashCode();
            result = 31 * result + this.stack.getItemDamage();
            result = 31 * result + this.objectHashCode(this.stack.getTagCompound());
        }
        result = 31 * result + 7;
        if (this.fluidStack != null) {
            result = 31 * result + this.fluidStack.getFluid().getID();
            result = 31 * result + this.fluidStack.amount;
            result = 31 * result + this.objectHashCode(this.fluidStack.tag);
        }
        return result;
    }
    
    private boolean objectsEqual(final Object o1, final Object o2) {
        return (o1 == null && o2 == null) || (o1 != null && o2 != null && o1.equals(o2));
    }
    
    private int objectHashCode(final Object o) {
        return (o != null) ? o.hashCode() : 0;
    }
    
    public StackKey copy() {
        return new StackKey((this.stack != null) ? this.stack.copy() : null, (this.fluidStack != null) ? this.fluidStack.copy() : null);
    }
}
