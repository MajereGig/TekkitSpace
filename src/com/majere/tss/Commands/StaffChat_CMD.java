package com.majere.tss.Commands;

import com.majere.tss.Utils.responses;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class  StaffChat_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage(responses.PLAYER_COMMAND); }
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("staffchat")) {
            if(p.hasPermission("tss.staffchat")|| p.isOp() || p.hasPermission("tss.*")) {
                    if(p.hasPermission("tss.staffchat.recieve")) {
                        for (Player staff : Bukkit.getOnlinePlayers()) {
                            if (staff.hasPermission("tss.staffchat.recieve") || staff.isOp() || staff.hasPermission("tss.*")) {
                                StringBuilder sb = new StringBuilder();
                                for(int i = 0; i< args.length; i++) {
                                    sb.append(args[i]).append(" ");
                                }
                                String msg = sb.toString().trim();
                                staff.sendMessage(responses.craftMessage("&8[ &cStaff &8] &e" + p.getName() + " &7:&f " + msg));
                            }
                        }
                    }else {
                        p.sendMessage(responses.craftMessage("&7You are missing the following permissions &8[&etss.staffchat.recieve&8]&7!"));
                    }
            }else {
                p.sendMessage(responses.NOT_AUTHORIZED);
            }
        }
        return false;
    }
}
