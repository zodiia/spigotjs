package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.Location;
import org.bukkit.event.entity.EntityTeleportEvent;

import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.event.JsEntityTeleportEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLocation;

public class SpigotEntityTeleportEvent extends SpigotEntityEvent implements JsEntityTeleportEvent {
    private EntityTeleportEvent event;

    public SpigotEntityTeleportEvent(EntityTeleportEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsLocation getFrom() {
        return new SpigotLocation(event.getFrom());
    }

    @Override
    public JsLocation getTo() {
        return new SpigotLocation(event.getTo());
    }

    @Override
    public void setFrom(JsLocation location) {
        event.setFrom(location.java(Location.class));
    }

    @Override
    public void setTo(JsLocation location) {
        event.setTo(location.java(Location.class));
    }
}
