//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

import java.util.*;
import net.minecraftforge.common.util.*;
import net.minecraft.tileentity.*;

public interface ITriggerProvider
{
    Collection<ITriggerInternal> getInternalTriggers(final IStatementContainer p0);
    
    Collection<ITriggerExternal> getExternalTriggers(final ForgeDirection p0, final TileEntity p1);
}
