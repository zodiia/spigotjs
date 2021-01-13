package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntitySpawnEvent;

import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.event.JsEntitySpawnEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLocation;

public class SpigotEntitySpawnEvent extends SpigotEntityEvent implements JsEntitySpawnEvent {
    private EntitySpawnEvent event;

    public SpigotEntitySpawnEvent(EntitySpawnEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsLocation getLocation() {
        return new SpigotLocation(event.getLocation());
    }
}
