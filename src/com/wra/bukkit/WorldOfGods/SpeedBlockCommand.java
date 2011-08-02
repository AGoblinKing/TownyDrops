package com.wra.bukkit.WorldOfGods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.config.ConfigurationNode;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/2/11
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpeedBlockCommand implements CommandExecutor {
    private final WorldOfGods plugin;

    public SpeedBlockCommand(WorldOfGods plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if(split.length == 0) {
            ConfigurationNode drops = this.plugin.config.getNode("droprate");
            if(drops != null) {
                Map<String, Object> droplist = drops.getAll();
                for(Map.Entry<String, Object> e: droplist.entrySet()) {
                      player.sendMessage(ChatColor.RED+e.getKey() + ": " + e.getValue().toString() + "%");
                }
            } else {
                player.sendMessage("No custom drop rates defined.");
            }
            return true;

        }
        return false;
    }



}
