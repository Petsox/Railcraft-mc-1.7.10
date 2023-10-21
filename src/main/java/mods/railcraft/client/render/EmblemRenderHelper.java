//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.render;

import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import mods.railcraft.common.emblems.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.*;
import mods.railcraft.client.emblems.*;

public class EmblemRenderHelper implements IEmblemItemRenderer
{
    public static final EmblemRenderHelper instance;
    private static final ResourceLocation GLINT_TEXTURE;
    private static final RenderItem renderItem;
    
    public void init() {
    }
    
    public void renderIn3D(final String ident, final boolean renderGlint) {
        this.renderIn3D(ItemEmblem.getEmblem(ident), renderGlint);
    }
    
    public void renderIn3D(final ItemStack stack, final boolean renderGlint) {
        GL11.glPushMatrix();
        final Tessellator tessellator = Tessellator.instance;
        for (int meta = stack.getItemDamage(), pass = 0; pass < stack.getItem().getRenderPasses(meta); ++pass) {
            final int color = stack.getItem().getColorFromItemStack(stack, pass);
            final float c1 = (color >> 16 & 0xFF) / 255.0f;
            final float c2 = (color >> 8 & 0xFF) / 255.0f;
            final float c3 = (color & 0xFF) / 255.0f;
            if (EmblemRenderHelper.renderItem.renderWithColor) {
                GL11.glColor4f(c1, c2, c3, 1.0f);
            }
            final String emblemIdentifier = EmblemToolsServer.getEmblemIdentifier(stack);
            if (emblemIdentifier != null && !emblemIdentifier.equals("")) {
                final EmblemTexture texture = EmblemPackageManager.instance.getEmblemTexture(emblemIdentifier);
                Minecraft.getMinecraft().renderEngine.bindTexture(texture.getLocation());
                if (texture.getImage() != null) {
                    ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, texture.getImage().getWidth(), texture.getImage().getHeight(), 0.0625f);
                }
            }
            else {
                final IIcon icon = stack.getItem().getIconFromDamageForRenderPass(meta, pass);
                ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
            }
            if (renderGlint && stack.hasEffect(pass)) {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                RenderManager.instance.renderEngine.bindTexture(EmblemRenderHelper.GLINT_TEXTURE);
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                final float f13 = 0.76f;
                GL11.glColor4f(0.5f * f13, 0.25f * f13, 0.8f * f13, 1.0f);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                final float f14 = 0.125f;
                GL11.glScalef(f14, f14, f14);
                float f15 = Minecraft.getSystemTime() % 3000L / 3000.0f * 8.0f;
                GL11.glTranslatef(f15, 0.0f, 0.0f);
                GL11.glRotatef(-50.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, 0.0625f);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f14, f14, f14);
                f15 = Minecraft.getSystemTime() % 4873L / 4873.0f * 8.0f;
                GL11.glTranslatef(-f15, 0.0f, 0.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                ItemRenderer.renderItemIn2D(tessellator, 0.0f, 0.0f, 1.0f, 1.0f, 255, 255, 0.0625f);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
        }
        GL11.glPopMatrix();
    }
    
    static {
        GLINT_TEXTURE = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        renderItem = new RenderItem();
        instance = new EmblemRenderHelper();
        EmblemToolsClient.renderer = (IEmblemItemRenderer)EmblemRenderHelper.instance;
    }
}
