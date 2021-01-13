package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityPortalEvent;

import me.zodiakk.spigotjs.engine.object.event.JsEntityPortalEvent;

public class SpigotEntityPortalEvent extends SpigotEntityTeleportEvent implements JsEntityPortalEvent {
    private EntityPortalEvent event;

    public SpigotEntityPortalEvent(EntityPortalEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public Number getSearchRadius() {
        return event.getSearchRadius();
    }

    @Override
    public void setSearchRadius(Number radius) {
        event.setSearchRadius(radius.intValue());
    }
}
