//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy.tile;

import net.minecraft.tileentity.*;
import net.minecraftforge.common.util.*;

public interface IEnergyAcceptor extends IEnergyTile
{
    boolean acceptsEnergyFrom(final TileEntity p0, final ForgeDirection p1);
}
