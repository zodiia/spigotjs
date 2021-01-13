package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;

public interface JsEntityExplodeEvent extends JsEntityEvent {
    public JsBlock[] getBlocks();
    public Number getYield();
    public void setYield(Number yield);
}
