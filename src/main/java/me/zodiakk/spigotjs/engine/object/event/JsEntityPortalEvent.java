package me.zodiakk.spigotjs.engine.object.event;

public interface JsEntityPortalEvent extends JsEntityTeleportEvent {
    public Number getSearchRadius();
    public void setSearchRadius(Number radius);
}
