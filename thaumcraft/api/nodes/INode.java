//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.nodes;

import thaumcraft.api.aspects.*;

public interface INode extends IAspectContainer
{
    String getId();
    
    AspectList getAspectsBase();
    
    NodeType getNodeType();
    
    void setNodeType(final NodeType p0);
    
    void setNodeModifier(final NodeModifier p0);
    
    NodeModifier getNodeModifier();
    
    int getNodeVisBase(final Aspect p0);
    
    void setNodeVisBase(final Aspect p0, final short p1);
}
