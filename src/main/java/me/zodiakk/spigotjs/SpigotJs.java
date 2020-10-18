package me.zodiakk.spigotjs;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.config.JsonConfiguration;

public class SpigotJs extends JavaPlugin {
    private static Plugin instance;
    private static FileConfiguration config;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        if (instance.getDescription().getVersion().contains("-")) {
            Bukkit.getLogger().warning("Please note that this build of SpigotJS is not an official release, which means that unexpected bugs may occur.");
            Bukkit.getLogger().warning("Unless you know what you're doing, this build should never be used on a production server.");
            Bukkit.getLogger().warning("I (Zodiak, the author) am not responsible for any damage caused from the use of beta builds.");
        }

        saveDefaultConfig();

        config = getConfig();
        try {
            SpigotJsApi.getInstance().getI18n().addLanguage(
                "en_EN", JsonConfiguration.extractConfiguration(this, "lang/en_EN.json"));
        } catch (IOException ex) {
            Bukkit.getLogger().severe("Could not load language files.");
            throw new IllegalStateException(ex);
        }

        getCommand("sjs").setExecutor(new SpigotJsCommand());
    }

    @Override
    public void onDisable() {
        // Do nothing (at the moment)
    }

    public static final Plugin getInstance() {
        return instance;
    }

    public static final boolean exists() {
        return instance == null;
    }

    public static final FileConfiguration getJsonConfig() {
        return config;
    }
}
