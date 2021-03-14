package me.zodiakk.spigotjs.engine.object.event;

public interface JsBlockPistonEvent extends JsBlockEvent {
    public String getDirection();
    public String getAction();
    public boolean isSticky();
}
