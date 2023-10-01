//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import buildcraft.api.transport.pluggable.*;
import net.minecraft.world.*;
import java.util.*;

public abstract class PipeManager
{
    public static List<IStripesHandler> stripesHandlers;
    public static ArrayList<Class<? extends PipePluggable>> pipePluggables;
    private static Map<String, Class<? extends PipePluggable>> pipePluggableNames;
    private static Map<Class<? extends PipePluggable>, String> pipePluggableByNames;
    private static Map<IStripesHandler, Integer> stripesHandlerPriorities;
    
    @Deprecated
    public static boolean canExtractItems(final Object extractor, final World world, final int i, final int j, final int k) {
        return true;
    }
    
    @Deprecated
    public static boolean canExtractFluids(final Object extractor, final World world, final int i, final int j, final int k) {
        return true;
    }
    
    @Deprecated
    public static void registerStripesHandler(final IStripesHandler handler) {
        registerStripesHandler(handler, 0);
    }
    
    public static void registerStripesHandler(final IStripesHandler handler, final int priority) {
        PipeManager.stripesHandlers.add(handler);
        PipeManager.stripesHandlerPriorities.put(handler, priority);
        Collections.sort(PipeManager.stripesHandlers, new Comparator<IStripesHandler>() {
            @Override
            public int compare(final IStripesHandler o1, final IStripesHandler o2) {
                return PipeManager.stripesHandlerPriorities.get(o2) - PipeManager.stripesHandlerPriorities.get(o1);
            }
        });
    }
    
    public static void registerPipePluggable(final Class<? extends PipePluggable> pluggable, final String name) {
        PipeManager.pipePluggables.add(pluggable);
        PipeManager.pipePluggableNames.put(name, pluggable);
        PipeManager.pipePluggableByNames.put(pluggable, name);
    }
    
    public static Class<?> getPluggableByName(final String pluggableName) {
        return PipeManager.pipePluggableNames.get(pluggableName);
    }
    
    public static String getPluggableName(final Class<? extends PipePluggable> aClass) {
        return PipeManager.pipePluggableByNames.get(aClass);
    }
    
    static {
        PipeManager.stripesHandlers = new ArrayList<IStripesHandler>();
        PipeManager.pipePluggables = new ArrayList<Class<? extends PipePluggable>>();
        PipeManager.pipePluggableNames = new HashMap<String, Class<? extends PipePluggable>>();
        PipeManager.pipePluggableByNames = new HashMap<Class<? extends PipePluggable>, String>();
        PipeManager.stripesHandlerPriorities = new HashMap<IStripesHandler, Integer>();
    }
}
