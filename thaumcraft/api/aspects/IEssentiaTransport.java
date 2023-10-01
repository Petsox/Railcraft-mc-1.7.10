//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.aspects;

import net.minecraftforge.common.util.*;

public interface IEssentiaTransport
{
    boolean isConnectable(final ForgeDirection p0);
    
    boolean canInputFrom(final ForgeDirection p0);
    
    boolean canOutputTo(final ForgeDirection p0);
    
    void setSuction(final Aspect p0, final int p1);
    
    Aspect getSuctionType(final ForgeDirection p0);
    
    int getSuctionAmount(final ForgeDirection p0);
    
    int takeEssentia(final Aspect p0, final int p1, final ForgeDirection p2);
    
    int addEssentia(final Aspect p0, final int p1, final ForgeDirection p2);
    
    Aspect getEssentiaType(final ForgeDirection p0);
    
    int getEssentiaAmount(final ForgeDirection p0);
    
    int getMinimumSuction();
    
    boolean renderExtendedTube();
}
