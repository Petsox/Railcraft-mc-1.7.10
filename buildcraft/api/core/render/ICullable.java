//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core.render;

import net.minecraftforge.common.util.*;
import net.minecraft.world.*;

public interface ICullable
{
    void setRenderSide(final ForgeDirection p0, final boolean p1);
    
    void setRenderAllSides();
    
    boolean shouldSideBeRendered(final IBlockAccess p0, final int p1, final int p2, final int p3, final int p4);
    
    void setRenderMask(final int p0);
}
