package com.wra.bukkit.TownyDrops;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.util.config.ConfigurationNode;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/2/11
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class DropRatesCommand implements CommandExecutor {
    private final TownyDrops plugin;

    public DropRatesCommand(TownyDrops plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if(split.length == 0 && sender.hasPermission("wog.droprates")) {
            ConfigurationNode drops = this.plugin.config.getNode("droprate");
            if(drops != null) {
                Map<String, Object> droplist = drops.getAll();
                for(Map.Entry<String, Object> e: droplist.entrySet()) {
                      sender.sendMessage(ChatColor.RED+e.getKey() + ": " + e.getValue().toString() + "%");
                }
            } else {
                sender.sendMessage("No custom drop rates defined.");
            }
            return true;

        }
        return false;
    }



}
