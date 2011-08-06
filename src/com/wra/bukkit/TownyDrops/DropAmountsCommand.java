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
public class DropAmountsCommand implements CommandExecutor {
    private final TownyDrops plugin;

    public DropAmountsCommand(TownyDrops plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if(split.length == 1 && sender.hasPermission("wog.dropamounts")){
            ConfigurationNode target = plugin.config.getNode("dropamount."+split[0]);
            if(target != null) {
                Map<String, Object> drops = target.getAll();
                for(Map.Entry<String, Object> e: drops.entrySet()) {
                     sender.sendMessage(ChatColor.RED+e.getKey()+": "+e.getValue().toString());
                }
            } else {
                sender.sendMessage(ChatColor.RED+"User "+split[0]+" does not have any custom drop amounts.");
            }
            return true;
        }
        return false;
    }



}
