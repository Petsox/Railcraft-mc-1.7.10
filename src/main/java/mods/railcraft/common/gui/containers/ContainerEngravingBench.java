//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.gui.containers;

import mods.railcraft.common.blocks.machine.epsilon.*;
import net.minecraft.entity.player.*;
import mods.railcraft.common.gui.widgets.*;
import mods.railcraft.common.gui.slots.*;
import net.minecraft.inventory.*;
import cofh.api.energy.*;
import java.util.*;

public class ContainerEngravingBench extends RailcraftContainer
{
    private final TileEngravingBench tile;
    private final RFEnergyIndicator energyIndicator;
    public EmblemBankWidget emblemBank;
    private int lastEnergy;
    private int lastProgress;
    
    public ContainerEngravingBench(final InventoryPlayer inventoryplayer, final TileEngravingBench tile) {
        super((IInventory)tile);
        this.tile = tile;
        this.energyIndicator = new RFEnergyIndicator((IEnergyHandler)tile);
        this.addWidget(new IndicatorWidget(this.energyIndicator, 157, 50, 176, 12, 6, 48));
        this.addWidget(this.emblemBank = new EmblemBankWidget(25, 25, tile.currentEmblem));
        this.addSlot(new SlotPassThrough((IInventory)tile, 0, 35, 66));
        this.addSlot(new SlotOutput((IInventory)tile, 1, 125, 66));
        for (int i1 = 0; i1 < 3; ++i1) {
            for (int l1 = 0; l1 < 9; ++l1) {
                this.addSlot(new Slot((IInventory)inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 133 + i1 * 18));
            }
        }
        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot((IInventory)inventoryplayer, j1, 8 + j1 * 18, 191));
        }
    }
    
    @Override
    public void sendUpdateToClient() {
        super.sendUpdateToClient();
        final EnergyStorage storage = this.tile.getEnergyStorage();
        for (final Object crafter : this.crafters) {
            final ICrafting icrafting = (ICrafting)crafter;
            if (this.lastProgress != this.tile.getProgress()) {
                icrafting.sendProgressBarUpdate((Container)this, 0, this.tile.getProgress());
            }
            if (storage != null && this.lastEnergy != storage.getEnergyStored()) {
                icrafting.sendProgressBarUpdate((Container)this, 1, storage.getEnergyStored());
            }
        }
        this.lastProgress = this.tile.getProgress();
        if (storage != null) {
            this.lastEnergy = storage.getEnergyStored();
        }
    }
    
    @Override
    public void addCraftingToCrafters(final ICrafting icrafting) {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate((Container)this, 0, this.tile.getProgress());
        final EnergyStorage storage = this.tile.getEnergyStorage();
        if (storage != null) {
            icrafting.sendProgressBarUpdate((Container)this, 2, storage.getEnergyStored());
        }
    }
    
    public void updateProgressBar(final int id, final int data) {
        switch (id) {
            case 0: {
                this.tile.setProgress(data);
                break;
            }
            case 1: {
                this.energyIndicator.updateEnergy(data);
                break;
            }
            case 2: {
                this.energyIndicator.setEnergy(data);
                break;
            }
        }
    }
}
