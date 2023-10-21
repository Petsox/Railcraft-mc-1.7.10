//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.emblems;

import mods.railcraft.common.emblems.*;
import mods.railcraft.client.render.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;

public class ClientEmblemProxy extends EmblemProxy
{
    @Override
    public void initClient() {
        EmblemRenderHelper.instance.init();
        EmblemPackageManager.instance.init();
        EmblemPackageManager.instance.loadEmblems();
        if (ItemEmblem.item != null) {
            MinecraftForgeClient.registerItemRenderer((Item)ItemEmblem.item, (IItemRenderer)new RenderEmblemItem());
        }
    }
}
