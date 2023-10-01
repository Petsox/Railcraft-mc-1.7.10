//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport;

import net.minecraftforge.common.util.*;
import net.minecraft.item.*;
import buildcraft.api.core.*;

public interface IInjectable
{
    boolean canInjectItems(final ForgeDirection p0);
    
    int injectItem(final ItemStack p0, final boolean p1, final ForgeDirection p2, final EnumColor p3);
}
