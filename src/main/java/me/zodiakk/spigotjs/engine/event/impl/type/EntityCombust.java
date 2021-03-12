package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityCombustEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityCombust extends SpigotEventListener {
    public EntityCombust(Script script) {
        super(EventType.ENTITY_COMBUST, script);
    }

    @EventHandler
    public void onEntityCombust(EntityCombustByBlockEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityCombustEvent(event));
    }

    @EventHandler
    public void onEntityCombust(EntityCombustByEntityEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityCombustEvent(event));
    }
}
