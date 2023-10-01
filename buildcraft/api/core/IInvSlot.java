//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.item.*;

public interface IInvSlot
{
    int getIndex();
    
    boolean canPutStackInSlot(final ItemStack p0);
    
    boolean canTakeStackFromSlot(final ItemStack p0);
    
    boolean isItemValidForSlot(final ItemStack p0);
    
    ItemStack decreaseStackInSlot(final int p0);
    
    ItemStack getStackInSlot();
    
    void setStackInSlot(final ItemStack p0);
}
