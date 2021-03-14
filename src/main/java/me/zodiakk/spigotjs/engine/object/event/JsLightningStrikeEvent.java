package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLocation;

public interface JsLightningStrikeEvent extends JsWorldEvent {
    public String getCause();
    public JsLocation getLocation();
}
