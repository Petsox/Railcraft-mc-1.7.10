//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.library;

import net.minecraft.item.*;
import net.minecraft.nbt.*;

public abstract class LibraryTypeHandlerNBT extends LibraryTypeHandler
{
    public LibraryTypeHandlerNBT(final String extension) {
        super(extension);
    }
    
    public abstract ItemStack load(final ItemStack p0, final NBTTagCompound p1);
    
    public abstract boolean store(final ItemStack p0, final NBTTagCompound p1);
}
