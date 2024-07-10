//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.nbt.*;

public interface IStatementParameter
{
    String getUniqueTag();
    
    @SideOnly(Side.CLIENT)
    IIcon getIcon();
    
    ItemStack getItemStack();
    
    @SideOnly(Side.CLIENT)
    void registerIcons(final IIconRegister p0);
    
    String getDescription();
    
    void onClick(final IStatementContainer p0, final IStatement p1, final ItemStack p2, final StatementMouseClick p3);
    
    void readFromNBT(final NBTTagCompound p0);
    
    void writeToNBT(final NBTTagCompound p0);
    
    IStatementParameter rotateLeft();
}
