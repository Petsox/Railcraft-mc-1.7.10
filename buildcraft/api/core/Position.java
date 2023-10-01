//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraftforge.common.util.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import io.netty.buffer.*;

public class Position implements ISerializable
{
    public double x;
    public double y;
    public double z;
    public ForgeDirection orientation;
    
    public Position() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.orientation = ForgeDirection.UNKNOWN;
    }
    
    public Position(final double ci, final double cj, final double ck) {
        this.x = ci;
        this.y = cj;
        this.z = ck;
        this.orientation = ForgeDirection.UNKNOWN;
    }
    
    public Position(final double ci, final double cj, final double ck, final ForgeDirection corientation) {
        this.x = ci;
        this.y = cj;
        this.z = ck;
        this.orientation = corientation;
        if (this.orientation == null) {
            this.orientation = ForgeDirection.UNKNOWN;
        }
    }
    
    public Position(final Position p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
        this.orientation = p.orientation;
    }
    
    public Position(final NBTTagCompound nbttagcompound) {
        this.readFromNBT(nbttagcompound);
    }
    
    public Position(final TileEntity tile) {
        this.x = tile.xCoord;
        this.y = tile.yCoord;
        this.z = tile.zCoord;
        this.orientation = ForgeDirection.UNKNOWN;
    }
    
    public Position(final BlockIndex index) {
        this.x = index.x;
        this.y = index.y;
        this.z = index.z;
        this.orientation = ForgeDirection.UNKNOWN;
    }
    
    public void moveRight(final double step) {
        switch (this.orientation) {
            case SOUTH: {
                this.x -= step;
                break;
            }
            case NORTH: {
                this.x += step;
                break;
            }
            case EAST: {
                this.z += step;
                break;
            }
            case WEST: {
                this.z -= step;
                break;
            }
        }
    }
    
    public void moveLeft(final double step) {
        this.moveRight(-step);
    }
    
    public void moveForwards(final double step) {
        switch (this.orientation) {
            case UP: {
                this.y += step;
                break;
            }
            case DOWN: {
                this.y -= step;
                break;
            }
            case SOUTH: {
                this.z += step;
                break;
            }
            case NORTH: {
                this.z -= step;
                break;
            }
            case EAST: {
                this.x += step;
                break;
            }
            case WEST: {
                this.x -= step;
                break;
            }
        }
    }
    
    public void moveBackwards(final double step) {
        this.moveForwards(-step);
    }
    
    public void moveUp(final double step) {
        switch (this.orientation) {
            case SOUTH:
            case NORTH:
            case EAST:
            case WEST: {
                this.y += step;
                break;
            }
        }
    }
    
    public void moveDown(final double step) {
        this.moveUp(-step);
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound) {
        if (this.orientation == null) {
            this.orientation = ForgeDirection.UNKNOWN;
        }
        nbttagcompound.setDouble("i", this.x);
        nbttagcompound.setDouble("j", this.y);
        nbttagcompound.setDouble("k", this.z);
        nbttagcompound.setByte("orientation", (byte)this.orientation.ordinal());
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        this.x = nbttagcompound.getDouble("i");
        this.y = nbttagcompound.getDouble("j");
        this.z = nbttagcompound.getDouble("k");
        this.orientation = ForgeDirection.values()[nbttagcompound.getByte("orientation")];
    }
    
    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + ", " + this.z + "}";
    }
    
    public Position min(final Position p) {
        return new Position((p.x > this.x) ? this.x : p.x, (p.y > this.y) ? this.y : p.y, (p.z > this.z) ? this.z : p.z);
    }
    
    public Position max(final Position p) {
        return new Position((p.x < this.x) ? this.x : p.x, (p.y < this.y) ? this.y : p.y, (p.z < this.z) ? this.z : p.z);
    }
    
    public boolean isClose(final Position newPosition, final float f) {
        final double dx = this.x - newPosition.x;
        final double dy = this.y - newPosition.y;
        final double dz = this.z - newPosition.z;
        final double sqrDis = dx * dx + dy * dy + dz * dz;
        return sqrDis <= f * f;
    }
    
    public void readData(final ByteBuf stream) {
        this.x = stream.readDouble();
        this.y = stream.readDouble();
        this.z = stream.readDouble();
        this.orientation = ForgeDirection.getOrientation((int)stream.readByte());
    }
    
    public void writeData(final ByteBuf stream) {
        stream.writeDouble(this.x);
        stream.writeDouble(this.y);
        stream.writeDouble(this.z);
        stream.writeByte(this.orientation.ordinal());
    }
    
    @Override
    public int hashCode() {
        return 51 * (int)this.x + 13 * (int)this.y + (int)this.z;
    }
}
