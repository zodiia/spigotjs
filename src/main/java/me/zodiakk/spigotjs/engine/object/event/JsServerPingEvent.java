package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsEvent;

public interface JsServerPingEvent extends JsEvent {
    public String getAddress();
    public Number getMaxPlayers();
    public String getMotd();
    public void setMaxPlayers(Number max);
    public void setMotd(String motd);
}
