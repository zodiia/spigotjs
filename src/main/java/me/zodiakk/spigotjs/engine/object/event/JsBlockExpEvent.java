package me.zodiakk.spigotjs.engine.object.event;

public interface JsBlockExpEvent extends JsBlockEvent {
    public int getExpToDrop();
    public void setExpToDrop(Number exp);
}
