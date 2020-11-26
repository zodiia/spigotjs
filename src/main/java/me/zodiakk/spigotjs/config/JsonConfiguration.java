package me.zodiakk.spigotjs.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

import com.google.gson.JsonObject;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Represents a complete JSON file.
 *
 * @author Zodiak
 * @since 4.0
 */
public class JsonConfiguration extends JsonConfigurationSection {
    private static final HashMap<String, JsonConfiguration> CONFIGURATION_FILES;

    private final File file;

    static {
        CONFIGURATION_FILES = new HashMap<String, JsonConfiguration>();
    }

    private JsonConfiguration(File file) throws IOException {
        super(JsonUtil.readJsonFile(file).getAsJsonObject());

        this.file = file;
    }

    private JsonConfiguration(JsonObject obj) {
        super(obj);

        this.file = null;
    }

    /**
     * Get a JSON configuration file. By default, it will not be reloaded if it already has been parsed.
     * @param file File to parse
     * @return An instance of this configuration file
     */
    public static JsonConfiguration getConfiguration(File file) throws IOException {
        return getConfiguration(file, false);
    }

    /**
     * Get a JSON configuration file.
     * @param file   File to parse
     * @param reload Whether to reload the file if it was already parsed
     * @return An instance of this configuration file
     */
    public static JsonConfiguration getConfiguration(File file, boolean reload) throws IOException {
        if (!reload && CONFIGURATION_FILES.containsKey(file.getPath())) {
            return CONFIGURATION_FILES.get(file.getPath());
        }
        JsonConfiguration configuration = new JsonConfiguration(file);

        CONFIGURATION_FILES.remove(file.getPath());
        CONFIGURATION_FILES.put(file.getPath(), configuration);
        return configuration;
    }

    /**
     * Get a local JSON configuration file.
     * @param plugin   Plugin in which to extract the configuration file
     * @param fileName Path to the file in the plugin's jar file
     * @return An instance of this configuration file
     */
    public static JsonConfiguration getLocalConfiguration(Plugin plugin, String fileName) throws IOException {
        InputStream stream = plugin.getClass().getResourceAsStream("/" + fileName);
        Reader reader = new InputStreamReader(stream);
        JsonConfiguration config = new JsonConfiguration(JsonUtil.readJsonFile(reader).getAsJsonObject());

        reader.close();
        stream.close();
        return config;
    }

    /**
     * Copy a configuration file from the plugin jar file if it doesn't exists. Otherwise, updates it.
     * @param plugin   Plugin to extract the configuration file from
     * @param fileName Configuration file name
     */
    public static JsonConfiguration extractConfiguration(Plugin plugin, String fileName) throws IOException {
        File file = new File(plugin.getDataFolder(), fileName);

        if (CONFIGURATION_FILES.containsKey(file.getPath())) {
            return CONFIGURATION_FILES.get(file.getPath());
        }

        plugin.getDataFolder().mkdirs();
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            InputStream stream = plugin.getClass().getResourceAsStream("/" + fileName);
            FileOutputStream output = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            for (int i = 0; (i = stream.read(buffer)) != -1;) {
                output.write(buffer, 0, i);
            }
            output.close();
            stream.close();
        } else {
            JsonConfiguration.getConfiguration(file).updateConfiguration(plugin, fileName, true);
        }
        return JsonConfiguration.getConfiguration(file);
    }

    /**
     * Get the root section.
     * @return Root section
     */
    public JsonConfigurationSection getRoot() {
        return (JsonConfigurationSection) this;
    }

    /**
     * Get this configuration file's version, represented by the {@code _version} key in the file.
     * @return The version
     */
    public Version getConfigurationVersion() {
        if (this.section.has("_version")) {
            return new Version(this.section.get("_version").getAsString());
        }
        Bukkit.getLogger().warning("Configuration file " + this.file.getName() + " does not have a version field.");
        return null;
    }

    /**
     * Save this configuration file to the one it was read from.
     */
    public void saveConfiguration() throws IOException {
        JsonUtil.writeJsonFile(this.section, this.file);
    }

    /**
     * Save this configuration file to the one provided.
     * @param file File to save the configuration in
     */
    public void saveConfiguration(File file) throws IOException {
        JsonUtil.writeJsonFile(this.section, file);
    }

    /**
     * Update the configuration from its local resource path.
     * @param plugin            Current plugin
     * @param localResourcePath Local resource path (in the resource directory of the plugin's jar file)
     * @param writeFile         Whether to write the file on the file system
     */
    public void updateConfiguration(Plugin plugin, String localResourcePath, boolean writeFile) throws IOException {
        String temporaryPath = localResourcePath.replaceAll("([\\\\\\/]?)([^\\\\\\/]*\\.[^\\\\\\/]*)$", "$1__$2");
        File updatedFile = new File(plugin.getDataFolder(), temporaryPath);
        Version newVersion;
        Version actualVersion;
        JsonConfiguration config;

        try {
            if (updatedFile.exists()) {
                updatedFile.delete();
            }
            updatedFile.createNewFile();
            InputStream stream = plugin.getClass().getResourceAsStream("/" + localResourcePath);
            FileOutputStream output = new FileOutputStream(updatedFile);
            byte[] buffer = new byte[1024];
            for (int i = 0; (i = stream.read(buffer)) != -1;) {
                output.write(buffer, 0, i);
            }
            output.close();
            stream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Bukkit.getLogger().severe("Could not update configuration file " + localResourcePath + ".");
            return;
        }
        config = new JsonConfiguration(updatedFile);
        if ((newVersion = config.getConfigurationVersion()) == null) {
            Bukkit.getLogger().warning("New version of " + localResourcePath + " doesn't have a \"_version\" prop.");
            return;
        } else if ((actualVersion = getConfigurationVersion()) == null) {
            Bukkit.getLogger().warning("Current version of " + localResourcePath + " doesn't have a \"_version\" prop.");
            return;
        } else if (actualVersion.compareTo(newVersion) != 0) {
            mergeConfiguration(config);
            this.section.remove("_version");
            this.section.addProperty("_version", config.getConfigurationVersion().getVersionString());
            if (writeFile) {
                JsonUtil.writeJsonFile(this.section, file);
            }
        }
        try {
            updatedFile.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
            Bukkit.getLogger().warning("File " + localResourcePath + " has been updated, but update files could not be deleted. A delete will be attempted on server shutdown.");
            updatedFile.deleteOnExit();
            return;
        }
    }
}
