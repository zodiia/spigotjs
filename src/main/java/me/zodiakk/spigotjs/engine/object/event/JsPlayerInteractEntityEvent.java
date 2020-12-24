package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEntity;

public interface JsPlayerInteractEntityEvent extends JsPlayerEvent {
    public String getHand();
    public JsEntity getClicked();
}
