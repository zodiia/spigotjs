package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsItemStack;

public interface JsBlockDispenseEvent extends JsBlockEvent {
    public JsItemStack getItem();
    public void setItem(JsItemStack item);
}
