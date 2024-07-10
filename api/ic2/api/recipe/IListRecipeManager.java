//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.recipe;

import net.minecraft.item.*;
import java.util.*;

public interface IListRecipeManager extends Iterable<IRecipeInput>
{
    void add(final IRecipeInput p0);
    
    boolean contains(final ItemStack p0);
    
    boolean isEmpty();
    
    List<IRecipeInput> getInputs();
}
