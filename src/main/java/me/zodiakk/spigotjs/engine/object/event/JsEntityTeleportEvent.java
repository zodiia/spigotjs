package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLocation;

public interface JsEntityTeleportEvent extends JsEntityEvent {
    public JsLocation getFrom();
    public JsLocation getTo();
    public void setFrom(JsLocation location);
    public void setTo(JsLocation location);
}
