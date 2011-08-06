package com.wra.bukkit.TownyDrops;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/2/11
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class DropRateCommand implements CommandExecutor {
    private final TownyDrops plugin;

    public DropRateCommand(TownyDrops plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if(split.length == 2 && sender.hasPermission("wog.droprate")){
            this.plugin.config.setProperty("droprate."+split[0].toUpperCase(), Integer.parseInt(split[1]));
            this.plugin.config.save();
            sender.sendMessage("Updated drop rate of "+split[0].toUpperCase()+ " to "+ split[1] + "%");
            return true;
        }
        if(split.length == 3 && sender.hasPermission("wog.droprate")) {
            this.plugin.config.setProperty("towny.droprate."+split[0].replace('.','z')+"."+split[1].toUpperCase(),Integer.parseInt(split[2]));
            this.plugin.config.save();
            sender.sendMessage("Updated drop rate of "+split[1].toUpperCase()+ " to "+ split[2] + "% for town "+split[0]);
            return true;
        }
        return false;
    }



}
