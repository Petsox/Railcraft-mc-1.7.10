//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import org.apache.logging.log4j.*;

public final class BCLog
{
    public static final Logger logger;
    
    private BCLog() {
    }
    
    @Deprecated
    public static void logErrorAPI(final String mod, final Throwable error, final Class<?> classFile) {
        logErrorAPI(error, classFile);
    }
    
    public static void logErrorAPI(final Throwable error, final Class<?> classFile) {
        final StringBuilder msg = new StringBuilder("API error! Please update your mods. Error: ");
        msg.append(error);
        final StackTraceElement[] stackTrace = error.getStackTrace();
        if (stackTrace.length > 0) {
            msg.append(", ").append(stackTrace[0]);
        }
        BCLog.logger.log(Level.ERROR, msg.toString());
        if (classFile != null) {
            msg.append("API error: ").append(classFile.getSimpleName()).append(" is loaded from ").append(classFile.getProtectionDomain().getCodeSource().getLocation());
            BCLog.logger.log(Level.ERROR, msg.toString());
        }
    }
    
    @Deprecated
    public static String getVersion() {
        return BuildCraftAPI.getVersion();
    }
    
    static {
        logger = LogManager.getLogger("BuildCraft");
    }
}
