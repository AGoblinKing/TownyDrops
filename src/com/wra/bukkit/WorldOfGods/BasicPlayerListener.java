package com.wra.bukkit.WorldOfGods;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
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
public class BasicPlayerListener extends PlayerListener {
    public static Plugin plugin;
    public BasicPlayerListener(Plugin instance) {
        plugin = instance;
    }


    /*
    public void onPlayerMove(PlayerMoveEvent evt){
        Location loc = evt.getPlayer().getLocation();
        World w = loc.getWorld();
        loc.setY(loc.getY() - 1);
        Block b = w.getBlockAt(loc);
        if(!b.isEmpty() && !b.isLiquid())
            b.setType(Material.LAVA);
    }*/



}
