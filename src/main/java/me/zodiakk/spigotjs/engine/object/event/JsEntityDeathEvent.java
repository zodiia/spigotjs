package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;

public interface JsEntityDeathEvent extends JsEntityEvent {
    public Number getDroppedExp();
    public JsItemStack[] getDroppedItems();
    public void setDroppedExp(Number exp);
    public void setDroppedItems(JsItemStack[] items);
    public JsLivingEntity getEntity();
}
