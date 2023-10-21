//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.gui.widgets;

import mods.railcraft.client.gui.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import mods.railcraft.common.gui.tooltips.*;
import mods.railcraft.client.emblems.*;

public class EmblemSlotWidget extends Widget
{
    public String emblemIdentifier;
    private final ToolTip toolTip;
    
    public EmblemSlotWidget(final int x, final int y, final int u, final int v) {
        super(x, y, u, v, 16, 16);
        this.toolTip = new ToolTip(750);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void draw(final GuiContainerRailcraft gui, final int guiX, final int guiY, final int mouseX, final int mouseY) {
        final String emblem = this.getEmblem();
        if (emblem != null && !emblem.equals("")) {
            final EmblemTexture emblemTexture = EmblemPackageManager.instance.getEmblemTexture(emblem);
            gui.bindTexture(emblemTexture.getLocation());
            gui.drawTexture(guiX + this.x, guiY + this.y, 16, 16, 0.0f, 0.0f, 1.0f, 1.0f);
            gui.bindTexture(gui.texture);
        }
        if (this.isMouseOver(mouseX, mouseY)) {
            gui.drawGradientRect(guiX + this.x, guiY + this.y, guiX + this.x + 16, guiY + this.y + 16, -2130706433, -2130706433);
        }
    }
    
    protected String getEmblem() {
        return this.emblemIdentifier;
    }
    
    @Override
    public ToolTip getToolTip() {
        this.toolTip.clear();
        final String emblemIdent = this.getEmblem();
        if (emblemIdent == null || emblemIdent.equals("")) {
            return null;
        }
        final Emblem emblem = EmblemPackageManager.instance.getEmblem(emblemIdent);
        if (emblem == null) {
            return null;
        }
        this.toolTip.add(((Object)new ToolTipLine(emblem.displayName, EnumRarity.values()[emblem.rarity].rarityColor)).toString());
        return this.toolTip;
    }
}
