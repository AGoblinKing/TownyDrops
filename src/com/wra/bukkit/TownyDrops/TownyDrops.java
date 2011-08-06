package com.wra.bukkit.TownyDrops;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

import java.util.logging.Logger;
import ca.xshade.bukkit.towny.*;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/1/11
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TownyDrops extends JavaPlugin {

    public final Logger log = Logger.getLogger("Minecraft");
    public Configuration config = getConfiguration();
    private final PercentDropBlockListener blockListener = new PercentDropBlockListener(this);
    public Towny towny;

    public void onDisable() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onEnable() {
        log.info("[TownyDrops] Enabled");
        PluginManager pm = this.getServer().getPluginManager();
        towny = (Towny)pm.getPlugin("Towny");

        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
        getCommand("droprate").setExecutor(new DropRateCommand(this));
        getCommand("dropamount").setExecutor(new DropAmountCommand(this));
        getCommand("dropamounts").setExecutor(new DropAmountsCommand(this));
        getCommand("droprates").setExecutor(new DropRatesCommand(this));
        getCommand("dropchance").setExecutor(new DropChanceCommand(this));
    }
}
