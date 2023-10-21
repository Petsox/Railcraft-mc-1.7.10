//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import mods.railcraft.common.blocks.aesthetics.post.*;
import mods.railcraft.common.util.inventory.*;
import mods.railcraft.common.util.misc.*;
import mods.railcraft.common.util.crafting.*;
import java.util.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;

public class EmblemPostColorRecipe implements IRecipe
{
    private ItemStack postTemplate;
    
    public ItemStack getPost() {
        if (this.postTemplate == null) {
            this.postTemplate = EnumPost.EMBLEM.getItem();
        }
        return this.postTemplate;
    }
    
    private boolean isPost(final ItemStack stack) {
        return InvTools.isItemEqual(stack, this.getPost(), true, false);
    }
    
    private boolean isDye(final ItemStack stack) {
        return this.getDyeColor(stack) != null;
    }
    
    private EnumColor getDyeColor(final ItemStack stack) {
        for (final EnumColor color : EnumColor.VALUES) {
            if (InvTools.isItemEqual(stack, DyeHelper.getDyes().get((EnumColor) color))) {
                return color;
            }
        }
        return null;
    }
    
    public boolean matches(final InventoryCrafting craftingGrid, final World var2) {
        int numPost = 0;
        int numDye = 0;
        for (int slot = 0; slot < craftingGrid.getSizeInventory(); ++slot) {
            final ItemStack stack = craftingGrid.getStackInSlot(slot);
            if (stack != null) {
                if (this.isDye(stack)) {
                    ++numDye;
                }
                else {
                    if (!this.isPost(stack)) {
                        return false;
                    }
                    ++numPost;
                }
            }
        }
        return numPost == 1 && numDye == 1;
    }
    
    public ItemStack getCraftingResult(final InventoryCrafting craftingGrid) {
        ItemStack post = null;
        ItemStack dye = null;
        for (int slot = 0; slot < craftingGrid.getSizeInventory(); ++slot) {
            final ItemStack stack = craftingGrid.getStackInSlot(slot);
            if (stack != null) {
                if (this.isPost(stack)) {
                    post = stack;
                }
                else {
                    if (!this.isDye(stack)) {
                        return null;
                    }
                    dye = stack;
                }
            }
        }
        if (post == null) {
            return null;
        }
        ItemStack result = post.copy();
        result = InvTools.setItemColor(result, this.getDyeColor(dye));
        return result;
    }
    
    public int getRecipeSize() {
        return 2;
    }
    
    public ItemStack getRecipeOutput() {
        return this.getPost();
    }
}
