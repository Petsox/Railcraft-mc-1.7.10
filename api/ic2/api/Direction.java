//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api;

import net.minecraftforge.common.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import java.util.*;

public enum Direction
{
    XN, 
    XP, 
    YN, 
    YP, 
    ZN, 
    ZP;
    
    public final int xOffset;
    public final int yOffset;
    public final int zOffset;
    public static final Direction[] directions;
    public static final Set<Direction> noDirections;
    public static final Set<Direction> allDirections;
    
    private Direction() {
        final int side = this.ordinal() / 2;
        final int sign = this.getSign();
        this.xOffset = ((side == 0) ? sign : 0);
        this.yOffset = ((side == 1) ? sign : 0);
        this.zOffset = ((side == 2) ? sign : 0);
    }
    
    public static Direction fromSideValue(final int side) {
        return Direction.directions[(side + 2) % 6];
    }
    
    public static Direction fromForgeDirection(final ForgeDirection dir) {
        if (dir == ForgeDirection.UNKNOWN) {
            return null;
        }
        return fromSideValue(dir.ordinal());
    }
    
    public TileEntity applyToTileEntity(final TileEntity te) {
        return this.applyTo(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
    }
    
    public TileEntity applyTo(final World world, final int x, final int y, final int z) {
        final int[] array;
        final int[] coords = array = new int[] { x, y, z };
        final int n = this.ordinal() / 2;
        array[n] += this.getSign();
        if (world != null && world.blockExists(coords[0], coords[1], coords[2])) {
            try {
                return world.getTileEntity(coords[0], coords[1], coords[2]);
            }
            catch (Exception e) {
                throw new RuntimeException("error getting TileEntity at dim " + world.provider.dimensionId + " " + coords[0] + "/" + coords[1] + "/" + coords[2]);
            }
        }
        return null;
    }
    
    public Direction getInverse() {
        return Direction.directions[this.ordinal() ^ 0x1];
    }
    
    public int toSideValue() {
        return (this.ordinal() + 4) % 6;
    }
    
    private int getSign() {
        return this.ordinal() % 2 * 2 - 1;
    }
    
    public ForgeDirection toForgeDirection() {
        return ForgeDirection.getOrientation(this.toSideValue());
    }
    
    static {
        directions = values();
        noDirections = EnumSet.noneOf(Direction.class);
        allDirections = EnumSet.allOf(Direction.class);
    }
}
