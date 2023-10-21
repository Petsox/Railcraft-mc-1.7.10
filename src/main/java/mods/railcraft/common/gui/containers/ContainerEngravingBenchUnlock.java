//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.gui.containers;

import mods.railcraft.common.blocks.machine.epsilon.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import mods.railcraft.common.gui.widgets.*;

public class ContainerEngravingBenchUnlock extends RailcraftContainer
{
    public final EmblemSlotWidget emblemSlot;
    private final TileEngravingBench tile;
    public String unlockResult;
    public String unlockMsg;
    
    public ContainerEngravingBenchUnlock(final InventoryPlayer inventoryplayer, final TileEngravingBench tile) {
        super((IInventory)tile);
        this.tile = tile;
        this.addWidget(this.emblemSlot = new EmblemSlotWidget(139, 77, 0, 0));
    }
    
    @Override
    public void updateString(final byte id, final String data) {
        if (id == 0) {
            this.unlockResult = data;
            if (this.unlockResult != null && !this.unlockResult.equals("")) {
                this.emblemSlot.emblemIdentifier = this.unlockResult;
            }
            else {
                this.emblemSlot.emblemIdentifier = null;
            }
        }
        if (id == 1) {
            this.unlockMsg = data;
        }
    }
}
