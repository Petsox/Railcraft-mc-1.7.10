//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.energy.event;

import net.minecraftforge.event.world.*;
import ic2.api.energy.tile.*;
import net.minecraft.tileentity.*;

public class EnergyTileEvent extends WorldEvent
{
    public final IEnergyTile energyTile;
    
    public EnergyTileEvent(final IEnergyTile energyTile1) {
        super(((TileEntity)energyTile1).getWorldObj());
        if (this.world == null) {
            throw new NullPointerException("world is null");
        }
        this.energyTile = energyTile1;
    }
}
