//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.aspects;

public interface IAspectContainer
{
    AspectList getAspects();
    
    void setAspects(final AspectList p0);
    
    boolean doesContainerAccept(final Aspect p0);
    
    int addToContainer(final Aspect p0, final int p1);
    
    boolean takeFromContainer(final Aspect p0, final int p1);
    
    @Deprecated
    boolean takeFromContainer(final AspectList p0);
    
    boolean doesContainerContainAmount(final Aspect p0, final int p1);
    
    @Deprecated
    boolean doesContainerContain(final AspectList p0);
    
    int containerContains(final Aspect p0);
}
