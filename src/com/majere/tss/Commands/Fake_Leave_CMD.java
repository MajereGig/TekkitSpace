package com.majere.tss.Commands;

import com.majere.tss.Utils.responses;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fake_Leave_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage(responses.PLAYER_COMMAND); }
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("fakeleave")) {
            if(p.hasPermission("tss.fakeleave")|| p.isOp() || p.hasPermission("tss.*")) {
                Bukkit.broadcastMessage(responses.craftMessage("&e" + p.getName() + " has left the game"));
            }else {
                p.sendMessage(responses.NOT_AUTHORIZED);
            }
        }
        return false;
    }
}
