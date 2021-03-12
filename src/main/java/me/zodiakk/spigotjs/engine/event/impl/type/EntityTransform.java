package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTransformEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityTransformEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityTransform extends SpigotEventListener {
    public EntityTransform(Script script) {
        super(EventType.ENTITY_TRANSFORM, script);
    }

    @EventHandler
    public void onEntityTransform(EntityTransformEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityTransformEvent(event));
    }
}
