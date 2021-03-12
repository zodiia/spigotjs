package me.zodiakk.spigotjs.engine.event.impl;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockBreak;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockPlace;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityChangeBlock;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityCombust;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityDamage;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityDeath;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityDropItem;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityExplode;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityInteract;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityPickupItem;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityPortal;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityResurrect;
import me.zodiakk.spigotjs.engine.event.impl.type.EntitySpawn;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityTeleport;
import me.zodiakk.spigotjs.engine.event.impl.type.EntityTransform;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerChat;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerConnect;
import me.zodiakk.spigotjs.engine.event.impl.type.PlayerDeath;
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
        case PLAYER_DEATH: return new PlayerDeath(script);
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

        // Entities
        case ENTITY_CHANGE_BLOCK: return new EntityChangeBlock(script);
        case ENTITY_COMBUST: return new EntityCombust(script);
        case ENTITY_DAMAGE: return new EntityDamage(script);
        case ENTITY_DEATH: return new EntityDeath(script);
        case ENTITY_DROP_ITEM: return new EntityDropItem(script);
        case ENTITY_EXPLODE: return new EntityExplode(script);
        case ENTITY_INTERACT: return new EntityInteract(script);
        case ENTITY_PICKUP_ITEM: return new EntityPickupItem(script);
        case ENTITY_PORTAL: return new EntityPortal(script);
        case ENTITY_RESURRECT: return new EntityResurrect(script);
        case ENTITY_SPAWN: return new EntitySpawn(script);
        case ENTITY_TELEPORT: return new EntityTeleport(script);
        case ENTITY_TRANSFORM: return new EntityTransform(script);

        default: return null;
        }
    }

    public static EventListenerFactory getInstance() {
        return INSTANCE;
    }
}
