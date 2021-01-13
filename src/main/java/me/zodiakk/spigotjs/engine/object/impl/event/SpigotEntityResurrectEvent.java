package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityResurrectEvent;

import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityResurrectEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLivingEntity;

public class SpigotEntityResurrectEvent extends SpigotEntityEvent implements JsEntityResurrectEvent {
    private EntityResurrectEvent event;

    public SpigotEntityResurrectEvent(EntityResurrectEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsLivingEntity getEntity() {
        return new SpigotLivingEntity(event.getEntity());
    }
}
