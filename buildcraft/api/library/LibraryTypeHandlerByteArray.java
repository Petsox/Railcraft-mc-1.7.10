//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.library;

import net.minecraft.item.*;

public abstract class LibraryTypeHandlerByteArray extends LibraryTypeHandler
{
    public LibraryTypeHandlerByteArray(final String extension) {
        super(extension);
    }
    
    public abstract ItemStack load(final ItemStack p0, final byte[] p1);
    
    public abstract byte[] store(final ItemStack p0);
}
