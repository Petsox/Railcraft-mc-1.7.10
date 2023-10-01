//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public interface IRepairableExtended extends IRepairable
{
    boolean doRepair(final ItemStack p0, final EntityPlayer p1, final int p2);
}
