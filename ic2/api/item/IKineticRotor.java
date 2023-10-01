//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;
import net.minecraft.util.*;

public interface IKineticRotor
{
    int getDiameter(final ItemStack p0);
    
    ResourceLocation getRotorRenderTexture(final ItemStack p0);
    
    float getEfficiency(final ItemStack p0);
    
    int getMinWindStrength(final ItemStack p0);
    
    int getMaxWindStrength(final ItemStack p0);
    
    boolean isAcceptedType(final ItemStack p0, final GearboxType p1);
    
    public enum GearboxType
    {
        WATER, 
        WIND;
    }
}
