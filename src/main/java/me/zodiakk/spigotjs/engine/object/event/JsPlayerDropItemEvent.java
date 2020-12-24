package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsItemStack;

public interface JsPlayerDropItemEvent extends JsPlayerEvent {
    public JsItemStack getDroppedItem();
    public JsEntity getItemEntity();
}
