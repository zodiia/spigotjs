package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityCombustEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;

public class SpigotEntityCombustEvent extends SpigotEntityEvent implements JsEntityCombustEvent {
    private EntityCombustByBlockEvent eventBlock;
    private EntityCombustByEntityEvent eventEntity;
    private EntityCombustEvent event;

    public SpigotEntityCombustEvent(EntityCombustByBlockEvent event) {
        super(event);
        this.event = event;
        this.eventBlock = event;
    }

    public SpigotEntityCombustEvent(EntityCombustByEntityEvent event) {
        super(event);
        this.event = event;
        this.eventEntity = event;
    }

    @Override
    public Number getDuration() {
        return event.getDuration();
    }

    @Override
    public void setDuration(Number duration) {
        event.setDuration(duration.intValue());
    }

    @Override
    public String getSourceType() {
        return (eventBlock == null ? "entity" : "block");
    }

    @Override
    public JsEntity getSourceEntity() {
        if (eventEntity != null) {
            return new SpigotEntity(eventEntity.getCombuster());
        }
        return null;
    }

    @Override
    public JsBlock getSourceBlock() {
        if (eventBlock != null) {
            return new SpigotBlock(eventBlock.getCombuster());
        }
        return null;
    }
}
