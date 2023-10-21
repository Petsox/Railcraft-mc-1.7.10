//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.gui;

import mods.railcraft.common.blocks.machine.epsilon.*;
import net.minecraft.entity.player.*;
import mods.railcraft.common.blocks.*;
import mods.railcraft.common.gui.containers.*;
import mods.railcraft.common.gui.buttons.*;
import mods.railcraft.common.plugins.forge.*;
import mods.railcraft.client.gui.buttons.*;
import net.minecraft.client.gui.*;
import java.io.*;
import mods.railcraft.common.util.network.*;
import net.minecraft.util.*;

public class GuiEngravingBench extends TileGui
{
    private final TileEngravingBench tile;
    private final EntityPlayer player;
    
    public GuiEngravingBench(final InventoryPlayer inventoryplayer, final TileEngravingBench tile) {
        super(tile, new ContainerEngravingBench(inventoryplayer, tile), "railcraft:textures/gui/gui_engraving.png");
        this.tile = tile;
        this.player = inventoryplayer.player;
        this.ySize = 215;
    }
    
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        final int w = (this.width - this.xSize) / 2;
        final int h = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiBetterButton(0, w + 12, h + 26, 10, (IButtonTextureSet)StandardButtonTextureSets.LEFT_BUTTON, ""));
        this.buttonList.add(new GuiBetterButton(1, w + 154, h + 26, 10, (IButtonTextureSet)StandardButtonTextureSets.RIGHT_BUTTON, ""));
        this.buttonList.add(new GuiButtonSmall(2, w + 61, h + 60, 54, LocalizationPlugin.translate("railcraft.gui.engrave")));
        this.buttonList.add(new GuiButtonSmall(3, w + 35, h + 100, 106, LocalizationPlugin.translate("railcraft.gui.engrave.openunlock")));
    }
    
    protected void actionPerformed(final GuiButton button) {
        super.actionPerformed(button);
        TileEngravingBench.GuiPacketType packetType = TileEngravingBench.GuiPacketType.NORMAL_RETURN;
        if (button.id == 0) {
            ((ContainerEngravingBench)this.container).emblemBank.shiftLeft();
        }
        if (button.id == 1) {
            ((ContainerEngravingBench)this.container).emblemBank.shiftRight();
        }
        if (button.id == 2) {
            packetType = TileEngravingBench.GuiPacketType.START_CRAFTING;
        }
        if (button.id == 3) {
            packetType = TileEngravingBench.GuiPacketType.OPEN_UNLOCK;
        }
        this.sendUpdateToTile(packetType);
    }
    
    public void sendUpdateToTile(final TileEngravingBench.GuiPacketType type) {
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final DataOutputStream data = new DataOutputStream(bytes);
        try {
            data.writeByte(type.ordinal());
            switch (type) {
                case NORMAL_RETURN:
                case START_CRAFTING: {
                    data.writeUTF(((ContainerEngravingBench)this.container).emblemBank.getSelectedEmblem());
                    break;
                }
            }
        }
        catch (IOException ex) {}
        PacketBuilder.instance().sendGuiReturnPacket(this.tile, bytes.toByteArray());
    }
    
    public void onGuiClosed() {
        super.onGuiClosed();
        this.sendUpdateToTile(TileEngravingBench.GuiPacketType.NORMAL_RETURN);
    }
    
    protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
        GuiTools.drawCenteredString(this.fontRendererObj, this.tile.getName(), 6);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(final float f, final int i, final int j) {
        super.drawGuiContainerBackgroundLayer(f, i, j);
        final int x = (this.width - this.xSize) / 2;
        final int y = (this.height - this.ySize) / 2;
        if (this.tile.getProgress() > 0) {
            final int progress = this.tile.getProgressScaled(23);
            this.drawTexturedModalRect(x + 76, y + 76, 176, 0, progress + 1, 12);
        }
    }
}
