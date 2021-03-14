package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;

public interface JsBlockExplodeEvent extends JsBlockEvent {
    public JsBlock[] getBlocks();
    public Number getYield();
    public void setBlocks(JsBlock[] blocks);
    public void setYield(Number yield);
}
