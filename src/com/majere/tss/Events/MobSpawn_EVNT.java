package com.majere.tss.Events;

import com.majere.tss.Core;
import com.majere.tss.Utils.responses;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.logging.Level;

public class MobSpawn_EVNT implements Listener {

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        LivingEntity entity = e.getEntity();

        if(entity.getType().toString().equalsIgnoreCase("GalacticraftCore_EvolvedSkeletonBoss") || entity.getType().toString().equalsIgnoreCase("GalacticraftMars_CreeperBoss")) {
            e.setCancelled(true);
            Core.log(Level.WARNING, responses.craftMessage("&7" + entity.getType() + " was spawned at &8[&e " +
                    e.getLocation().getX() + " " + e.getLocation().getY() + " " + e.getLocation().getZ() + " " + e.getLocation().getWorld().getName() + " &8]"));
            Core.log(Level.WARNING, responses.craftMessage("&7Entity was spawned by:&e " + e.getSpawnReason().name()));
            Core.log(Level.WARNING, responses.craftMessage("&7Entity was &cblocked&7 from spawning successfully&8!"));
        }
    }
}
