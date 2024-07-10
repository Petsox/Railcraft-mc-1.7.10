//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.util.*;

public enum EnumColor
{
    BLACK, 
    RED, 
    GREEN, 
    BROWN, 
    BLUE, 
    PURPLE, 
    CYAN, 
    LIGHT_GRAY, 
    GRAY, 
    PINK, 
    LIME, 
    YELLOW, 
    LIGHT_BLUE, 
    MAGENTA, 
    ORANGE, 
    WHITE;
    
    public static final EnumColor[] VALUES;
    public static final String[] DYES;
    public static final String[] NAMES;
    public static final int[] DARK_HEX;
    public static final int[] LIGHT_HEX;
    @SideOnly(Side.CLIENT)
    private static IIcon[] brushIcons;
    
    public int getDarkHex() {
        return EnumColor.DARK_HEX[this.ordinal()];
    }
    
    public int getLightHex() {
        return EnumColor.LIGHT_HEX[this.ordinal()];
    }
    
    public static EnumColor fromId(final int id) {
        if (id < 0 || id >= EnumColor.VALUES.length) {
            return EnumColor.WHITE;
        }
        return EnumColor.VALUES[id];
    }
    
    public static EnumColor fromDye(final String dyeTag) {
        for (int id = 0; id < EnumColor.DYES.length; ++id) {
            if (EnumColor.DYES[id].equals(dyeTag)) {
                return EnumColor.VALUES[id];
            }
        }
        return null;
    }
    
    public static EnumColor fromName(final String name) {
        for (int id = 0; id < EnumColor.NAMES.length; ++id) {
            if (EnumColor.NAMES[id].equals(name)) {
                return EnumColor.VALUES[id];
            }
        }
        return null;
    }
    
    public static EnumColor getRand() {
        return EnumColor.VALUES[new Random().nextInt(EnumColor.VALUES.length)];
    }
    
    public EnumColor getNext() {
        final EnumColor next = EnumColor.VALUES[(this.ordinal() + 1) % EnumColor.VALUES.length];
        return next;
    }
    
    public EnumColor getPrevious() {
        final EnumColor previous = EnumColor.VALUES[(this.ordinal() + EnumColor.VALUES.length - 1) % EnumColor.VALUES.length];
        return previous;
    }
    
    public EnumColor inverse() {
        return EnumColor.VALUES[15 - this.ordinal()];
    }
    
    public String getTag() {
        return "color." + this.name().replace("_", ".").toLowerCase(Locale.ENGLISH);
    }
    
    public String getBasicTag() {
        return this.name().replace("_", ".").toLowerCase(Locale.ENGLISH);
    }
    
    public String getName() {
        return EnumColor.NAMES[this.ordinal()];
    }
    
    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getTag());
    }
    
    public String getDye() {
        return EnumColor.DYES[this.ordinal()];
    }
    
    @Override
    public String toString() {
        final String s = this.name().replace("_", " ");
        final String[] words = s.split(" ");
        final StringBuilder b = new StringBuilder();
        for (final String word : words) {
            b.append(word.charAt(0)).append(word.substring(1).toLowerCase(Locale.ENGLISH)).append(" ");
        }
        return b.toString().trim();
    }
    
    public static void setIconArray(final IIcon[] icons) {
        EnumColor.brushIcons = icons;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return EnumColor.brushIcons[this.ordinal()];
    }
    
    static {
        VALUES = values();
        DYES = new String[] { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite" };
        NAMES = new String[] { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };
        DARK_HEX = new int[] { 2960685, 10696757, 3755038, 6044196, 3424674, 8667071, 3571870, 8947848, 4473924, 15041952, 4172342, 13615665, 8362705, 16737535, 16738816, 16777215 };
        LIGHT_HEX = new int[] { 1578004, 12462887, 32526, 8998957, 2437523, 8271039, 2725785, 10528679, 8026746, 14250393, 3790126, 16767260, 6728447, 14238662, 15366197, 15000804 };
    }
}
