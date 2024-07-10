//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;

public interface IElectricItem
{
    boolean canProvideEnergy(final ItemStack p0);
    
    Item getChargedItem(final ItemStack p0);
    
    Item getEmptyItem(final ItemStack p0);
    
    double getMaxCharge(final ItemStack p0);
    
    int getTier(final ItemStack p0);
    
    double getTransferLimit(final ItemStack p0);
}
