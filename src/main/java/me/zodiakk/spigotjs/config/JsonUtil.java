package me.zodiakk.spigotjs.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * A class to parse JSON into objects and objects into JSON.
 *
 * @author Zodiak
 * @since 4.0
 */
public class JsonUtil {
    private static final Gson GSON;

    static {
        GsonBuilder builder = new GsonBuilder();

        GSON = builder.setPrettyPrinting().create();
    }

    /**
     * Write a file with the given JSON element. If the file exists, it will be overwritten.
     * @param json JSON to write
     * @param file File in which it will be written
     * @return False if the file already exists
     */
    public static boolean writeJsonFile(JsonElement json, File file) throws IOException {
        return writeJsonFile(json, file, true);
    }

    /**
     * Write a file with the given JSON element.
     * @param json JSON to write
     * @param file File in which it will be written
     * @param overwrite If the file must be overwritten if it already exists
     * @return False if the file already exists and overwrite is set to false
     */
    public static boolean writeJsonFile(JsonElement json, File file, boolean overwrite) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        if (!overwrite && file.exists()) {
            return false;
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        file.setExecutable(false);
        file.setReadable(true);
        file.setWritable(true);

        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(GSON.toJson(json));

        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (NullPointerException ex) {
            // Do nothing as both variables may be null if anything happened before they were initialized
        }
        return true;
    }

    /**
     * Read a JSON file.
     * @param file File to read
     * @return JSON representation of this file
     */
    public static JsonElement readJsonFile(File file) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement;

        if (!file.exists()) {
            throw new IOException("File does not exists");
        }

        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);

        bufferedReader.lines().forEach(line -> stringBuilder.append(line));
        jsonElement = jsonParser.parse(stringBuilder.toString());

        try {
            bufferedReader.close();
            fileReader.close();
        } catch (NullPointerException ex) {
            // Do nothing as both variables may be null if anything happened before they were initialized
        }

        return jsonElement;
    }

    /**
     * Read a JSON file from its {@link Reader}.
     * @param reader File reader
     * @return JSON representation of this file
     */
    public static JsonElement readJsonFile(Reader reader) throws IOException {
        return new JsonParser().parse(reader);
    }

    /**
     * Convert JSON to an Object.
     * @param <T> Type of the object
     * @param object JSON to convert
     * @param clazz Object class
     * @return Object representation
     */
    public static <T extends Serializable> T objectFromJson(JsonElement object, Class<T> clazz) {
        return GSON.fromJson(object, clazz);
    }

    /**
     * Convert an Object to JSON.
     * @param object Object to convert
     * @return JSON representation
     */
    public static JsonObject objectToJson(Serializable object) {
        return GSON.toJsonTree(object).getAsJsonObject();
    }
}
