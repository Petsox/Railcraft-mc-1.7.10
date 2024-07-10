//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.transport.pluggable;

import buildcraft.api.core.*;
import buildcraft.api.transport.*;
import net.minecraft.item.*;
import net.minecraftforge.common.util.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;

public abstract class PipePluggable implements INBTStoreable, ISerializable
{
    public abstract ItemStack[] getDropItems(final IPipeTile p0);
    
    public void update(final IPipeTile pipe, final ForgeDirection direction) {
    }
    
    public void onAttachedPipe(final IPipeTile pipe, final ForgeDirection direction) {
        this.validate(pipe, direction);
    }
    
    public void onDetachedPipe(final IPipeTile pipe, final ForgeDirection direction) {
        this.invalidate();
    }
    
    public abstract boolean isBlocking(final IPipeTile p0, final ForgeDirection p1);
    
    public void invalidate() {
    }
    
    public void validate(final IPipeTile pipe, final ForgeDirection direction) {
    }
    
    public boolean isSolidOnSide(final IPipeTile pipe, final ForgeDirection direction) {
        return false;
    }
    
    public abstract AxisAlignedBB getBoundingBox(final ForgeDirection p0);
    
    @SideOnly(Side.CLIENT)
    public abstract IPipePluggableRenderer getRenderer();
    
    @SideOnly(Side.CLIENT)
    public IPipePluggableDynamicRenderer getDynamicRenderer() {
        return null;
    }
    
    public boolean requiresRenderUpdate(final PipePluggable old) {
        return true;
    }
}
