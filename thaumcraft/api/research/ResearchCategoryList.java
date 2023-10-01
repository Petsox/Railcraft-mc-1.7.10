//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.research;

import net.minecraft.util.*;
import java.util.*;

public class ResearchCategoryList
{
    public int minDisplayColumn;
    public int minDisplayRow;
    public int maxDisplayColumn;
    public int maxDisplayRow;
    public ResourceLocation icon;
    public ResourceLocation background;
    public Map<String, ResearchItem> research;
    
    public ResearchCategoryList(final ResourceLocation icon, final ResourceLocation background) {
        this.research = new HashMap<String, ResearchItem>();
        this.icon = icon;
        this.background = background;
    }
}
