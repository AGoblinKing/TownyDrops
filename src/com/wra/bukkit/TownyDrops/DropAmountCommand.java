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
public class DropAmountCommand implements CommandExecutor {
    private final TownyDrops plugin;

    public DropAmountCommand(TownyDrops plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if(split.length == 4 && sender.hasPermission("wog.dropamount")){
            this.plugin.config.setProperty("dropamount."+split[0]+"."+split[1].toUpperCase()+".amount", Integer.parseInt(split[2]));
            this.plugin.config.setProperty("dropamount."+split[0]+"."+split[1].toUpperCase()+".chance", Integer.parseInt(split[3]));
            this.plugin.config.save();
            sender.sendMessage("Town "+split[0]+" will now receive an additional "+split[2]+" "+split[1].toUpperCase()+ " "+split[3]+"% of the time.");
            return true;
        }
        return false;
    }



}
