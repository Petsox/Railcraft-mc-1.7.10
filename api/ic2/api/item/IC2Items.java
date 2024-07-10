//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package ic2.api.item;

import net.minecraft.item.*;

public final class IC2Items
{
    private static Class<?> Ic2Items;
    
    public static ItemStack getItem(final String name) {
        try {
            if (IC2Items.Ic2Items == null) {
                IC2Items.Ic2Items = Class.forName(getPackage() + ".core.Ic2Items");
            }
            final Object ret = IC2Items.Ic2Items.getField(name).get(null);
            if (ret instanceof ItemStack) {
                return (ItemStack)ret;
            }
            return null;
        }
        catch (Exception e) {
            System.out.println("IC2 API: Call getItem failed for " + name);
            return null;
        }
    }
    
    private static String getPackage() {
        final Package pkg = IC2Items.class.getPackage();
        if (pkg != null) {
            final String packageName = pkg.getName();
            return packageName.substring(0, packageName.length() - ".api.item".length());
        }
        return "ic2";
    }
}
