package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityPickupItemEvent;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityPickupItemEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLivingEntity;

public class SpigotEntityPickupItemEvent extends SpigotEntityEvent implements JsEntityPickupItemEvent {
    private EntityPickupItemEvent event;

    public SpigotEntityPickupItemEvent(EntityPickupItemEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsItemStack getItem() {
        return new SpigotItemStack(event.getItem().getItemStack());
    }

    @Override
    public int getRemaining() {
        return event.getRemaining();
    }

    @Override
    public JsLivingEntity getEntity() {
        return new SpigotLivingEntity(event.getEntity());
    }
}
