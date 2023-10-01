//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.damagesource;

import net.minecraft.entity.*;
import net.minecraft.util.*;

public class DamageSourceIndirectThaumcraftEntity extends EntityDamageSourceIndirect
{
    private boolean fireDamage;
    private float hungerDamage;
    private boolean isUnblockable;
    
    public DamageSourceIndirectThaumcraftEntity(final String par1Str, final Entity par2Entity, final Entity par3Entity) {
        super(par1Str, par2Entity, par3Entity);
    }
    
    public DamageSource setFireDamage() {
        this.fireDamage = true;
        return (DamageSource)this;
    }
    
    public DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return (DamageSource)this;
    }
}
