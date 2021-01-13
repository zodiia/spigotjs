package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsItemStack;

public interface JsEntityDropItemEvent extends JsEntityEvent {
    public JsItemStack getItem();
}
