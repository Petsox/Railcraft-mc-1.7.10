//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import java.util.*;

public final class JavaTools
{
    private JavaTools() {
    }
    
    public static <T> T[] concat(final T[] first, final T[] second) {
        final T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    public static int[] concat(final int[] first, final int[] second) {
        final int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    public static float[] concat(final float[] first, final float[] second) {
        final float[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    public static String surroundWithQuotes(final String stringToSurroundWithQuotes) {
        return String.format("\"%s\"", stringToSurroundWithQuotes);
    }
    
    public static String stripSurroundingQuotes(final String stringToStripQuotes) {
        return stringToStripQuotes.replaceAll("^\"|\"$", "");
    }
}
