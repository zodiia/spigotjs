package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTeleportEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityTeleportEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityTeleport extends SpigotEventListener {
    public EntityTeleport(Script script) {
        super(EventType.ENTITY_TELEPORT, script);
    }

    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityTeleportEvent(event));
    }
}
