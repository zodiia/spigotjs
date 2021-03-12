package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityDamageEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;

public class SpigotEntityDamageEvent extends SpigotEntityEvent implements JsEntityDamageEvent {
    private EntityDamageByBlockEvent eventBlock;
    private EntityDamageByEntityEvent eventEntity;
    private EntityDamageEvent event;

    public SpigotEntityDamageEvent(EntityDamageByBlockEvent event) {
        super(event);
        this.event = event;
        this.eventBlock = event;
    }

    public SpigotEntityDamageEvent(EntityDamageByEntityEvent event) {
        super(event);
        this.event = event;
        this.eventEntity = event;
    }

    @Override
    public String getCause() {
        return event.getCause().toString().toLowerCase();
    }

    @Override
    public Number getDamage() {
        return event.getDamage();
    }

    @Override
    public Number getFinalDamage() {
        return event.getFinalDamage();
    }

    @Override
    public void setDamage(Number damage) {
        event.setDamage(damage.doubleValue());
    }

    @Override
    public String getSourceType() {
        return (eventBlock == null ? "entity" : "block");
    }

    @Override
    public JsEntity getSourceEntity() {
        if (eventEntity != null) {
            return new SpigotEntity(eventEntity.getDamager());
        }
        return null;
    }

    @Override
    public JsBlock getSourceBlock() {
        if (eventBlock != null) {
            return new SpigotBlock(eventBlock.getDamager());
        }
        return null;
    }
}
