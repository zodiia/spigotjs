package me.zodiakk.spigotjs.engine.script;

import java.util.ArrayList;
import java.util.List;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.util.McVersion;

public class ScriptDescription {
    private final Script script;

    private String name = "";
    private String scriptVersion = "";
    private McVersion mcVersion = McVersion.current();
    private List<String> authors = new ArrayList<String>();
    private String description = "";

    public ScriptDescription(Script script) {
        this.script = script;
    }

    public void fromValue(Value descValue) {
        Value nameValue = getMember(descValue, "name");
        Value scriptVersionValue = getMember(descValue, "version", "scriptVersion", "script-version", "script_version");
        Value mcVersionValue = getMember(descValue, "mcVersion", "mc-version", "mc_version", "minecraftVersion", "minecraft-version", "minecraft_version");
        Value authorsValue = getMember(descValue, "author", "authors");
        Value descriptionValue = getMember(descValue, "description", "desc");

        if (nameValue != null) {
            name = nameValue.asString();
        }
        if (scriptVersionValue != null) {
            scriptVersion = scriptVersionValue.asString();
        }
        if (mcVersionValue != null) {
            mcVersion = McVersion.fromString(mcVersionValue.asString());
        }
        if (authorsValue != null) {
            if (authorsValue.isString()) {
                authors.add(authorsValue.asString());
            } else {
                for (int i = 0; i < authorsValue.getArraySize(); i++) {
                    authors.add(authorsValue.getArrayElement(i).asString());
                }
            }
        }
        if (descriptionValue != null) {
            description = descriptionValue.asString();
        }
    }

    public void setDefaultDescription() {
        name = script.getFileName();
    }

    public String toShortString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        if (scriptVersion.length() > 0) {
            builder.append(" v").append(scriptVersion);
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name);
        if (scriptVersion.length() > 0) {
            builder.append(" v").append(scriptVersion);
        }
        if (authors.size() > 0) {
            builder.append(" by ");
            for (int i = 0; i < authors.size(); i++) {
                if (i > 0) {
                    builder.append(", ");
                }
                builder.append(authors.get(i));
            }
        }
        builder.append(".");
        if (description.length() > 0) {
            builder.append(" Description: ");
            builder.append(description);
        }
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getScriptVersion() {
        return scriptVersion;
    }

    public McVersion getMinecraftVersion() {
        return mcVersion;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getAuthor() {
        return authors.get(0);
    }

    public String getDescription() {
        return description;
    }

    private Value getMember(Value value, String... keys) {
        for (String key : keys) {
            if (value.hasMember(key)) {
                return value.getMember(key);
            }
        }
        return null;
    }
}
