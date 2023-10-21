//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.gui.widgets;

import mods.railcraft.common.util.collections.*;
import mods.railcraft.common.gui.containers.*;
import mods.railcraft.client.gui.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import mods.railcraft.common.emblems.*;
import java.util.*;
import java.io.*;
import cpw.mods.fml.relauncher.*;

public class EmblemBankWidget extends Widget
{
    private static final int NUM_SLOTS = 7;
    private List<EmblemSlotWidget> slots;
    private RevolvingList<List<String>> emblems;
    String currentSelection;
    
    public EmblemBankWidget(final int x, final int y, final String currentEmblem) {
        super(x, y, 182, 12, 126, 18);
        this.slots = new ArrayList<EmblemSlotWidget>(7);
        this.emblems = new RevolvingList<List<String>>();
        this.currentSelection = "";
        for (int i = 0; i < 7; ++i) {
            this.slots.add((EmblemSlotWidget)new EmblemBankSlotWidget(this, i, x + 1 + i * 18, y + 1, this.u, this.v));
        }
        this.currentSelection = currentEmblem;
    }
    
    @Override
    public void addToContainer(final RailcraftContainer container) {
        super.addToContainer(container);
        for (final EmblemSlotWidget slot : this.slots) {
            container.addWidget((Widget)slot);
        }
    }
    
    public List<EmblemSlotWidget> getSlots() {
        return this.slots;
    }
    
    public String getEmblem(final int index) {
        final List<String> view = this.emblems.getCurrent();
        if (view == null || index >= view.size()) {
            return "";
        }
        return view.get(index);
    }
    
    public String getSelectedEmblem() {
        return this.currentSelection;
    }
    
    public void shiftLeft() {
        this.emblems.rotateLeft();
    }
    
    public void shiftRight() {
        this.emblems.rotateRight();
    }
    
    @Override
    public void draw(final GuiContainerRailcraft gui, final int guiX, final int guiY, final int mouseX, final int mouseY) {
    }
    
    @Override
    public void initWidget(final ICrafting player) {
        try {
            final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            final DataOutputStream data = new DataOutputStream(bytes);
            data.writeUTF(this.currentSelection);
            final Set<String> unlockedEmblems = (Set<String>)EmblemManager.getUnlockedEmblems((EntityPlayer)player);
            data.writeShort(unlockedEmblems.size());
            for (final String s : unlockedEmblems) {
                data.writeUTF(s);
            }
            this.container.sendWidgetDataToClient((Widget)this, player, bytes.toByteArray());
        }
        catch (IOException ex) {}
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void handleClientPacketData(final DataInputStream data) throws IOException {
        this.currentSelection = data.readUTF();
        final int count = data.readShort();
        int subIndex = 0;
        List<String> currentView;
        List<String> emblemView = currentView = new ArrayList<String>(7);
        for (int i = 0; i < count; ++i) {
            if (subIndex >= 7) {
                subIndex = 0;
                this.emblems.add((List<String>) emblemView);
                emblemView = new ArrayList<String>(7);
            }
            final String identifier = data.readUTF();
            emblemView.add(identifier);
            if (this.currentSelection.equals(identifier)) {
                currentView = emblemView;
            }
            ++subIndex;
        }
        this.emblems.add((List<String>) emblemView);
        this.emblems.setCurrent(currentView);
    }
}
