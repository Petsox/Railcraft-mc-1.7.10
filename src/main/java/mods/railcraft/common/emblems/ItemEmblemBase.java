//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import mods.railcraft.common.items.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import mods.railcraft.client.emblems.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;

public abstract class ItemEmblemBase extends ItemRailcraft
{
    public void getSubItems(final Item item, final CreativeTabs tab, final List list) {
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(final ItemStack stack, final EntityPlayer player, final List info, final boolean adv) {
        if (stack.hasTagCompound()) {
            final NBTTagCompound nbt = stack.getTagCompound();
            final NBTTagString emblemIdent = (NBTTagString)nbt.getTag("emblem");
            if (emblemIdent == null) {
                return;
            }
            final Emblem emblem = EmblemPackageManager.instance.getEmblemOrLoad(emblemIdent.func_150285_a_());
            if (emblem != null) {
                info.add(EnumChatFormatting.GRAY + emblem.displayName);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumRarity getRarity(final ItemStack stack) {
        EnumRarity rarity = EnumRarity.common;
        if (stack.hasTagCompound()) {
            final NBTTagCompound nbt = stack.getTagCompound();
            final NBTTagString emblemIdent = (NBTTagString)nbt.getTag("emblem");
            if (emblemIdent == null) {
                return rarity;
            }
            final Emblem emblem = EmblemPackageManager.instance.getEmblemOrLoad(emblemIdent.func_150285_a_());
            if (emblem == null) {
                return EnumRarity.common;
            }
            rarity = EnumRarity.values()[emblem.rarity];
        }
        return rarity;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(final ItemStack stack, final int pass) {
        if (pass != 0) {
            return false;
        }
        if (!stack.hasTagCompound()) {
            return false;
        }
        final NBTTagCompound nbt = stack.getTagCompound();
        final NBTTagString emblemIdent = (NBTTagString)nbt.getTag("emblem");
        if (emblemIdent == null) {
            return false;
        }
        final Emblem emblem = EmblemPackageManager.instance.getEmblemOrLoad(emblemIdent.func_150285_a_());
        return emblem != null && emblem.hasEffect;
    }
}
