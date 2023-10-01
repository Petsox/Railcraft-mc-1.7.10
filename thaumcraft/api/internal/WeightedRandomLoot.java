//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package thaumcraft.api.internal;

import net.minecraft.util.*;
import net.minecraft.item.*;
import java.util.*;

public class WeightedRandomLoot extends WeightedRandom.Item
{
    public ItemStack item;
    public static ArrayList<WeightedRandomLoot> lootBagCommon;
    public static ArrayList<WeightedRandomLoot> lootBagUncommon;
    public static ArrayList<WeightedRandomLoot> lootBagRare;
    
    public WeightedRandomLoot(final ItemStack stack, final int weight) {
        super(weight);
        this.item = stack;
    }
    
    static {
        WeightedRandomLoot.lootBagCommon = new ArrayList<WeightedRandomLoot>();
        WeightedRandomLoot.lootBagUncommon = new ArrayList<WeightedRandomLoot>();
        WeightedRandomLoot.lootBagRare = new ArrayList<WeightedRandomLoot>();
    }
}
