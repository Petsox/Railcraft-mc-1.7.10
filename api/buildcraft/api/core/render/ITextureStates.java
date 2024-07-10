//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core.render;

import net.minecraft.util.*;
import net.minecraft.block.*;

public interface ITextureStates extends ICullable
{
    ITextureStateManager getTextureState();
    
    IIcon getIcon(final int p0, final int p1);
    
    Block getBlock();
}
