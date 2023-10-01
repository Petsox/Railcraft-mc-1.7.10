//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.tablet;

public class TabletBitmap
{
    public final int width;
    public final int height;
    protected int[] data;
    
    public TabletBitmap(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.data = new int[width * height];
    }
    
    public TabletBitmap(final ITablet tablet) {
        this(tablet.getScreenWidth(), tablet.getScreenHeight());
    }
    
    public int[] getData() {
        return this.data;
    }
    
    public int get(final int x, final int y) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return 0;
        }
        return this.data[y * this.width + x];
    }
    
    public void set(final int x, final int y, final int shade) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return;
        }
        this.data[y * this.width + x] = shade;
    }
    
    public void set(final int x, final int y, final TabletBitmap bitmap) {
        for (int i = 0; i < bitmap.height && i < this.height; ++i) {
            for (int h = 0; h < bitmap.width && h < this.width; ++h) {
                this.set(x + h, y + i, bitmap.get(h, i));
            }
        }
    }
    
    public TabletBitmap duplicate() {
        final TabletBitmap cloned = new TabletBitmap(this.width, this.height);
        cloned.data = this.data.clone();
        return cloned;
    }
}
