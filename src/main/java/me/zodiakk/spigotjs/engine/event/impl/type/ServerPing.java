package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotServerPingEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class ServerPing extends SpigotEventListener {
    public ServerPing(Script script) {
        super(EventType.SERVER_PING, script);
    }

    @EventHandler
    public void onServerPing(ServerListPingEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotServerPingEvent(event));
    }
}
