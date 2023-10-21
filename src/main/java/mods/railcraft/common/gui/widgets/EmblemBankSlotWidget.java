//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.gui.widgets;

import mods.railcraft.client.gui.*;
import cpw.mods.fml.relauncher.*;

public class EmblemBankSlotWidget extends EmblemSlotWidget
{
    private final EmblemBankWidget bank;
    public final int index;
    
    EmblemBankSlotWidget(final EmblemBankWidget bank, final int index, final int x, final int y, final int u, final int v) {
        super(x, y, u, v);
        this.bank = bank;
        this.index = index;
    }
    
    @Override
    public boolean mouseClicked(final int mouseX, final int mouseY, final int button) {
        if (button == 0) {
            this.bank.currentSelection = this.getEmblem();
            return true;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void draw(final GuiContainerRailcraft gui, final int guiX, final int guiY, final int mouseX, final int mouseY) {
        super.draw(gui, guiX, guiY, mouseX, mouseY);
        if (!this.bank.currentSelection.equals("") && this.bank.currentSelection.equals(this.getEmblem())) {
            gui.drawTexturedModalRect(guiX + this.x - 2, guiY + this.y - 2, this.u, this.v, this.w + 4, this.h + 4);
        }
    }
    
    @Override
    protected String getEmblem() {
        return this.bank.getEmblem(this.index);
    }
}
