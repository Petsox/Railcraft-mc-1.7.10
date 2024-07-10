//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.util;

import net.minecraft.entity.player.*;

public interface IKeyboard
{
    boolean isAltKeyDown(final EntityPlayer p0);
    
    boolean isBoostKeyDown(final EntityPlayer p0);
    
    boolean isForwardKeyDown(final EntityPlayer p0);
    
    boolean isJumpKeyDown(final EntityPlayer p0);
    
    boolean isModeSwitchKeyDown(final EntityPlayer p0);
    
    boolean isSideinventoryKeyDown(final EntityPlayer p0);
    
    boolean isHudModeKeyDown(final EntityPlayer p0);
    
    boolean isSneakKeyDown(final EntityPlayer p0);
}
