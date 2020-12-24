package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerRespawnEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLocation;

public class SpigotPlayerRespawnEvent extends SpigotPlayerEvent implements JsPlayerRespawnEvent {
    private PlayerRespawnEvent event;

    public SpigotPlayerRespawnEvent(PlayerRespawnEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsLocation getSpawnLocation() {
        return new SpigotLocation(event.getRespawnLocation());
    }

    @Override
    public boolean isBedSpawn() {
        return event.isBedSpawn();
    }

    @Override
    public boolean isAnchorSpawn() {
        return event.isAnchorSpawn();
    }

    @Override
    public void setSpawnLocation(JsLocation location) {
        event.setRespawnLocation(location.java(Location.class));
    }
}
