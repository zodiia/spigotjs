package me.zodiakk.spigotjs.engine.object.event;

public interface JsPlayerPortalEvent extends JsPlayerTeleportEvent {
    public boolean getCanCreatePortal();
    public Number getCreationRadius();
    public Number getSearchRadius();
    public void setCanCreatePortal(Boolean canCreatePortal);
    public void setCreationRadius(Number creationRadius);
    public void setSearchRadius(Number searchRadius);
}
