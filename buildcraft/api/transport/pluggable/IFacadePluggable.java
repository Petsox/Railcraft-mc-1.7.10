//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport.pluggable;

import net.minecraft.block.*;

public interface IFacadePluggable
{
    Block getCurrentBlock();
    
    int getCurrentMetadata();
    
    boolean isTransparent();
    
    boolean isHollow();
}
