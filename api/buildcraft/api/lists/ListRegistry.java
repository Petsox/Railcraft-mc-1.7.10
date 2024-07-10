//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.lists;

import net.minecraft.item.*;
import java.util.*;

public final class ListRegistry
{
    public static final List<Class<? extends Item>> itemClassAsType;
    private static final List<ListMatchHandler> handlers;
    
    private ListRegistry() {
    }
    
    public static void registerHandler(final ListMatchHandler h) {
        if (h != null) {
            ListRegistry.handlers.add(h);
        }
    }
    
    public static List getHandlers() {
        return Collections.unmodifiableList((List<?>)ListRegistry.handlers);
    }
    
    static {
        itemClassAsType = new ArrayList<Class<? extends Item>>();
        handlers = new ArrayList<ListMatchHandler>();
    }
}
