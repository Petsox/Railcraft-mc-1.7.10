//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import mods.railcraft.common.core.*;
import net.minecraft.item.*;
import mods.railcraft.common.util.inventory.*;
import net.minecraft.nbt.*;
import mods.railcraft.common.plugins.forge.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class ItemEmblemDesign extends ItemEmblemBase
{
    public static ItemEmblemDesign item;
    
    public static void registerItem() {
        if (ItemEmblemDesign.item == null) {
            final String tag = "railcraft.emblem.design";
            if (RailcraftConfig.isItemEnabled(tag)) {
                (ItemEmblemDesign.item = new ItemEmblemDesign()).setUnlocalizedName(tag);
                RailcraftRegistry.register((Item)ItemEmblemDesign.item);
            }
        }
    }
    
    public static ItemStack getEmblem(final String identifier) {
        final ItemStack stack = new ItemStack((Item)ItemEmblemDesign.item);
        final NBTTagCompound nbt = InvTools.getItemData(stack);
        nbt.setString("emblem", identifier);
        return stack;
    }
    
    public ItemEmblemDesign() {
        this.setCreativeTab(CreativePlugin.RAILCRAFT_TAB);
    }
    
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
    }
    
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player) {
        if (EmblemManager.playerHasEmblem(player, EmblemToolsServer.getEmblemIdentifier(stack))) {
            return stack;
        }
        return stack;
    }
}
