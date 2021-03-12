package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityInteractEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityInteractEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityInteract extends SpigotEventListener {
    public EntityInteract(Script script) {
        super(EventType.ENTITY_INTERACT, script);
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityInteractEvent(event));
    }
}
