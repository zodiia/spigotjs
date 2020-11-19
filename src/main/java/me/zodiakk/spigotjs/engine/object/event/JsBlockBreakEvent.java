package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsBlockBreakEvent extends JsBlockExpEvent {
    public JsPlayer getPlayer();
    public boolean  getDropItems();
    public void     setDropItems(Boolean dropItems);
}
