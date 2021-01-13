package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLivingEntity;

public interface JsEntityResurrectEvent extends JsEntityEvent {
    public JsLivingEntity getEntity();
}
