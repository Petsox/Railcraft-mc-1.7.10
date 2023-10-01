//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tablet;

import cpw.mods.fml.relauncher.*;
import net.minecraft.nbt.*;

public interface ITablet
{
    Side getSide();
    
    void refreshScreen(final TabletBitmap p0);
    
    int getScreenWidth();
    
    int getScreenHeight();
    
    void launchProgram(final String p0);
    
    void sendMessage(final NBTTagCompound p0);
}
