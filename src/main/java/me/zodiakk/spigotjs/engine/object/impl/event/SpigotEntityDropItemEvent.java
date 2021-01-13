package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityDropItemEvent;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.event.JsEntityDropItemEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;

public class SpigotEntityDropItemEvent extends SpigotEntityEvent implements JsEntityDropItemEvent {
    private EntityDropItemEvent event;

    public SpigotEntityDropItemEvent(EntityDropItemEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsItemStack getItem() {
        return new SpigotItemStack(event.getItemDrop().getItemStack());
    }
}
