package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityResurrectEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityResurrectEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityResurrect extends SpigotEventListener {
    public EntityResurrect(Script script) {
        super(EventType.ENTITY_RESURRECT, script);
    }

    @EventHandler
    public void onEntityResurrect(EntityResurrectEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityResurrectEvent(event));
    }
}
