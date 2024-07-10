//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.items;

import net.minecraft.item.*;
import buildcraft.api.core.*;
import java.util.*;
import net.minecraftforge.common.util.*;

public interface IMapLocation extends INamedItem
{
    MapLocationType getType(final ItemStack p0);
    
    BlockIndex getPoint(final ItemStack p0);
    
    IBox getBox(final ItemStack p0);
    
    IZone getZone(final ItemStack p0);
    
    List<BlockIndex> getPath(final ItemStack p0);
    
    ForgeDirection getPointSide(final ItemStack p0);
    
    public enum MapLocationType
    {
        CLEAN, 
        SPOT, 
        AREA, 
        PATH, 
        ZONE;
    }
}
