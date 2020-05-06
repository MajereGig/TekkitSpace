package com.majere.tss.Commands;

import com.majere.tss.Utils.responses;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage(responses.PLAYER_COMMAND); }
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("kick")) {
            if(p.hasPermission("tss.kick")|| p.isOp() || p.hasPermission("tss.*")) {
                if(args.length < 2) { p.sendMessage(responses.INVALID_COMMAND); }

                if (Bukkit.getPlayer(args[0]) == null) {
                    p.sendMessage(responses.NO_PLAYER_FOUND);
                } else {
                    Player target = Bukkit.getPlayer(args[0]);

                    if(target.hasPermission("tss.kick.exempt") || target.isOp() || target.hasPermission("tss.*")) {
                        p.sendMessage(responses.craftMessage("&7That playyer &ccannot&7 be kicked&8!"));
                    }else {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            sb.append(args[i]).append(" ");
                        }
                        String reason = sb.toString().trim();
                        target.kickPlayer(responses.craftMessage("&7You were &rkicked&7 from the server&8!\n " +
                                "&7Kicked By&8: &e" + p.getName() + "\n" +
                                "&7Kicked For&8: &c" + reason + "\n" +
                                "&8=-=-=-=-=[&b&lTekkit Space&8]=-=-=-=-="));
                        for (Player staff : Bukkit.getOnlinePlayers()) {
                            if (staff.hasPermission("tss.kick.notify")) {
                                staff.sendMessage(responses.craftMessage("&8[ &cStaff &8] &fPlayer&e " + args[0] + "&f was kicked for&e " + reason));
                            }
                        }
                    }
                }
            }else {
                p.sendMessage(responses.NOT_AUTHORIZED);
            }
        }
        return false;
    }
}
