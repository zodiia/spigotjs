package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;

public interface JsEntityPickupItemEvent extends JsEntityEvent {
    public JsItemStack getItem();
    public int getRemaining();
    public JsLivingEntity getEntity();
}
