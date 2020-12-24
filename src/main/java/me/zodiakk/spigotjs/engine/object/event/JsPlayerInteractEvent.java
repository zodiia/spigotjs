package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;

public interface JsPlayerInteractEvent extends JsPlayerEvent {
    public String getAction();
    public String getBlockFace();
    public JsBlock getBlock();
    public String getHand();
    public JsItemStack getItem();
    public boolean hasBlock();
    public boolean hasItem();
    public boolean isBlockInHand();
}
