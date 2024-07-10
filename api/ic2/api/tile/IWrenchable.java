//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.tile;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public interface IWrenchable
{
    boolean wrenchCanSetFacing(final EntityPlayer p0, final int p1);
    
    short getFacing();
    
    void setFacing(final short p0);
    
    boolean wrenchCanRemove(final EntityPlayer p0);
    
    float getWrenchDropRate();
    
    ItemStack getWrenchDrop(final EntityPlayer p0);
}
