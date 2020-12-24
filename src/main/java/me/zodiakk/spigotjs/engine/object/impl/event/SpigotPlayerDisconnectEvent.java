package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerQuitEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerDisconnectEvent;

public class SpigotPlayerDisconnectEvent extends SpigotPlayerEvent implements JsPlayerDisconnectEvent {
    private PlayerQuitEvent event;

    public SpigotPlayerDisconnectEvent(PlayerQuitEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getQuitMessage();
    }

    @Override
    public void setMessage(String message) {
        event.setQuitMessage(message);
    }
}
