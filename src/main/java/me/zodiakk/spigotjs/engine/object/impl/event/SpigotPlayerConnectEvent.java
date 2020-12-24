package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerJoinEvent;

import me.zodiakk.spigotjs.engine.object.event.JsPlayerConnectEvent;

public class SpigotPlayerConnectEvent extends SpigotPlayerEvent implements JsPlayerConnectEvent {
    private PlayerJoinEvent event;

    public SpigotPlayerConnectEvent(PlayerJoinEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getMessage() {
        return event.getJoinMessage();
    }

    @Override
    public void setMessage(String message) {
        event.setJoinMessage(message);
    }
}
