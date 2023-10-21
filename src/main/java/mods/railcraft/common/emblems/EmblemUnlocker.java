//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-master\1.7.10 stable mappings"!

//Decompiled by Procyon!

package mods.railcraft.common.emblems;

import net.minecraft.entity.player.*;
import cpw.mods.fml.common.*;
import org.apache.logging.log4j.*;
import mods.railcraft.common.util.misc.*;
import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.eventhandler.*;
import java.net.*;

public abstract class EmblemUnlocker
{
    protected boolean isComplete;
    protected boolean emblemExists;
    protected final String unlockCode;
    protected final String identifier;
    protected final EntityPlayerMP player;
    
    private EmblemUnlocker(final String unlockCode, final EntityPlayerMP player) {
        this.isComplete = false;
        this.emblemExists = false;
        this.unlockCode = unlockCode;
        this.player = player;
        this.identifier = EmblemManager.getIdentifierFromCode(unlockCode);
    }
    
    public static void spawnUnlocker(final String unlockCode, final int windowId, final EntityPlayerMP player) {
        final EmblemUnlocker unlocker = new EmblemUnlockerGUI(unlockCode, player, windowId);
        unlocker.initiateCheck();
        FMLCommonHandler.instance().bus().register((Object)unlocker);
    }
    
    private void initiateCheck() {
        Game.log(Level.INFO, "Attempting to unlock Emblem - \"emblem-{0}\"", this.identifier);
        final EmblemChecker checker = new EmblemChecker();
        checker.setDaemon(true);
        checker.setName("Emblem checker (" + this.identifier + ")");
        checker.start();
    }
    
    protected void onComplete() {
    }
    
    @SubscribeEvent
    public void tick(final TickEvent.ServerTickEvent event) {
        if (event.side == Side.CLIENT) {
            return;
        }
        if (this.isComplete) {
            this.onComplete();
            FMLCommonHandler.instance().bus().unregister((Object)this);
        }
    }
    
    private static class EmblemUnlockerGUI extends EmblemUnlocker
    {
        private final int windowId;
        
        private EmblemUnlockerGUI(final String unlockCode, final EntityPlayerMP player, final int windowId) {
            super(unlockCode, player);
            this.windowId = windowId;
        }
        
        @Override
        protected void onComplete() {
            String result = "";
            String msg = "railcraft.gui.engrave.unlock.fail";
            if (this.emblemExists) {
                EmblemManager.unlockEmblem(this.player, this.unlockCode);
                result = this.identifier;
                msg = "railcraft.gui.engrave.unlock.success";
            }
            EmblemManager.updateUnlockGUI(this.player, result, this.windowId, msg);
        }
    }
    
    private class EmblemChecker extends Thread
    {
        @Override
        public void run() {
            EmblemUnlocker.this.emblemExists = this.emblemExists();
            EmblemUnlocker.this.isComplete = true;
        }
        
        private boolean emblemExists() {
            HttpURLConnection con = null;
            try {
                HttpURLConnection.setFollowRedirects(false);
                final URL url = new URL("https://dl.dropboxusercontent.com/u/38558957/Minecraft/Railcraft/Emblems/emblem-" + EmblemUnlocker.this.identifier + ".jar");
                con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("HEAD");
                if (con.getResponseCode() == 200) {
                    Game.log(Level.INFO, "Found Emblem: \"emblem-{0}\"", EmblemUnlocker.this.identifier);
                    return true;
                }
                return false;
            }
            catch (Exception ex) {
                Game.log(Level.WARN, "Failed to find Emblem: \"emblem-{0}\". Reason: {1}", EmblemUnlocker.this.identifier, ex);
                return false;
            }
            finally {
                if (con != null) {
                    con.disconnect();
                }
            }
        }
    }
}
