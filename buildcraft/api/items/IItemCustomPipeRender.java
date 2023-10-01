//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.items;

import net.minecraft.item.*;
import cpw.mods.fml.relauncher.*;

public interface IItemCustomPipeRender
{
    float getPipeRenderScale(final ItemStack p0);
    
    @SideOnly(Side.CLIENT)
    boolean renderItemInPipe(final ItemStack p0, final double p1, final double p2, final double p3);
}
