//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import mods.railcraft.common.util.inventory.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import mods.railcraft.common.util.inventory.wrappers.*;
import mods.railcraft.common.carts.*;
import java.util.*;

public class LocomotiveEmblemRecipe implements IRecipe
{
    private final ItemStack locomotive;
    
    public LocomotiveEmblemRecipe(final ItemStack locomotive) {
        InvTools.addNBTTag(this.locomotive = locomotive, "gregfix", "get the hell off my lawn!");
    }
    
    private boolean isEmblem(final ItemStack stack) {
        return ItemEmblem.item != null && stack.getItem() == ItemEmblem.item;
    }
    
    private boolean isLocomotive(final ItemStack loco) {
        return InvTools.isItemEqualIgnoreNBT(this.locomotive, loco);
    }
    
    public boolean matches(final InventoryCrafting craftingGrid, final World var2) {
        int numLocomotive = 0;
        int numEmblem = 0;
        for (int slot = 0; slot < craftingGrid.getSizeInventory(); ++slot) {
            final ItemStack stack = craftingGrid.getStackInSlot(slot);
            if (stack != null) {
                if (this.isLocomotive(stack)) {
                    ++numLocomotive;
                }
                else {
                    if (!this.isEmblem(stack)) {
                        return false;
                    }
                    ++numEmblem;
                }
            }
        }
        return numLocomotive == 1 && numEmblem == 1;
    }
    
    public ItemStack getCraftingResult(final InventoryCrafting craftingGrid) {
        ItemStack loco = null;
        ItemStack emblem = null;
        for (final IInvSlot slot : InventoryIterator.getIterable((IInventory)craftingGrid)) {
            final ItemStack stack = slot.getStackInSlot();
            if (stack == null) {
                continue;
            }
            if (this.isLocomotive(stack)) {
                loco = stack;
            }
            else {
                if (!this.isEmblem(stack)) {
                    return null;
                }
                emblem = stack;
            }
        }
        if (loco == null || emblem == null) {
            return null;
        }
        final ItemStack result = loco.copy();
        ItemLocomotive.setEmblem(result, EmblemToolsServer.getEmblemIdentifier(emblem));
        return result;
    }
    
    public int getRecipeSize() {
        return 2;
    }
    
    public ItemStack getRecipeOutput() {
        return this.locomotive;
    }
}
