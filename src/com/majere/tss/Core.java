package com.majere.tss;

import com.majere.tss.Commands.Fake_Leave_CMD;
import com.majere.tss.Commands.Kick_CMD;
import com.majere.tss.Commands.StaffChatToggle_CMD;
import com.majere.tss.Commands.StaffChat_CMD;
import com.majere.tss.Events.DispenserDrop_EVNT;
import com.majere.tss.Events.MobSpawn_EVNT;
import com.majere.tss.Events.StaffChat_EVNT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class Core extends JavaPlugin {

    public static List<String> staff;
    
    @Override
    public void onEnable() {
        log(Level.INFO, "&8=============================================");
        log(Level.INFO, "&8Tekkit Staff has been successfully [&aenabled&8]!");
        log(Level.INFO, "&8=============================================");
        staff = new ArrayList<>();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        log(Level.INFO, "&8==================================================");
        log(Level.INFO, "&8Tekkit Staff Chat has been successfully &cdisabled&8]!");
        log(Level.INFO, "&8==================================================");
    }

    public static void log(Level level, String log) { Bukkit.getConsoleSender().sendMessage(level +  " " + ChatColor.translateAlternateColorCodes('&', log)); }

    public void registerEvents () {
        Bukkit.getPluginManager().registerEvents(new DispenserDrop_EVNT(), this);
        Bukkit.getPluginManager().registerEvents(new StaffChat_EVNT(), this);
        Bukkit.getPluginManager().registerEvents(new MobSpawn_EVNT(), this);
    }

    public void registerCommands() {
        Objects.requireNonNull(this.getCommand("staffchattoggle")).setExecutor(new StaffChatToggle_CMD());
        Objects.requireNonNull(this.getCommand("staffchat")).setExecutor(new StaffChat_CMD());
        Objects.requireNonNull(this.getCommand("kick")).setExecutor(new Kick_CMD());
        Objects.requireNonNull(this.getCommand("fakeleave")).setExecutor(new Fake_Leave_CMD());
    }
}
