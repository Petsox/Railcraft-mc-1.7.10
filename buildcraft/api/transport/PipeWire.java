//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import java.util.*;
import net.minecraft.item.*;

public enum PipeWire
{
    RED, 
    BLUE, 
    GREEN, 
    YELLOW;
    
    public static Item item;
    public static final PipeWire[] VALUES;
    
    public PipeWire reverse() {
        switch (this) {
            case RED: {
                return PipeWire.YELLOW;
            }
            case BLUE: {
                return PipeWire.GREEN;
            }
            case GREEN: {
                return PipeWire.BLUE;
            }
            default: {
                return PipeWire.RED;
            }
        }
    }
    
    public String getTag() {
        return this.name().toLowerCase(Locale.ENGLISH) + "PipeWire";
    }
    
    public String getColor() {
        final String name = this.toString().toLowerCase(Locale.ENGLISH);
        final char first = Character.toUpperCase(name.charAt(0));
        return first + name.substring(1);
    }
    
    public ItemStack getStack() {
        return this.getStack(1);
    }
    
    public ItemStack getStack(final int qty) {
        if (PipeWire.item == null) {
            return null;
        }
        return new ItemStack(PipeWire.item, qty, this.ordinal());
    }
    
    public boolean isPipeWire(final ItemStack stack) {
        return stack != null && stack.getItem() == PipeWire.item && stack.getItemDamage() == this.ordinal();
    }
    
    public static PipeWire fromOrdinal(final int ordinal) {
        if (ordinal < 0 || ordinal >= PipeWire.VALUES.length) {
            return PipeWire.RED;
        }
        return PipeWire.VALUES[ordinal];
    }
    
    static {
        VALUES = values();
    }
}
