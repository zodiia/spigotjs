package me.zodiakk.spigotjs.engine.event.impl;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockBreak;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockPlace;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerChat;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerConnect;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerDisconnect;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerDropItem;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerExperience;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerInteract;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerInteractEntity;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerKick;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerMove;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerPortal;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerRespawn;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerTeleport;
import me.zodiakk.spigotjs.engine.script.Script;

public class EventListenerFactory {
    private static final EventListenerFactory INSTANCE = new EventListenerFactory();

    public JsEventListener create(EventType type, Script script) {
        switch (type) {

        // System
        case ENABLE: return new ScriptEventListener(EventType.ENABLE, script) {};
        case DISABLE: return new ScriptEventListener(EventType.DISABLE, script) {};
        case RELOAD: return new ScriptEventListener(EventType.RELOAD, script) {};

        // Blocks
        case BLOCK_BREAK: return new BlockBreak(script);
        case BLOCK_PLACE: return new BlockPlace(script);

        // Players
        case PLAYER_CHAT: return new PlayerChat(script);
        case PLAYER_CONNECT: return new PlayerConnect(script);
        case PLAYER_DISCONNECT: return new PlayerDisconnect(script);
        case PLAYER_DROP_ITEM: return new PlayerDropItem(script);
        case PLAYER_EXPERIENCE: return new PlayerExperience(script);
        case PLAYER_INTERACT_ENTITY: return new PlayerInteractEntity(script);
        case PLAYER_INTERACT: return new PlayerInteract(script);
        case PLAYER_KICK: return new PlayerKick(script);
        case PLAYER_MOVE: return new PlayerMove(script);
        case PLAYER_PORTAL: return new PlayerPortal(script);
        case PLAYER_RESPAWN: return new PlayerRespawn(script);
        case PLAYER_TELEPORT: return new PlayerTeleport(script);

        default: return null;
        }
    }

    public static EventListenerFactory getInstance() {
        return INSTANCE;
    }
}
