//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;

public interface IStatement
{
    String getUniqueTag();
    
    @SideOnly(Side.CLIENT)
    IIcon getIcon();
    
    @SideOnly(Side.CLIENT)
    void registerIcons(final IIconRegister p0);
    
    int maxParameters();
    
    int minParameters();
    
    String getDescription();
    
    IStatementParameter createParameter(final int p0);
    
    IStatement rotateLeft();
}
