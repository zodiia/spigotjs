package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLocation;

public interface JsPlayerMoveEvent extends JsPlayerEvent {
    public JsLocation getFrom();
    public JsLocation getTo();
    public void setFrom(JsLocation location);
    public void setTo(JsLocation location);
}
