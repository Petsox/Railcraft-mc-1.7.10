//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.library;

import net.minecraft.item.*;

public abstract class LibraryTypeHandler
{
    private final String extension;
    
    public LibraryTypeHandler(final String extension) {
        this.extension = extension;
    }
    
    public abstract boolean isHandler(final ItemStack p0, final HandlerType p1);
    
    public boolean isInputExtension(final String ext) {
        return this.extension.equals(ext);
    }
    
    public String getOutputExtension() {
        return this.extension;
    }
    
    public abstract int getTextColor();
    
    public abstract String getName(final ItemStack p0);
    
    public enum HandlerType
    {
        LOAD, 
        STORE;
    }
}
