package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;

public interface JsEntityChangeBlockEvent extends JsEntityEvent {
    public JsBlock getBlock();
}
