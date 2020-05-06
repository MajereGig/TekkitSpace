package com.majere.tss.Utils;

import org.bukkit.ChatColor;

public class responses {

    public final static String NO_PLAYER_FOUND = ChatColor.translateAlternateColorCodes('&', "&8Specified player was &cnot&8 found in the database!");
    public final static String NOT_AUTHORIZED = ChatColor.translateAlternateColorCodes('&', "&8You do &cnot&8 have the required authorization to use this command!");
    public final static String PLAYER_COMMAND =  ChatColor.translateAlternateColorCodes('&', "&8This command can only be used by players in game!");
    public final static String INVALID_COMMAND = ChatColor.translateAlternateColorCodes('&', "&8Invalid command, please reference &f/help&8 for the correct usage!");
    public final static String CONSOLE_COMMAND = ChatColor.translateAlternateColorCodes('&', "&8This command cant only be used from the console!");

    public static String craftMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
