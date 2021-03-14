package me.zodiakk.spigotjs.engine.event;

public enum EventType {
    // Script events
    ENABLE("enable"),
    DISABLE("disable"),
    RELOAD("reload"),

    // Blocks
    BLOCK_BREAK("blockBreak"),
    BLOCK_BURN("blockBurn"),
    BLOCK_DAMAGE("blockDamage"),
    BLOCK_DISPENSE("blockDispense"),
    BLOCK_EXPLODE("blockExplode"),
    BLOCK_PISTON("blockPiston"),
    BLOCK_PLACE("blockPlace"),

    // Players
    PLAYER_CHAT("playerChat"),
    PLAYER_CONNECT("playerConnect"),
    PLAYER_DEATH("playerDeath"),
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

    // Entities
    ENTITY_CHANGE_BLOCK("entityChangeBlock"),
    ENTITY_COMBUST("entityCombust"),
    ENTITY_DAMAGE("entityDamage"),
    ENTITY_DEATH("entityDeath"),
    ENTITY_DROP_ITEM("entityDropItem"),
    ENTITY_EXPLODE("entityExplode"),
    ENTITY_INTERACT("entityInteract"),
    ENTITY_PICKUP_ITEM("entityPickupItem"),
    ENTITY_PORTAL("entityPortal"),
    ENTITY_RESURRECT("entityResurrect"),
    ENTITY_SPAWN("entitySpawn"),
    ENTITY_STATUS("entityStatus"),
    ENTITY_TELEPORT("entityTeleport"),
    ENTITY_TRANSFORM("entityTransform"),

    // World
    LIGHTNING_STRIKE("lightningStrike"),
    PORTAL_CREATE("portalCreate"),
    WEATHER_CHANGE("weatherChange"),
    WORLD_LOAD("worldLoad"),
    WORLD_UNLOAD("worldUnload"),

    // Server
    SERVER_PING("serverPing"),
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
