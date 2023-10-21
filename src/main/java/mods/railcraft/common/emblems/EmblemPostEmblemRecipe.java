//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import mods.railcraft.common.util.inventory.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import mods.railcraft.common.blocks.aesthetics.post.*;
import mods.railcraft.common.util.misc.*;

public class EmblemPostEmblemRecipe implements IRecipe
{
    private ItemStack postTemplate;
    private ItemStack emblemPostTemplate;
    
    public ItemStack getEmblemPost() {
        if (this.emblemPostTemplate == null) {
            this.emblemPostTemplate = EnumPost.EMBLEM.getItem();
        }
        return this.emblemPostTemplate;
    }
    
    public ItemStack getPost() {
        if (this.postTemplate == null) {
            this.postTemplate = EnumPost.METAL_UNPAINTED.getItem();
        }
        return this.postTemplate;
    }
    
    private boolean isEmblem(final ItemStack stack) {
        return ItemEmblem.item != null && stack.getItem() == ItemEmblem.item;
    }
    
    private boolean isPost(final ItemStack stack) {
        return InvTools.isStackEqualToBlock(stack, (Block)BlockPostMetal.post) || InvTools.isItemEqual(stack, this.getPost(), true, false);
    }
    
    public boolean matches(final InventoryCrafting craftingGrid, final World var2) {
        int numPost = 0;
        int numEmblem = 0;
        for (int slot = 0; slot < craftingGrid.getSizeInventory(); ++slot) {
            final ItemStack stack = craftingGrid.getStackInSlot(slot);
            if (stack != null) {
                if (this.isPost(stack)) {
                    ++numPost;
                }
                else {
                    if (!this.isEmblem(stack)) {
                        return false;
                    }
                    ++numEmblem;
                }
            }
        }
        return numPost == 1 && numEmblem == 1;
    }
    
    public ItemStack getCraftingResult(final InventoryCrafting craftingGrid) {
        ItemStack post = null;
        ItemStack emblem = null;
        for (int slot = 0; slot < craftingGrid.getSizeInventory(); ++slot) {
            final ItemStack stack = craftingGrid.getStackInSlot(slot);
            if (stack != null) {
                if (this.isPost(stack)) {
                    post = stack;
                }
                else {
                    if (!this.isEmblem(stack)) {
                        return null;
                    }
                    emblem = stack;
                }
            }
        }
        if (post == null) {
            return null;
        }
        final ItemStack result = EnumPost.EMBLEM.getItem();
        ItemPost.setEmblem(result, EmblemToolsServer.getEmblemIdentifier(emblem));
        if (InvTools.isStackEqualToBlock(post, (Block)BlockPostMetal.post)) {
            InvTools.setItemColor(result, EnumColor.fromId(post.getItemDamage()));
        }
        return result;
    }
    
    public int getRecipeSize() {
        return 2;
    }
    
    public ItemStack getRecipeOutput() {
        return this.getEmblemPost();
    }
}
