package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEvent;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public interface JsWorldEvent extends JsEvent {
    public JsWorld getWorld();
}
