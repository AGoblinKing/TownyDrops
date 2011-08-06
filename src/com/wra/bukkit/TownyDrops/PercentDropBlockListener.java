package com.wra.bukkit.TownyDrops;

import ca.xshade.bukkit.towny.NotRegisteredException;
import ca.xshade.bukkit.towny.object.Resident;
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


/**
 * Created by IntelliJ IDEA.
 * User: raptors
 * Date: 8/1/11
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PercentDropBlockListener extends BlockListener {
    public static TownyDrops plugin;

    public PercentDropBlockListener(TownyDrops instance) {
        plugin = instance;
    }
    public void onBlockDamage(BlockDamageEvent event) {
        Block b = event.getBlock();
        Player p = event.getPlayer();
        int addDamage = plugin.config.getInt("blockdamage."+p.getName()+"."+b.getType().name(), 0);
        if(addDamage > 0) {

        }
    }
    public void onBlockBreak(BlockBreakEvent event){
        Block b = event.getBlock();
        Player p = event.getPlayer();
        Location loc = b.getLocation();
        World w = loc.getWorld();
        int rate = -1;
        String town = null;
        if(plugin.towny != null) {
            try {
                Resident res = plugin.towny.getTownyUniverse().getResident(p.getName());
                town = res.getTown().getName();
                rate = plugin.config.getInt("towny.droprate."+town+"."+b.getType().name(), -1);
            } catch(NotRegisteredException e) {

            }
        }
        if(rate == -1 ) {
            rate = plugin.config.getInt("droprate."+b.getType().name(), -1);
        }
        if(rate == -1) {
            rate = plugin.config.getInt("droprate.DEFAULT", 100);
        }

        if(Math.random()*100 > rate) {
           b.setType(Material.AIR);
        } else if(town != null) {
            ConfigurationNode townAmount = plugin.config.getNode("dropamount."+town+"."+b.getType().name());
            if(townAmount != null) {
                int amount = townAmount.getInt("amount", 0);
                int chance = townAmount.getInt("chance", 0);

                if(amount > 0 && chance > 0 && Math.random()*100<chance) {
                    w.dropItemNaturally(loc, new ItemStack(b.getType(), amount, (short)0, b.getData()));
                }
            }
            ConfigurationNode townChance = plugin.config.getNode("dropchance."+town+"."+b.getType().name());
            if(townChance != null) {
                int amount = townChance.getInt("amount", 0);
                int chance = townChance.getInt("chance", 0);
                String dropType = townChance.getString("dropType", "");
                if(amount > 0 && chance > 0 && dropType != "" && Math.random()*100<chance) {
                    w.dropItemNaturally(loc, new ItemStack(Material.getMaterial(dropType), amount));
                }
            }
        }
    }
}
