package com.wra.bukkit.WorldOfGods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/2/11
 * Time: 2:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class DropRateCommand implements CommandExecutor {
    private final WorldOfGods plugin;

    public DropRateCommand(WorldOfGods plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if(split.length == 2){
            this.plugin.config.setProperty("droprate."+split[0].toUpperCase(), Integer.parseInt(split[1]));
            this.plugin.config.save();
            player.sendMessage("Updated drop rate of "+split[0].toUpperCase()+ " to "+ split[1] + "%");
            return true;
        }
        return false;
    }



}
