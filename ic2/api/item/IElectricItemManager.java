//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;
import net.minecraft.entity.*;

public interface IElectricItemManager
{
    double charge(final ItemStack p0, final double p1, final int p2, final boolean p3, final boolean p4);
    
    double discharge(final ItemStack p0, final double p1, final int p2, final boolean p3, final boolean p4, final boolean p5);
    
    double getCharge(final ItemStack p0);
    
    boolean canUse(final ItemStack p0, final double p1);
    
    boolean use(final ItemStack p0, final double p1, final EntityLivingBase p2);
    
    void chargeFromArmor(final ItemStack p0, final EntityLivingBase p1);
    
    String getToolTip(final ItemStack p0);
}
