//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.lists;

import net.minecraft.item.*;
import java.util.*;

public abstract class ListMatchHandler
{
    public abstract boolean matches(final Type p0, final ItemStack p1, final ItemStack p2, final boolean p3);
    
    public abstract boolean isValidSource(final Type p0, final ItemStack p1);
    
    public List<ItemStack> getClientExamples(final Type type, final ItemStack stack) {
        return null;
    }
    
    public enum Type
    {
        TYPE, 
        MATERIAL, 
        CLASS;
    }
}
