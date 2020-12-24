package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerPortalEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerPortalEvent;

public class SpigotPlayerPortalEvent extends SpigotPlayerTeleportEvent implements JsPlayerPortalEvent {
    private PlayerPortalEvent event;

    public SpigotPlayerPortalEvent(PlayerPortalEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public boolean getCanCreatePortal() {
        return event.getCanCreatePortal();
    }

    @Override
    public Number getCreationRadius() {
        return event.getCreationRadius();
    }

    @Override
    public Number getSearchRadius() {
        return event.getSearchRadius();
    }

    @Override
    public void setCanCreatePortal(Boolean canCreatePortal) {
        event.setCanCreatePortal(canCreatePortal);
    }

    @Override
    public void setCreationRadius(Number creationRadius) {
        event.setCreationRadius(creationRadius.intValue());
    }

    @Override
    public void setSearchRadius(Number searchRadius) {
        event.setSearchRadius(searchRadius.intValue());
    }
}
