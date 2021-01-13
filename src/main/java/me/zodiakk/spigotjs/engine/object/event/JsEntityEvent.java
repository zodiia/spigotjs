package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsEvent;

public interface JsEntityEvent extends JsEvent {
    public JsEntity getEntity();
    public String getEntityType();
}
