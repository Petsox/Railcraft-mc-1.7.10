//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public interface ILatheItem
{
    int getWidth(final ItemStack p0);
    
    int[] getCurrentState(final ItemStack p0);
    
    void setState(final ItemStack p0, final int p1, final int p2);
    
    ItemStack getOutputItem(final ItemStack p0, final int p1);
    
    float getOutputChance(final ItemStack p0, final int p1);
    
    @SideOnly(Side.CLIENT)
    ResourceLocation getTexture(final ItemStack p0);
    
    int getHardness(final ItemStack p0);
    
    public interface ILatheTool extends ICustomDamageItem
    {
        int getHardness(final ItemStack p0);
    }
}
