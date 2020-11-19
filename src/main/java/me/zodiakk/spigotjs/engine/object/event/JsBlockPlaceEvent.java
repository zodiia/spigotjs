package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsBlockPlaceEvent extends JsBlockEvent {
    public boolean getCanBuild();
    public JsBlock getBlockAgainst();
    public JsItemStack getItemInHand();
    public JsPlayer getPlayer();
    public void setCanBuild(Boolean canBuild);
}
