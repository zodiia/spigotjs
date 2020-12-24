package me.zodiakk.spigotjs.engine.event;

public enum EventType {
    ENABLE("enable"),
    DISABLE("disable"),
    RELOAD("reload"),

    // Blocks
    BLOCK_BREAK("blockBreak"),
    BLOCK_PLACE("blockPlace"),

    // Players
    PLAYER_CHAT("playerChat"),
    PLAYER_CONNECT("playerConnect"),
    PLAYER_DISCONNECT("playerDisconnect"),
    PLAYER_DROP_ITEM("playerDropItem"),
    PLAYER_EXPERIENCE("playerExperience"),
    PLAYER_INTERACT_ENTITY("playerInteractEntity"),
    PLAYER_INTERACT("playerInteract"),
    PLAYER_KICK("playerKick"),
    PLAYER_MOVE("playerMove"),
    PLAYER_PORTAL("playerPortal"),
    PLAYER_RESPAWN("playerRespawn"),
    PLAYER_TELEPORT("playerTeleport"),

    ;
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
