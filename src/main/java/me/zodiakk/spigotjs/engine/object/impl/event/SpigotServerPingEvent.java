package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.server.ServerListPingEvent;

import me.zodiakk.spigotjs.engine.object.event.JsServerPingEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEvent;

public class SpigotServerPingEvent extends SpigotEvent implements JsServerPingEvent {
    private ServerListPingEvent event;

    public SpigotServerPingEvent(ServerListPingEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getAddress() {
        return event.getAddress().toString();
    }

    @Override
    public Number getMaxPlayers() {
        return event.getMaxPlayers();
    }

    @Override
    public String getMotd() {
        return event.getMotd();
    }

    @Override
    public void setMaxPlayers(Number max) {
        event.setMaxPlayers(max.intValue());
    }

    @Override
    public void setMotd(String motd) {
        event.setMotd(motd);
    }
}
