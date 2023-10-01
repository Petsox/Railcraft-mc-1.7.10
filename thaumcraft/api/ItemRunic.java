//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api;

import net.minecraft.item.*;

public class ItemRunic extends Item implements IRunicArmor
{
    int charge;
    
    public ItemRunic(final int charge) {
        this.charge = charge;
    }
    
    public int getRunicCharge(final ItemStack itemstack) {
        return this.charge;
    }
}
