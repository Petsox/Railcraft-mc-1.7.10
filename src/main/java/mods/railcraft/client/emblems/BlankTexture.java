//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.client.emblems;

import mods.railcraft.client.util.textures.*;
import net.minecraft.client.resources.*;
import javax.imageio.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;

class BlankTexture extends Texture
{
    private boolean cachedImage;
    
    BlankTexture() {
        this.cachedImage = false;
    }
    
    public void loadTexture(final IResourceManager resourcemanager) throws IOException {
        if (this.imageData == null) {
            final String resource = "/assets/railcraft/textures/emblems/placeholder.png";
            final InputStream istream = EmblemPackageManager.class.getResourceAsStream(resource);
            if (istream == null) {
                return;
            }
            this.imageData = ImageIO.read(istream);
            istream.close();
        }
    }
    
    public int getGlTextureId() {
        final int textureIndex = super.getGlTextureId();
        if (!this.cachedImage && this.imageData != null) {
            TextureUtil.uploadTextureImage(textureIndex, this.imageData);
            this.cachedImage = true;
        }
        return textureIndex;
    }
}
