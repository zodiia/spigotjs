package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEntity;

public interface JsEntityTransformEvent extends JsEntityEvent {
    public JsEntity[] getNewEntities();
    public String getReason();
}
