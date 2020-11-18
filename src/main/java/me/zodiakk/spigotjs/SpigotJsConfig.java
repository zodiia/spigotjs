package me.zodiakk.spigotjs;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

public class SpigotJsConfig {
    private String language;
    private File scriptsDirectory;
    private File scriptsAutorunDirectory;
    private DeprecatedMethodsWarning deprecatedMethodsWarning;
    private boolean enableExperimentalFeatures;

    public SpigotJsConfig(FileConfiguration config) {
        language = config.getString("language");
        scriptsDirectory = new File(SpigotJs.getInstance().getDataFolder(), config.getString("scripts-directory"));
        scriptsAutorunDirectory = new File(SpigotJs.getInstance().getDataFolder(), config.getString("scripts-autorun-directory"));
        deprecatedMethodsWarning = DeprecatedMethodsWarning.valueOf(config.getString("deprecated-methods-warning").toUpperCase());
        enableExperimentalFeatures = config.getBoolean("enable-experimental-features");
    }

    public String getLanguage() {
        return language;
    }

    public File getScriptsDirectory() {
        return scriptsDirectory;
    }

    public File getScriptsAutorunDirectory() {
        return scriptsAutorunDirectory;
    }

    public DeprecatedMethodsWarning getDeprecatedMethodsWarning() {
        return deprecatedMethodsWarning;
    }

    public boolean getEnableExperimentalFeatures() {
        return enableExperimentalFeatures;
    }

    public enum DeprecatedMethodsWarning {
        ALWAYS,
        ONCE,
        NEVER;
    }
}
