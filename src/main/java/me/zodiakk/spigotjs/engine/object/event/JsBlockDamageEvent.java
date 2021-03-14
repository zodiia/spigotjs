package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsBlockDamageEvent extends JsBlockEvent {
    public boolean getInstantBreaking();
    public JsItemStack getItem();
    public JsPlayer getPlayer();
    public void setInstaBreak(boolean instaBreak);
}
