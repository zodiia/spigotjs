package me.zodiakk.spigotjs.config;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * Represents a section of a JSON configuration file.
 *
 * @author Zodiak
 * @since 4.1
 */
public class JsonConfigurationSection {
    protected final JsonObject section;

    JsonConfigurationSection(JsonObject section) {
        this.section = section;
    }

    /**
     * Get this section as a JSON object.
     * @return A JSON object representing this section
     */
    public final JsonObject json() {
        return section;
    }

    /**
     * Check if the specified key is a section.
     * @param key Key to check
     * @return True if the key is a section
     */
    public boolean isSection(String key) {
        if (!has(key)) {
            return false;
        }
        return section.get(key).isJsonObject();
    }

    /**
     * Check if the specified key is an array.
     * @param key Key to check
     * @return True if the key is an array
     */
    public boolean isArray(String key) {
        if (!has(key)) {
            return false;
        }
        return section.get(key).isJsonArray();
    }

    /**
     * Check if the specified key is a value (Number, String or Boolean).
     * @param key Key to check
     * @return True if the key is a section
     */
    public boolean isValue(String key) {
        if (!has(key)) {
            return false;
        }
        return section.get(key).isJsonPrimitive();
    }

    /**
     * Check if the specified key is null.
     * @param key Key to check
     * @return True if the key is null
     */
    public boolean isNull(String key) {
        if (!has(key)) {
            return false;
        }
        return section.get(key).isJsonNull();
    }

    /**
     * Check if the specified key exists.
     * @return True if the key exists
     */
    public boolean has(String key) {
        return section.has(key);
    }

    /**
     * Remove the specified key from the configuration.
     * @param key Key to remove
     * @return True if the key existed and was successfully removed
     */
    public boolean remove(String key) {
        if (!has(key)) {
            return false;
        }
        section.remove(key);
        return true;
    }

    /**
     * Create a new array in the configuration.
     * @param key Key of the new array
     * @return True if the key didn't already exist and if the array was successfully created
     */
    public boolean createArray(String key) {
        if (has(key)) {
            return false;
        }
        section.add(key, new JsonArray());
        return true;
    }

    /**
     * Create a new section in the configuration.
     * @param key Key of the new section
     * @return True if the key didn't already exist and if the section was successfully created
     */
    public boolean createSection(String key) {
        if (has(key)) {
            return false;
        }
        section.add(key, new JsonObject());
        return true;
    }

    /**
     * Get all keys of this section.
     * @return A set of keys in this section
     */
    public Set<String> keySet() {
        HashSet<String> keys = new HashSet<String>();

        section.entrySet().stream().forEach(key -> keys.add(key.getKey()));
        return keys;
    }

    /**
     * Get a stream of all entries in this section.
     * @return Stream of entries
     */
    public Stream<Entry<String, JsonElement>> stream() {
        return section.entrySet().stream();
    }

    /**
     * Set the specified key to null.
     * @param key Key to update
     */
    public void setNull(String key) {
        remove(key);
        section.add(key, JsonNull.INSTANCE);
    }

    /**
     * Get the value of the specified key as a {@link BigDecimal}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public BigDecimal getBigDecimal(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsBigDecimal();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link BigDecimal}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<BigDecimal> getBigDecimalArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsBigDecimal()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link BigInteger}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public BigInteger getBigInteger(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsBigInteger();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link BigInteger}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<BigInteger> getBigIntegerArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsBigInteger()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link Boolean}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Boolean getBoolean(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsBoolean();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Boolean}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Boolean> getBooleanArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Boolean> list = new ArrayList<Boolean>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsBoolean()));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setBoolean(String key, Boolean value) {
        remove(key);
        section.addProperty(key, value);
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setBooleanArray(String key, Collection<Boolean> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value)));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as a {@link Byte}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Byte getByte(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsByte();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Byte}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Byte> getByteArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Byte> list = new ArrayList<Byte>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsByte()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link Double}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Double getDouble(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsDouble();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Double}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Double> getDoubleArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Double> list = new ArrayList<Double>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsDouble()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link Float}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Float getFloat(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsFloat();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Float}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Float> getFloatArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Float> list = new ArrayList<Float>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsFloat()));
        return list;
    }

    /**
     * Get the value of the specified key as an {@link Integer}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Integer getInteger(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsInt();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Integer}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Integer> getIntegerArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsInt()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link Long}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Long getLong(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsLong();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Long}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Long> getLongArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Long> list = new ArrayList<Long>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsLong()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link Number}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Number getNumber(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsNumber();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Number}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Number> getNumberArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Number> list = new ArrayList<Number>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsNumber()));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setNumber(String key, Number value) {
        remove(key);
        section.addProperty(key, value);
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setNumberArray(String key, Collection<? extends Number> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value)));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as a {@link Short}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Short getShort(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsShort();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Short}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Short> getShortArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Short> list = new ArrayList<Short>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsShort()));
        return list;
    }

    /**
     * Get the value of the specified key as a {@link String}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public String getString(String key) {
        if (!has(key)) {
            return null;
        }
        return section.get(key).getAsString();
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link String}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<String> getStringArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<String> list = new ArrayList<String>();

        section.getAsJsonArray(key).forEach(elem -> list.add(elem.getAsString()));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setString(String key, String value) {
        remove(key);
        section.addProperty(key, value);
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setStringArray(String key, Collection<String> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value)));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as an {@link UUID}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public UUID getUUID(String key) {
        if (!has(key)) {
            return null;
        }
        return UUID.fromString(section.get(key).getAsString());
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link UUID}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<UUID> getUUIDArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<UUID> list = new ArrayList<UUID>();

        section.getAsJsonArray(key).forEach(elem -> list.add(UUID.fromString(elem.getAsString())));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setUUID(String key, UUID value) {
        remove(key);
        section.addProperty(key, value.toString());
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setUUIDArray(String key, Collection<UUID> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value.toString())));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as a {@link Player}. The value must be a valid UUID
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public Player getPlayer(String key) {
        if (!has(key)) {
            return null;
        }
        return Bukkit.getPlayer(getUUID(key));
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Player}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<Player> getPlayerArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<Player> list = new ArrayList<Player>();
        List<UUID> uuids = getUUIDArray(key);

        uuids.forEach(uuid -> list.add(Bukkit.getPlayer(uuid)));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setPlayer(String key, Player value) {
        remove(key);
        section.addProperty(key, value.getUniqueId().toString());
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setPlayerArray(String key, Collection<Player> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value.getUniqueId().toString())));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as an {@link OfflinePlayer}. The value must be a valid UUID
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public OfflinePlayer getOfflinePlayer(String key) {
        if (!has(key)) {
            return null;
        }
        return Bukkit.getOfflinePlayer(getUUID(key));
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link OfflinePlayer}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public List<OfflinePlayer> getOfflinePlayerArray(String key) {
        if (!has(key)) {
            return null;
        }
        ArrayList<OfflinePlayer> list = new ArrayList<OfflinePlayer>();
        List<UUID> uuids = getUUIDArray(key);

        uuids.forEach(uuid -> list.add(Bukkit.getOfflinePlayer(uuid)));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setOfflinePlayer(String key, OfflinePlayer value) {
        remove(key);
        section.addProperty(key, value.getUniqueId().toString());
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setOfflinePlayerArray(String key, Collection<OfflinePlayer> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(new JsonPrimitive(value.getUniqueId().toString())));
        section.add(key, array);
    }

    /**
     * Get the value of the specified key as an {@link Object}.
     * @param key Key to retrieve
     * @return Value mapped to this key
     */
    public <T extends Serializable> T getObject(String key, Class<T> clazz) {
        if (!has(key)) {
            return null;
        }
        return JsonUtil.objectFromJson(section.getAsJsonObject(key), clazz);
    }

    /**
     * Get the value of the specified key as a {@link List} of {@link Object}s. The value must be a valid JSON array
     * @param key Key to retrieve
     * @return Values mapped to this key
     */
    public <T extends Serializable> List<T> getObjectArray(String key, Class<T> clazz) {
        if (!has(key)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        section.getAsJsonArray(key).forEach(elem -> list.add(JsonUtil.objectFromJson(elem, clazz)));
        return list;
    }

    /**
     * Set the value of the specified key.
     * @param key Key to update
     * @param value New value to map to this key
     */
    public void setObject(String key, Serializable value) {
        remove(key);
        section.add(key, JsonUtil.objectToJson(value));
    }

    /**
     * Set the values of the specified key.
     * @param key Key to update
     * @param values New values to map to this key
     */
    public void setObjectArray(String key, Collection<Serializable> values) {
        remove(key);
        JsonArray array = new JsonArray();
        values.forEach(value -> array.add(JsonUtil.objectToJson(value)));
        section.add(key, array);
    }

    /**
     * Get a sub-section of this section. Value must be a valid JSON object
     * @param name Name (key) of the section
     * @return The section associated to this key
     */
    public JsonConfigurationSection getSection(String name) {
        if (!has(name) || !section.get(name).isJsonObject()) {
            return null;
        }
        return new JsonConfigurationSection(this.section.get(name).getAsJsonObject());
    }

    /**
     * Get an array of sub-sections. Value must be a valid JSON array of JSON objects
     * @param arrayName Name (key) of the array
     * @return The array of sections associated to this key
     */
    public List<JsonConfigurationSection> getSectionArray(String arrayName) {
        if (!has(arrayName) || !section.get(arrayName).isJsonArray()) {
            return null;
        }
        ArrayList<JsonConfigurationSection> list = new ArrayList<JsonConfigurationSection>();
        section.getAsJsonArray(arrayName).forEach(elem -> list.add(new JsonConfigurationSection(elem.getAsJsonObject())));
        return list;
    }

    /**
     * Merge this section with the provided section.
     * @param newSection Section to merge into this one
     */
    public void mergeConfiguration(JsonConfigurationSection newSection) {
        newSection.section.entrySet().forEach(element -> {
            if (!this.section.has(element.getKey())) {
                this.section.add(element.getKey(), element.getValue());
            } else if (element.getValue().isJsonObject()) {
                getSection(element.getKey()).mergeConfiguration(newSection.getSection(element.getKey()));
            }
        });
    }
}
