package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerDropItemEvent;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerDropItemEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;

public class SpigotPlayerDropItemEvent extends SpigotPlayerEvent implements JsPlayerDropItemEvent {
    private PlayerDropItemEvent event;

    public SpigotPlayerDropItemEvent(PlayerDropItemEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsItemStack getDroppedItem() {
        return new SpigotItemStack(event.getItemDrop().getItemStack());
    }

    @Override
    public JsEntity getItemEntity() {
        return new SpigotEntity(event.getItemDrop());
    }
}
