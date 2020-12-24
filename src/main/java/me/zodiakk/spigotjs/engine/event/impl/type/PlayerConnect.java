package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerConnectEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerConnect extends SpigotEventListener {
    public PlayerConnect(Script script) {
        super(EventType.PLAYER_CONNECT, script);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerConnectEvent(event));
    }
}
