//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import com.google.common.io.*;
import mods.railcraft.common.plugins.forge.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import mods.railcraft.common.util.misc.*;
import mods.railcraft.common.util.network.*;
import net.minecraft.item.*;
import java.security.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class EmblemManager implements IEmblemManager
{
    public static final EmblemManager instance;
    public static final String EMBLEM_NBT_DATA = "emblemData";
    public static final String EMBLEM_UNLOCK_NBT_DATA = "unlocks";
    private static final BaseEncoding encoder;
    private static final Set<String> starterEmblems;
    
    public void init() {
    }
    
    public static boolean playerHasEmblem(final EntityPlayer player, final String emblem) {
        final Set<String> emblems = getUnlockedEmblems(player);
        return emblems.contains(emblem);
    }
    
    private static NBTTagCompound getEmblemData(final EntityPlayer player) {
        final NBTTagCompound forgeData = player.getEntityData();
        if (!forgeData.hasKey("PlayerPersisted")) {
            forgeData.setTag("PlayerPersisted", (NBTBase)new NBTTagCompound());
        }
        final NBTTagCompound persistantData = forgeData.getCompoundTag("PlayerPersisted");
        if (!persistantData.hasKey("railcraftData")) {
            persistantData.setTag("railcraftData", (NBTBase)new NBTTagCompound());
        }
        final NBTTagCompound railcraftData = persistantData.getCompoundTag("railcraftData");
        if (!railcraftData.hasKey("emblemData")) {
            railcraftData.setTag("emblemData", (NBTBase)new NBTTagCompound());
        }
        return railcraftData.getCompoundTag("emblemData");
    }
    
    private static NBTPlugin.NBTList<NBTTagByteArray> getEmblemUnlockData(final EntityPlayer player) {
        final NBTTagCompound emblemData = getEmblemData(player);
        if (!emblemData.hasKey("unlocks")) {
            emblemData.setTag("unlocks", (NBTBase)new NBTTagList());
        }
        return NBTPlugin.getNBTList(emblemData, "unlocks", NBTPlugin.EnumNBTType.BYTE_ARRAY);
    }
    
    public static Set<String> getUnlockedEmblems(final EntityPlayer player) {
        final Set<String> set = new LinkedHashSet<String>();
        set.addAll(EmblemManager.starterEmblems);
        final NBTPlugin.NBTList<NBTTagByteArray> unlocks = getEmblemUnlockData(player);
        for (final NBTTagByteArray tag : unlocks) {
            set.add(unscrambleIdentifier(tag.func_150292_c()));
        }
        return set;
    }
    
    static void unlockEmblem(final EntityPlayerMP player, final String emblemCode) {
        final String identifier = getIdentifierFromCode(emblemCode);
        if (getUnlockedEmblems((EntityPlayer)player).contains(identifier)) {
            Game.log(Level.WARN, "Tried to unlock already unlocked Emblem, aborting - \"emblem-{0}\"", identifier);
            return;
        }
        final NBTPlugin.NBTList<NBTTagByteArray> unlocks = getEmblemUnlockData((EntityPlayer)player);
        unlocks.add((NBTTagByteArray) new NBTTagByteArray(scrambleIdentifier(identifier)));
        Game.log(Level.WARN, "Emblem unlocked - \"emblem-{0}\"", identifier);
    }
    
    @Override
    public void unlockEmblem(final EntityPlayerMP player, final String emblemCode, final int windowId) {
        final String identifier = getIdentifierFromCode(emblemCode);
        if (playerHasEmblem((EntityPlayer)player, emblemCode)) {
            updateUnlockGUI(player, identifier, windowId, "railcraft.gui.engrave.unlock.exists");
            return;
        }
        EmblemUnlocker.spawnUnlocker(emblemCode, windowId, player);
    }
    
    public static void updateUnlockGUI(final EntityPlayerMP player, final String identifier, final int windowId, final String msg) {
        PacketBuilder.instance().sendGuiStringPacket(player, windowId, 0, identifier);
        PacketBuilder.instance().sendGuiStringPacket(player, windowId, 1, msg);
    }
    
    @Override
    public ItemStack getEmblemItemStack(final String ident) {
        return ItemEmblem.getEmblem(ident);
    }
    
    public static String getIdentifierFromCode(final String unlockCode) {
        try {
            final MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
            msgDigest.update(unlockCode.toLowerCase(Locale.ENGLISH).getBytes("UTF-8"));
            final byte[] rawByte = msgDigest.digest();
            return EmblemManager.encoder.encode(rawByte);
        }
        catch (Exception ex) {
            return "";
        }
    }
    
    private static String getIdentifierFromCodeLegacy(final String unlockCode) {
        try {
            final MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
            msgDigest.update(unlockCode.getBytes("UTF-8"));
            final byte[] rawByte = msgDigest.digest();
            return EmblemManager.encoder.encode(rawByte);
        }
        catch (Exception ex) {
            return "";
        }
    }
    
    public static byte[] scrambleIdentifier(final String identifier) {
        byte[] bytes = EmblemManager.encoder.decode((CharSequence)identifier);
        bytes = Arrays.copyOf(bytes, bytes.length);
        ArrayUtils.reverse(bytes);
        return bytes;
    }
    
    public static String unscrambleIdentifier(byte[] bytes) {
        bytes = Arrays.copyOf(bytes, bytes.length);
        ArrayUtils.reverse(bytes);
        return EmblemManager.encoder.encode(bytes);
    }
    
    static {
        encoder = BaseEncoding.base32().omitPadding().lowerCase();
        instance = new EmblemManager();
        EmblemToolsServer.manager = EmblemManager.instance;
        final Set<String> starters = new LinkedHashSet<String>();
        starters.add(getIdentifierFromCodeLegacy("Railcraft"));
        starters.add(getIdentifierFromCodeLegacy("Book"));
        starters.add(getIdentifierFromCodeLegacy("Stone Age Miner"));
        starters.add(getIdentifierFromCodeLegacy("Toy Sword"));
        starters.add(getIdentifierFromCodeLegacy("Bone Dead"));
        starters.add(getIdentifierFromCodeLegacy("All Aboard"));
        starters.add(getIdentifierFromCodeLegacy("Record Breaker"));
        starters.add(getIdentifierFromCodeLegacy("Sleeper"));
        starters.add(getIdentifierFromCodeLegacy("It's a lie!"));
        starters.add(getIdentifierFromCodeLegacy("Beauty"));
        starters.add(getIdentifierFromCodeLegacy("Power Up"));
        starters.add(getIdentifierFromCodeLegacy("ssssSS!"));
        starters.add(getIdentifierFromCodeLegacy("Sticky Situation"));
        starters.add(getIdentifierFromCode("my name is jack"));
        starters.add(getIdentifierFromCode("tells no tales"));
        starters.add(getIdentifierFromCode("are you ready for z-day?"));
        starters.add(getIdentifierFromCode("no acorns here"));
        starterEmblems = Collections.unmodifiableSet((Set<? extends String>)starters);
    }
}
