//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;

public interface IIconProvider
{
    @SideOnly(Side.CLIENT)
    IIcon getIcon(final int p0);
    
    @SideOnly(Side.CLIENT)
    void registerIcons(final IIconRegister p0);
}
