//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.library;

import java.util.*;

public final class LibraryAPI
{
    private static final Set<LibraryTypeHandler> handlers;
    
    private LibraryAPI() {
    }
    
    public static Set<LibraryTypeHandler> getHandlerSet() {
        return LibraryAPI.handlers;
    }
    
    public static void registerHandler(final LibraryTypeHandler handler) {
        LibraryAPI.handlers.add(handler);
    }
    
    public static LibraryTypeHandler getHandlerFor(final String extension) {
        for (final LibraryTypeHandler h : LibraryAPI.handlers) {
            if (h.isInputExtension(extension)) {
                return h;
            }
        }
        return null;
    }
    
    static {
        handlers = new HashSet<LibraryTypeHandler>();
    }
}
