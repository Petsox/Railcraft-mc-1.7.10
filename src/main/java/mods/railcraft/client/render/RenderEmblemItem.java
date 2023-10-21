//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.*;
import net.minecraft.item.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;
import mods.railcraft.common.emblems.*;

import mods.railcraft.client.emblems.*;
import net.minecraft.util.*;
import java.util.*;

public class RenderEmblemItem implements IItemRenderer
{
    private static final ResourceLocation GLINT_TEXTURE;
    private static final RenderItem renderItem;
    
    public boolean handleRenderType(final ItemStack stack, final ItemRenderType type) {
        return type == ItemRenderType.ENTITY || type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED;
    }
    
    public boolean shouldUseRenderHelper(final ItemRenderType type, final ItemStack stack, final ItemRendererHelper helper) {
        return helper == ItemRendererHelper.ENTITY_BOBBING;
    }
    
    public void renderItem(final ItemRenderType type, final ItemStack stack, final Object... data) {
        if (type == ItemRenderType.INVENTORY) {
            this.render(ItemRenderType.INVENTORY, stack);
        }
        else if (type == ItemRenderType.ENTITY) {
            if (RenderManager.instance.options.fancyGraphics) {
                this.renderAsEntity(stack, (EntityItem)data[1]);
            }
            else {
                this.renderAsEntityFlat(stack, (EntityItem)data[1]);
            }
        }
        else if (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            this.renderEquiped(stack, (EntityLivingBase)data[1]);
            GL11.glPopMatrix();
        }
    }
    
    private void renderEquiped(final ItemStack stack, final EntityLivingBase entity) {
        GL11.glPushMatrix();
        final Tessellator tessellator = Tessellator.instance;
        for (int meta = stack.getItemDamage(), pass = 0; pass < stack.getItem().getRenderPasses(meta); ++pass) {
            final int color = stack.getItem().getColorFromItemStack(stack, pass);
            final float c1 = (color >> 16 & 0xFF) / 255.0f;
            final float c2 = (color >> 8 & 0xFF) / 255.0f;
            final float c3 = (color & 0xFF) / 255.0f;
            if (RenderEmblemItem.renderItem.renderWithColor) {
                GL11.glColor4f(c1, c2, c3, 1.0f);
            }
            final String emblemIdentifier = EmblemToolsServer.getEmblemIdentifier(stack);
            if (emblemIdentifier != null && !emblemIdentifier.equals("")) {
                final EmblemTexture texture = EmblemPackageManager.instance.getEmblemTexture(emblemIdentifier);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture.getLocation());
                ItemRenderer.renderItemIn2D(tessellator, 1.0f, 0.0f, 0.0f, 1.0f, texture.getImage().getWidth(), texture.getImage().getHeight(), 0.0625f);
            }
            else {
                final IIcon icon = stack.getItem().getIconFromDamageForRenderPass(meta, pass);
                ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
            }
            if (stack.hasEffect(pass)) {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                Minecraft.getMinecraft().renderEngine.bindTexture(RenderEmblemItem.GLINT_TEXTURE);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                final float f7 = 0.76f;
                GL11.glColor4f(0.5f * f7, 0.25f * f7, 0.8f * f7, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                final float f8 = 0.125f;
                GL11.glScalef(f8, f8, f8);
                float f9 = Minecraft.getSystemTime() % 3000L / 3000.0f * 8.0f;
                GL11.glTranslatef(f9, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
                GL11.glTranslatef(-f9, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 256, 256, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
        }
        GL11.glPopMatrix();
    }
    
    private void renderAsEntity(final ItemStack stack, final EntityItem entity) {
        GL11.glPushMatrix();
        byte iterations = 1;
        if (stack.stackSize > 1) {
            iterations = 2;
        }
        if (stack.stackSize > 15) {
            iterations = 3;
        }
        if (stack.stackSize > 31) {
            iterations = 4;
        }
        final Random rand = new Random(187L);
        final float offsetZ = 0.084375f;
        GL11.glRotatef(((entity.age + 1.0f) / 20.0f + entity.hoverStart) * 57.295776f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.25f, -(offsetZ * iterations / 2.0f));
        for (int count = 0; count < iterations; ++count) {
            if (count > 0) {
                final float offsetX = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                final float offsetY = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                final float z = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f / 0.5f;
                GL11.glTranslatef(offsetX, offsetY, offsetZ);
            }
            else {
                GL11.glTranslatef(0.0f, 0.0f, offsetZ);
            }
            EmblemRenderHelper.instance.renderIn3D(stack, false);
        }
        GL11.glPopMatrix();
    }
    
    private void renderAsEntityFlat(final ItemStack stack, final EntityItem entity) {
        GL11.glPushMatrix();
        byte iterations = 1;
        if (stack.stackSize > 1) {
            iterations = 2;
        }
        if (stack.stackSize > 15) {
            iterations = 3;
        }
        if (stack.stackSize > 31) {
            iterations = 4;
        }
        final Random rand = new Random(187L);
        for (int ii = 0; ii < iterations; ++ii) {
            GL11.glPushMatrix();
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            if (!RenderItem.renderInFrame) {
                GL11.glRotatef(180.0f - RenderManager.instance.playerViewY, 0.0f, 1.0f, 0.0f);
            }
            if (ii > 0) {
                final float var12 = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f;
                final float var13 = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f;
                final float var14 = (rand.nextFloat() * 2.0f - 1.0f) * 0.3f;
                GL11.glTranslatef(var12, var13, var14);
            }
            GL11.glTranslatef(0.5f, 0.8f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(0.0625f, 0.0625f, 1.0f);
            this.render(ItemRenderType.ENTITY, stack);
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
    }
    
    private void render(final ItemRenderType type, final ItemStack stack) {
        GL11.glPushMatrix();
        GL11.glDisable(2896);
        final String emblemIdentifier = EmblemToolsServer.getEmblemIdentifier(stack);
        if (emblemIdentifier != null && !emblemIdentifier.equals("")) {
            this.renderTextureObject(0, 0, EmblemPackageManager.instance.getEmblemTexture(emblemIdentifier).getLocation(), 16, 16);
        }
        else {
            final IIcon icon = stack.getItem().getIconFromDamageForRenderPass(0, 0);
            RenderEmblemItem.renderItem.renderIcon(0, 0, icon, 16, 16);
        }
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
    
    public void renderTextureObject(final int x, final int y, final ResourceLocation texture, final int width, final int height) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)RenderEmblemItem.renderItem.zLevel, 0.0, 1.0);
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)RenderEmblemItem.renderItem.zLevel, 1.0, 1.0);
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)RenderEmblemItem.renderItem.zLevel, 1.0, 0.0);
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)RenderEmblemItem.renderItem.zLevel, 0.0, 0.0);
        tessellator.draw();
    }
    
    static {
        GLINT_TEXTURE = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        renderItem = new RenderItem();
    }
}
