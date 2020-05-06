package com.majere.tss.Events;

import com.majere.tss.Core;
import com.majere.tss.Utils.responses;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat_EVNT implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(Core.staff.contains(e.getPlayer().getName())) {
           e.setCancelled(true);
           if(e.getPlayer().hasPermission("tss.staffchat.recieve")) {
               for (Player staff : Bukkit.getOnlinePlayers()) {
                   if (staff.hasPermission("tss.staffchat.recieve") || staff.isOp() || staff.hasPermission("tss.*")) {
                       staff.sendMessage(responses.craftMessage("&8[ &cStaff &8] &e" + e.getPlayer().getName() + " &7:&f " + e.getMessage()));
                   }
               }
           }else {
               e.getPlayer().sendMessage(responses.craftMessage("&7You are missing the following permissions &8[&etss.staffchat.recieve&8]&7!"));
           }
        }
    }
}

