package com.majere.tss.Commands;

import com.majere.tss.Core;
import com.majere.tss.Utils.responses;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatToggle_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage(responses.PLAYER_COMMAND); }
        Player p = (Player) sender;
         if(cmd.getName().equalsIgnoreCase("staffchattoggle")) {
            if(p.hasPermission("tss.staffchat.toggle")|| p.isOp() || p.hasPermission("tss.*")) {
                if(args.length == 0) {
                    if(Core.staff.contains(p.getName())) {
                        Core.staff.remove(p.getName());
                        p.sendMessage(responses.craftMessage("&7Staff chat has been &cdisabled&7!"));
                    }else {
                        Core.staff.add(p.getName());
                        p.sendMessage(responses.craftMessage("&7Staff chat has been &aEnabled&7!"));
                    }
                }
            }else {
                p.sendMessage(responses.NOT_AUTHORIZED);
            }
        }
        return false;
    }
}
