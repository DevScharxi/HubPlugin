package me.scharxidev.hubplugin;

import me.scharxidev.hubplugin.events.JoinEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private PluginManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        initializeEvent(new JoinEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initializeCommand(String command, CommandExecutor executor) {
        getInstance().getCommand(command).setExecutor(executor);
    }

    private void initializeEvent(Listener listener) {
        getManager().registerEvents(listener, this);
    }

    public static Main getInstance() {
        return instance;
    }

    public PluginManager getManager() {
        return manager;
    }
}
