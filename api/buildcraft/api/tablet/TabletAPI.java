//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tablet;

import java.util.*;

public final class TabletAPI
{
    private static final Map<String, TabletProgramFactory> programs;
    
    private TabletAPI() {
    }
    
    public static void registerProgram(final TabletProgramFactory factory) {
        TabletAPI.programs.put(factory.getName(), factory);
    }
    
    public static TabletProgramFactory getProgram(final String name) {
        return TabletAPI.programs.get(name);
    }
    
    static {
        programs = new HashMap<String, TabletProgramFactory>();
    }
}
