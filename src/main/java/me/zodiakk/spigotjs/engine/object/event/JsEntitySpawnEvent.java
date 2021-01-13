package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLocation;

public interface JsEntitySpawnEvent extends JsEntityEvent {
    public JsLocation getLocation();
}
