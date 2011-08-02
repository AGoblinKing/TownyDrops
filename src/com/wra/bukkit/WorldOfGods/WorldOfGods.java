package com.wra.bukkit.WorldOfGods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;


import java.io.File;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/1/11
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorldOfGods extends JavaPlugin {
    public final Logger log = Logger.getLogger("Minecraft");
    public Configuration config = new Configuration(new File("WorldOfGods.yml"));
    private final PercentDropBlockListener blockListener = new PercentDropBlockListener(this);

    public void onDisable() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void onEnable() {
        log.info("World of Gods Plugin enabled");
        config.load();
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
        getCommand("droprate").setExecutor(new DropRateCommand(this));
       // getCommand("dropamount").setExecutor(new DropAmountCommand(this));
    }

    public void onCommand() {

    }

}
