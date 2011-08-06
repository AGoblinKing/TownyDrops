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
public class DropChanceCommand implements CommandExecutor {
    private final TownyDrops plugin;

    public DropChanceCommand(TownyDrops plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if(split.length == 5 && sender.hasPermission("wog.dropchance")){
            this.plugin.config.setProperty("dropchance."+split[0]+"."+split[1].toUpperCase()+".dropType", split[2].toUpperCase());
            this.plugin.config.setProperty("dropchance."+split[0]+"."+split[1].toUpperCase()+".amount", Integer.parseInt(split[3]));
            this.plugin.config.setProperty("dropchance."+split[0]+"."+split[1].toUpperCase()+".chance", Integer.parseInt(split[4]));
            this.plugin.config.save();
            sender.sendMessage("Town "+split[0]+" will now receive an additional "+split[3]+" "+split[2].toUpperCase()+ " from "+split[1].toUpperCase()+" "+split[4]+"% of the time.");
            return true;
        }
        return false;
    }



}
