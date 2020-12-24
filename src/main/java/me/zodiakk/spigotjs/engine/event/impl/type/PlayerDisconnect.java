package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerDisconnectEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerDisconnect extends SpigotEventListener {
    public PlayerDisconnect(Script script) {
        super(EventType.PLAYER_DISCONNECT, script);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerDisconnectEvent(event));
    }
}
