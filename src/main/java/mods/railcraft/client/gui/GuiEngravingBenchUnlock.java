//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.gui;

import mods.railcraft.common.blocks.machine.epsilon.*;
import net.minecraft.entity.player.*;
import mods.railcraft.common.blocks.*;
import mods.railcraft.common.gui.containers.*;
import mods.railcraft.common.plugins.forge.*;
import mods.railcraft.client.gui.buttons.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.util.List;

import mods.railcraft.common.util.network.*;
import net.minecraft.util.*;

public class GuiEngravingBenchUnlock extends TileGui
{
    private static final String URL_BLOG = "http://railcraft.info/";
    private static final String URL_TWITTER = "https://twitter.com/CovertJaguar";
    private static final String URL_YOUTUBE = "https://www.youtube.com/user/CovertJaguar";
    private final TileEngravingBench tile;
    private final EntityPlayer player;
    private boolean pause;
    private String code;
    private int updateCount;
    
    public GuiEngravingBenchUnlock(final InventoryPlayer inv, final TileEngravingBench tile) {
        super(tile, new ContainerEngravingBenchUnlock(inv, tile), "railcraft:textures/gui/gui_engraving_unlock.png");
        this.pause = false;
        this.code = "";
        this.tile = tile;
        this.player = inv.player;
        this.ySize = 215;
    }
    
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        final int w = (this.width - this.xSize) / 2;
        final int h = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButtonSmall(0, w + 16, h + 77, 50, LocalizationPlugin.translate("railcraft.gui.engrave.unlock")));
        this.buttonList.add(new GuiButtonSmall(1, w + this.xSize - 58, h + this.ySize - 23, 50, StatCollector.translateToLocal("gui.back")));
        this.buttonList.add(new GuiButtonSmall(2, w + 24, h + 146, 128, "The Railcraft Blog"));
        final List<GuiButtonSmall> buttons = new ArrayList<GuiButtonSmall>();
        buttons.add(new GuiButtonSmall(3, 0, h + 162, 80, "CJ's Twitter"));
        buttons.add(new GuiButtonSmall(4, 0, h + 162, 80, "CJ's Youtube"));
        GuiTools.newButtonRow(this.buttonList, w + 7, 2, (List<? extends GuiBetterButton>)buttons);
    }
    
    protected void keyTyped(final char c, final int key) {
        switch (key) {
            case 14: {
                if (this.code.length() > 0) {
                    this.code = this.code.substring(0, this.code.length() - 1);
                }
            }
            case 28: {
                this.attemptUnlock();
            }
            case 1:
            case 15: {
                this.sendUpdateToTile(TileEngravingBench.GuiPacketType.OPEN_NORMAL);
            }
            default: {
                if (this.code.length() < 24 && ChatAllowedCharacters.isAllowedCharacter(c)) {
                    this.code += Character.toString(c);
                }
            }
        }
    }
    
    protected void actionPerformed(final GuiButton button) {
        super.actionPerformed(button);
        this.pause = false;
        switch (button.id) {
            case 0: {
                this.attemptUnlock();
                break;
            }
            case 1: {
                this.sendUpdateToTile(TileEngravingBench.GuiPacketType.OPEN_NORMAL);
                break;
            }
            case 2: {
                this.openLink("http://railcraft.info/");
                break;
            }
            case 3: {
                this.openLink("https://twitter.com/CovertJaguar");
                break;
            }
            case 4: {
                this.openLink("https://www.youtube.com/user/CovertJaguar");
                break;
            }
        }
    }
    
    private void attemptUnlock() {
        if (this.code.length() > 0) {
            this.sendUpdateToTile(TileEngravingBench.GuiPacketType.UNLOCK_EMBLEM);
        }
    }
    
    private void openLink(final String url) {
        this.pause = true;
        try {
            Desktop.getDesktop().browse(new URI(url));
        }
        catch (Exception ex) {}
    }
    
    public void sendUpdateToTile(final TileEngravingBench.GuiPacketType type) {
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final DataOutputStream data = new DataOutputStream(bytes);
        try {
            data.writeByte(type.ordinal());
            switch (type) {
                case UNLOCK_EMBLEM: {
                    data.writeByte(this.container.windowId);
                    data.writeUTF(this.code.toLowerCase(Locale.ENGLISH));
                    break;
                }
            }
        }
        catch (IOException ex) {}
        PacketBuilder.instance().sendGuiReturnPacket(this.tile, bytes.toByteArray());
    }
    
    protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
        GuiTools.drawCenteredString(this.fontRendererObj, this.tile.getName(), 6);
        GuiTools.drawCenteredString(this.fontRendererObj, LocalizationPlugin.translate("railcraft.gui.engrave.entercode"), 28);
        String codeDisplay = this.code;
        if (this.updateCount / 6 % 2 == 0) {
            codeDisplay = codeDisplay + "" + EnumChatFormatting.GRAY + "_";
        }
        else {
            codeDisplay = codeDisplay + "" + EnumChatFormatting.WHITE + "_";
        }
        this.fontRendererObj.drawString(codeDisplay, 13, 50, 16777215, false);
        final String unlockMsg = ((ContainerEngravingBenchUnlock)this.container).unlockMsg;
        int msgColor = 4210752;
        if (unlockMsg != null && !unlockMsg.equals("")) {
            if (unlockMsg.equals("railcraft.gui.engrave.unlock.fail")) {
                msgColor = 16711680;
            }
            this.fontRendererObj.drawString(LocalizationPlugin.translate(unlockMsg), 72, 81, msgColor);
        }
        GuiTools.drawCenteredString(this.fontRendererObj, LocalizationPlugin.translate("railcraft.gui.engrave.getmore1"), 114);
        GuiTools.drawCenteredString(this.fontRendererObj, LocalizationPlugin.translate("railcraft.gui.engrave.getmore2"), 130);
    }
    
    public boolean doesGuiPauseGame() {
        return this.pause;
    }
    
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCount;
    }
}
