package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntitySpawnEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntitySpawn extends SpigotEventListener {
    public EntitySpawn(Script script) {
        super(EventType.ENTITY_SPAWN, script);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntitySpawnEvent(event));
    }
}
