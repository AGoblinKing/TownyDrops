package com.wra.bukkit.WorldOfGods;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/1/11
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpeedPlayerListener extends PlayerListener {
    public static WorldOfGods plugin;
    public SpeedPlayerListener(WorldOfGods instance) {
        plugin = instance;
    }

    public void onPlayerMove(PlayerMoveEvent evt){
        Location loc = evt.getPlayer().getLocation();
        Player p = evt.getPlayer();
        World w = loc.getWorld();
        loc.setY(loc.getY() - 1);
        Block b = w.getBlockAt(loc);
        if(b.getType().name() == plugin.config.getString("movefast.block", "")) {
           p.setVelocity(p.getVelocity().multiply(plugin.config.getDouble("movefast.speed", 2)));
        }

    }
}
