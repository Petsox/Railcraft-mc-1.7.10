//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import mods.railcraft.common.core.*;
import mods.railcraft.common.plugins.forge.*;
import net.minecraft.item.*;
import mods.railcraft.common.util.inventory.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.texture.*;

public class ItemEmblem extends ItemEmblemBase
{
    public static ItemEmblem item;
    
    public static void registerItem() {
        if (ItemEmblem.item == null) {
            final String tag = "railcraft.emblem";
            if (RailcraftConfig.isItemEnabled(tag)) {
                (ItemEmblem.item = new ItemEmblem()).setUnlocalizedName(tag);
                RailcraftRegistry.register(ItemEmblem.item);
            }
        }
    }
    
    public static ItemStack getEmblem(final String identifier) {
        final ItemStack stack = new ItemStack((Item)ItemEmblem.item);
        final NBTTagCompound nbt = InvTools.getItemData(stack);
        nbt.setString("emblem", identifier);
        return stack;
    }
    
    @Override
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("railcraft:emblem");
    }
}
