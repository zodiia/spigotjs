package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityEvent;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEvent;

public class SpigotEntityEvent extends SpigotEvent implements JsEntityEvent {
    private EntityEvent event;

    public SpigotEntityEvent(EntityEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsEntity getEntity() {
        return new SpigotEntity(event.getEntity());
    }

    @Override
    public String getEntityType() {
        return event.getEntity().getType().toString().toLowerCase();
    }
}
