package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerTeleportEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerTeleportEvent;

public class SpigotPlayerTeleportEvent extends SpigotPlayerMoveEvent implements JsPlayerTeleportEvent {
    private PlayerTeleportEvent event;

    public SpigotPlayerTeleportEvent(PlayerTeleportEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getCause() {
        return event.getCause().toString().toLowerCase();
    }
}
