package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityPortalEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityPortal extends SpigotEventListener {
    public EntityPortal(Script script) {
        super(EventType.ENTITY_PORTAL, script);
    }

    @EventHandler
    public void onEntityPortal(EntityPortalEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityPortalEvent(event));
    }
}
