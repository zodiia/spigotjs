package me.zodiakk.spigotjs.i18n;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.config.JsonConfiguration;
import me.zodiakk.spigotjs.config.JsonConfigurationSection;

public class I18n {
    private Set<I18nLanguage> languages;
    private String current;

    public I18n() throws IOException {
        languages = new HashSet<I18nLanguage>();

        if (!SpigotJs.exists()) {
            addLanguage("en_EN", JsonConfiguration.getLocalConfiguration(SpigotJs.getInstance(), "lang/en_EN.json"));
            setCurrentLanguage("en_EN");
        }
    }

    public I18nLanguage getLanguage(String key) {
        for (I18nLanguage lang : languages) {
            if (lang.getLanguage().equals(key)) {
                return lang;
            }
        }
        return null;
    }

    public void addLanguage(String key, JsonConfigurationSection section) {
        languages.add(new I18nLanguage(key, section));
    }

    public I18nLanguage getCurrentLanguage() {
        return getLanguage(current);
    }

    public void setCurrentLanguage(String key) {
        current = key;
    }

    public String get(String language, String key, Object... arguments) {
        I18nLanguage lang = getLanguage(language);

        if (lang == null) {
            return null;
        }
        return lang.get(key, arguments);
    }
}
