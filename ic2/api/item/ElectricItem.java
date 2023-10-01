//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;
import java.util.*;

public final class ElectricItem
{
    public static IElectricItemManager manager;
    public static IElectricItemManager rawManager;
    private static final List<IBackupElectricItemManager> backupManagers;
    
    public static void registerBackupManager(final IBackupElectricItemManager manager) {
        ElectricItem.backupManagers.add(manager);
    }
    
    public static IBackupElectricItemManager getBackupManager(final ItemStack stack) {
        for (final IBackupElectricItemManager manager : ElectricItem.backupManagers) {
            if (manager.handles(stack)) {
                return manager;
            }
        }
        return null;
    }
    
    static {
        backupManagers = new ArrayList<IBackupElectricItemManager>();
    }
}
