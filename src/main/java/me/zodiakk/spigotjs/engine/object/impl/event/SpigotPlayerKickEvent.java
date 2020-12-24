package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerKickEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerKickEvent;

public class SpigotPlayerKickEvent extends SpigotPlayerEvent implements JsPlayerKickEvent {
    private PlayerKickEvent event;

    public SpigotPlayerKickEvent(PlayerKickEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getReason() {
        return event.getReason();
    }

    @Override
    public void setReason(String reason) {
        event.setReason(reason);
    }
}
