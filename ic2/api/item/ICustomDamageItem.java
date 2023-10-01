//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;
import net.minecraft.entity.*;

public interface ICustomDamageItem
{
    int getCustomDamage(final ItemStack p0);
    
    int getMaxCustomDamage(final ItemStack p0);
    
    void setCustomDamage(final ItemStack p0, final int p1);
    
    boolean applyCustomDamage(final ItemStack p0, final int p1, final EntityLivingBase p2);
}
