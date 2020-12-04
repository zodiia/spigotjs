package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEvent;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsPlayerEvent extends JsEvent {
    public JsPlayer getPlayer();
}
