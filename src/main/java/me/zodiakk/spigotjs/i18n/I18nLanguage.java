package me.zodiakk.spigotjs.i18n;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonElement;

import org.bukkit.ChatColor;

import me.zodiakk.spigotjs.config.JsonConfigurationSection;

public class I18nLanguage {
    private HashMap<String, String> values = new HashMap<String, String>();
    private String language;

    public I18nLanguage(String language, JsonConfigurationSection elements) {
        this.language = language;

        parseJsonSection(null, elements);
    }

    private void parseJsonSection(String title, JsonConfigurationSection section) {
        for (Entry<String, JsonElement> entry : section.json().entrySet()) {
            if (entry.getValue().isJsonObject()) {
                if (title == null) {
                    parseJsonSection(entry.getKey(), section.getSection(entry.getKey()));
                } else {
                    parseJsonSection(title + "." + entry.getKey(), section.getSection(entry.getKey()));
                }
            } else {
                if (title == null) {
                    values.put(entry.getKey(), entry.getValue().getAsString());
                } else {
                    values.put(title + "." + entry.getKey(), entry.getValue().getAsString());
                }
            }
        }
    }

    public String getLanguage() {
        return language;
    }

    public String get(String key, Object ... arguments) {
        String line = values.get(key);

        if (line == null) {
            return null;
        }
        for (int i = 0; i < arguments.length; i++) {
            line.replace("{{" + i + "}}", arguments[i].toString());
        }
        return ChatColor.translateAlternateColorCodes('&', line);
    }
}
