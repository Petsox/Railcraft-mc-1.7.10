//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.items;

import net.minecraft.item.*;

public interface IBlueprintItem extends INamedItem
{
    Type getType(final ItemStack p0);
    
    public enum Type
    {
        TEMPLATE, 
        BLUEPRINT;
    }
}
