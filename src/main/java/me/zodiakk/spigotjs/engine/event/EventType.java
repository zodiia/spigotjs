package me.zodiakk.spigotjs.engine.event;

public enum EventType {
    ENABLE("enable"),
    DISABLE("disable"),
    RELOAD("reload"),

    // Blocks
    BLOCK_BREAK("blockBreak"),
    BLOCK_PLACE("blockPlace");

    private String name;

    private EventType(String name) {
        this.name = name;
    }

    public static EventType fromName(String name) {
        for (EventType type : values()) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        return null;
    }
}
