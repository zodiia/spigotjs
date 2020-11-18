package me.zodiakk.spigotjs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.config.JsonConfiguration;

public class SpigotJs extends JavaPlugin {
    private static SpigotJs instance;
    private SpigotJsConfig config;

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

        config = new SpigotJsConfig(getConfig());
        try {
            SpigotJsApi.getInstance().getI18n().addLanguage(
                "en", JsonConfiguration.extractConfiguration(this, "lang/en.json"));
        } catch (IOException ex) {
            Bukkit.getLogger().severe("Could not load language files.");
            throw new IllegalStateException(ex);
        }

        try {
            File autorunDir = new File(getDataFolder(), "scripts/autorun");

            autorunDir.mkdirs();
            SpigotJsApi.getInstance().getScriptManager().createScriptsInDirectory(autorunDir);
        } catch (IOException ex) {
            Bukkit.getLogger().warning("Could not load scripts in autorun directory");
            ex.printStackTrace();
        }

        SpigotJsApi.getInstance().getScriptManager().enable();

        getCommand("sjs").setExecutor(new SpigotJsCommand());
    }

    @Override
    public void onDisable() {
        SpigotJsApi.getInstance().getScriptManager().disable();
    }

    public static final SpigotJs getInstance() {
        return instance;
    }

    public static final boolean exists() {
        return instance == null;
    }

    public final SpigotJsConfig getSpigotJsConfig() {
        return config;
    }
}
