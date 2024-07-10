//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.core;

import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class BlockIndex implements Comparable<BlockIndex>
{
    public int x;
    public int y;
    public int z;
    
    public BlockIndex() {
    }
    
    public BlockIndex(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public BlockIndex(final NBTTagCompound c) {
        this.x = c.getInteger("i");
        this.y = c.getInteger("j");
        this.z = c.getInteger("k");
    }
    
    public BlockIndex(final Entity entity) {
        this.x = (int)Math.floor(entity.posX);
        this.y = (int)Math.floor(entity.posY);
        this.z = (int)Math.floor(entity.posZ);
    }
    
    public BlockIndex(final TileEntity entity) {
        this(entity.xCoord, entity.yCoord, entity.zCoord);
    }
    
    @Override
    public int compareTo(final BlockIndex o) {
        if (o.x < this.x) {
            return 1;
        }
        if (o.x > this.x) {
            return -1;
        }
        if (o.z < this.z) {
            return 1;
        }
        if (o.z > this.z) {
            return -1;
        }
        if (o.y < this.y) {
            return 1;
        }
        if (o.y > this.y) {
            return -1;
        }
        return 0;
    }
    
    public void writeTo(final NBTTagCompound c) {
        c.setInteger("i", this.x);
        c.setInteger("j", this.y);
        c.setInteger("k", this.z);
    }
    
    public Block getBlock(final World world) {
        return world.getBlock(this.x, this.y, this.z);
    }
    
    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + ", " + this.z + "}";
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof BlockIndex) {
            final BlockIndex b = (BlockIndex)obj;
            return b.x == this.x && b.y == this.y && b.z == this.z;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.x * 37 + this.y) * 37 + this.z;
    }
    
    public boolean nextTo(final BlockIndex blockIndex) {
        return (Math.abs(blockIndex.x - this.x) <= 1 && blockIndex.y == this.y && blockIndex.z == this.z) || (blockIndex.x == this.x && Math.abs(blockIndex.y - this.y) <= 1 && blockIndex.z == this.z) || (blockIndex.x == this.x && blockIndex.y == this.y && Math.abs(blockIndex.z - this.z) <= 1);
    }
}
