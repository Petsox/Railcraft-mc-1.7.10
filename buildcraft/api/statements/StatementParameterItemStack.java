//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.texture.*;

public class StatementParameterItemStack implements IStatementParameter
{
    protected ItemStack stack;
    
    public IIcon getIcon() {
        return null;
    }
    
    public ItemStack getItemStack() {
        return this.stack;
    }
    
    public void onClick(final IStatementContainer source, final IStatement stmt, final ItemStack stack, final StatementMouseClick mouse) {
        if (stack != null) {
            this.stack = stack.copy();
            this.stack.stackSize = 1;
        }
        else {
            this.stack = null;
        }
    }
    
    public void writeToNBT(final NBTTagCompound compound) {
        if (this.stack != null) {
            final NBTTagCompound tagCompound = new NBTTagCompound();
            this.stack.writeToNBT(tagCompound);
            compound.setTag("stack", (NBTBase)tagCompound);
        }
    }
    
    public void readFromNBT(final NBTTagCompound compound) {
        this.stack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("stack"));
    }
    
    @Override
    public boolean equals(final Object object) {
        if (object instanceof StatementParameterItemStack) {
            final StatementParameterItemStack param = (StatementParameterItemStack)object;
            return ItemStack.areItemStacksEqual(this.stack, param.stack) && ItemStack.areItemStackTagsEqual(this.stack, param.stack);
        }
        return false;
    }
    
    public String getDescription() {
        if (this.stack != null) {
            return this.stack.getDisplayName();
        }
        return "";
    }
    
    public String getUniqueTag() {
        return "buildcraft:stack";
    }
    
    public void registerIcons(final IIconRegister iconRegister) {
    }
    
    public IStatementParameter rotateLeft() {
        return (IStatementParameter)this;
    }
}
