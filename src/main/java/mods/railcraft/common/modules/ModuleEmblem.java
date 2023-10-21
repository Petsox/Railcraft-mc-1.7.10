//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.modules;

import mods.railcraft.common.util.misc.*;
import cpw.mods.fml.common.*;
import net.minecraftforge.oredict.*;
import java.security.cert.*;
import mods.railcraft.common.emblems.*;
import mods.railcraft.common.items.*;
import net.minecraft.init.*;
import mods.railcraft.common.plugins.forge.*;
import mods.railcraft.common.carts.*;
import mods.railcraft.common.blocks.aesthetics.post.*;
import net.minecraft.item.crafting.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import mods.railcraft.common.gui.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.*;
import mods.railcraft.common.blocks.machine.epsilon.*;
import mods.railcraft.client.gui.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.inventory.*;
import mods.railcraft.common.gui.containers.*;

public class ModuleEmblem extends RailcraftModule
{
    @SidedProxy(clientSide = "mods.railcraft.client.emblems.ClientEmblemProxy", serverSide = "mods.railcraft.common.emblems.EmblemProxy")
    public static EmblemProxy proxy;
    
    @Override
    public void preInit() {
        if (Game.isObfuscated()) {
            try {
                final Class core = Class.forName("mods.railcraft.common.core.Railcraft");
                if (core != null) {
                    final Certificate[] cert = core.getProtectionDomain().getCodeSource().getCertificates();
                    if (cert == null || !CertificateHelper.getFingerprint(cert[0]).equals("a0c255ac501b2749537d5824bb0f0588bf0320fa")) {
                        Game.logErrorFingerprint("Railcraft");
                        throw new RuntimeException("Invalid Fingerprint");
                    }
                }
            }
            catch (ClassNotFoundException ex) {}
        }
        EmblemManager.instance.init();
        RecipeSorter.register("railcraft:locomotive.emblem", (Class)LocomotiveEmblemRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("railcraft:emblem.post.color", (Class)EmblemPostColorRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("railcraft:emblem.post.emblem", (Class)EmblemPostEmblemRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
    }
    
    @Override
    public void initFirst() {
        ItemEmblem.registerItem();
        final EnumMachineEpsilon epsilon = EnumMachineEpsilon.ENGRAVING_BENCH;
        if (epsilon.register()) {
            CraftingPlugin.addShapedRecipe(epsilon.getItem(), "TPB", "PCP", "VPV", 'T', Items.diamond_pickaxe, 'B', Items.book, 'P', RailcraftItem.plate.getRecipeObject((IItemMetaEnum)ItemPlate.EnumPlate.STEEL), 'V', Blocks.piston, 'C', Blocks.crafting_table);
        }
    }
    
    @Override
    public void postInit() {
        ModuleEmblem.proxy.initClient();
        this.addLocomotiveEmblemRecipe(EnumCart.LOCO_STEAM_SOLID);
        this.addLocomotiveEmblemRecipe(EnumCart.LOCO_STEAM_MAGIC);
        this.addLocomotiveEmblemRecipe(EnumCart.LOCO_ELECTRIC);
        if (BlockPost.block != null) {
            CraftingPlugin.addRecipe((IRecipe)new EmblemPostColorRecipe());
            CraftingPlugin.addRecipe((IRecipe)new EmblemPostEmblemRecipe());
        }
    }
    
    private void addLocomotiveEmblemRecipe(final EnumCart cart) {
        final ItemStack locomotive = cart.getCartItem();
        if (locomotive != null) {
            final IRecipe recipe = (IRecipe)new LocomotiveEmblemRecipe(locomotive);
            CraftingPlugin.addRecipe(recipe);
        }
    }
    
    private void printCode(final String code) {
        Game.log(Level.INFO, String.format("Emblem Code: %s - %s", code, EmblemManager.getIdentifierFromCode(code)), new Object[0]);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public GuiScreen getGuiScreen(final EnumGui gui, final InventoryPlayer inv, final Object obj, final World world, final int x, final int y, final int z) {
        switch (gui) {
            case ENGRAVING_BENCH: {
                return (GuiScreen)new GuiEngravingBench(inv, (TileEngravingBench)obj);
            }
            case ENGRAVING_BENCH_UNLOCK: {
                return (GuiScreen)new GuiEngravingBenchUnlock(inv, (TileEngravingBench)obj);
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public Container getGuiContainer(final EnumGui gui, final InventoryPlayer inv, final Object obj, final World world, final int x, final int y, final int z) {
        switch (gui) {
            case ENGRAVING_BENCH: {
                return (Container)new ContainerEngravingBench(inv, (TileEngravingBench)obj);
            }
            case ENGRAVING_BENCH_UNLOCK: {
                return (Container)new ContainerEngravingBenchUnlock(inv, (TileEngravingBench)obj);
            }
            default: {
                return null;
            }
        }
    }
}
