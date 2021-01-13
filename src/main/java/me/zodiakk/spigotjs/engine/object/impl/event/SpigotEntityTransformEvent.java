package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityTransformEvent;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityTransformEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;

public class SpigotEntityTransformEvent extends SpigotEntityEvent implements JsEntityTransformEvent {
    private EntityTransformEvent event;

    public SpigotEntityTransformEvent(EntityTransformEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsEntity[] getNewEntities() {
        JsEntity[] entities = new JsEntity[event.getTransformedEntities().size()];

        for (int i = 0; i < event.getTransformedEntities().size(); i++) {
            entities[i] = new SpigotEntity(event.getTransformedEntities().get(i));
        }
        return entities;
    }

    @Override
    public String getReason() {
        return event.getTransformReason().toString().toLowerCase();
    }
}
