package com.wra.bukkit.WorldOfGods;

import com.sun.org.apache.xpath.internal.operations.Variable;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.config.ConfigurationNode;
import sun.plugin2.main.server.Plugin;


/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/1/11
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PercentDropBlockListener extends BlockListener {
    public static WorldOfGods plugin;
    public PercentDropBlockListener(WorldOfGods instance) {
        plugin = instance;
    }
    public void onBlockDamage(BlockDamageEvent event){
        Block b = event.getBlock();
        b.setType(Material.DIAMOND_ORE);
        plugin.log.info("DIAMONDS");
    }
    public void onBlockBreak(BlockBreakEvent event){
        Block b = event.getBlock();
        Player p = event.getPlayer();
        Location loc = b.getLocation();
        World w = loc.getWorld();

        double r = Math.random();
        int rate = plugin.config.getInt("droprate."+b.getType().name(), -1);
        if(rate == -1) {
            rate = plugin.config.getInt("droprate.default", 100);
        }

        if(Math.random()*100 > rate) {
           b.setType(Material.AIR);
        } else {
            ConfigurationNode user = plugin.config.getNode("dropamount."+p.getName());
            if(user != null)
                 w.dropItemNaturally(loc, new ItemStack(b.getType(),  user.getInt(b.getType().name(), 0), (short)0, b.getData()));
        }
    }
}
