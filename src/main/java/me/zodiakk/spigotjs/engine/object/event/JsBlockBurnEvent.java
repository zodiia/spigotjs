package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;

public interface JsBlockBurnEvent extends JsBlockEvent {
    public JsBlock getIgnitingBlock();
}
