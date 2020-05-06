package com.majere.tss.Events;

import com.majere.tss.Core;
import com.majere.tss.Utils.responses;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class DispenserDrop_EVNT implements Listener {

    private final ItemStack linkbook = new ItemStack(6064);
    private final ItemStack notebook = new ItemStack(6060);
    private final ItemStack descbook = new ItemStack(6057);
    private final ItemStack linkedbook = new ItemStack(6058);

    @EventHandler
    public void onDispenserDrop(BlockDispenseEvent e) {

        if(e.getBlock().getType() == Material.DISPENSER) {
            if(e.getItem().equals(linkbook) || e.getItem().equals(linkedbook) || e.getItem().equals(descbook) || e.getItem().equals(notebook)) {
                e.setCancelled(true);
                Core.log(Level.SEVERE, responses.craftMessage("&cDispenser Attempted to dispense a linking book at " +
                        "location &8[&e " + e.getBlock().getX() + " " + e.getBlock().getZ() + " " + e.getBlock().getY() + " &8]"));
            }
        }

        if(e.getBlock().getType() == Material.DROPPER) {
            if(e.getItem().equals(linkbook) || e.getItem().equals(linkedbook) || e.getItem().equals(descbook) || e.getItem().equals(notebook)) {
                e.setCancelled(true);
                Core.log(Level.SEVERE, responses.craftMessage("&cDropper Attempted to dispense a linking book at " +
                        "location &8[&e " + e.getBlock().getX() + " " + e.getBlock().getZ() + " " + e.getBlock().getY() + " &8]"));
            }
        }

        if(e.getBlock().getType() == Material.getMaterial(4081)) {
            if(e.getItem().equals(linkbook) || e.getItem().equals(linkedbook) || e.getItem().equals(descbook) || e.getItem().equals(notebook)) {
                e.setCancelled(true);
                Core.log(Level.SEVERE, responses.craftMessage("&cME Dropper Attempted to dispense a linking book at " +
                        "location &8[&e " + e.getBlock().getX() + " " + e.getBlock().getZ() + " " + e.getBlock().getY() + " &8]"));
            }
        }

        if(e.getBlock().getType() == Material.getMaterial(687)) {
            if(e.getItem().equals(linkbook) || e.getItem().equals(linkedbook) || e.getItem().equals(descbook) || e.getItem().equals(notebook)) {
                e.setCancelled(true);
                Core.log(Level.SEVERE, responses.craftMessage("&cMFR Ejector Attempted to dispense a linking book at " +
                        "location &8[&e " + e.getBlock().getX() + " " + e.getBlock().getZ() + " " + e.getBlock().getY() + " &8]"));
            }
        }
    }
}
