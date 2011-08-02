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
public class DropChanceCommand implements CommandExecutor {
    private final WorldOfGods plugin;

    public DropChanceCommand(WorldOfGods plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if(split.length == 4 && player.hasPermission("wog.dropamount")){
            this.plugin.config.setProperty("dropamount."+split[0]+"."+split[1].toUpperCase()+".amount", Integer.parseInt(split[2]));
            this.plugin.config.setProperty("dropamount."+split[0]+"."+split[1].toUpperCase()+".chance", Integer.parseInt(split[3]));
            this.plugin.config.save();
            player.sendMessage("Town "+split[0]+" will now receive an additional "+split[2]+" "+split[1].toUpperCase()+ " "+split[3]+"% of the time.");
            return true;
        }
        return false;
    }



}
