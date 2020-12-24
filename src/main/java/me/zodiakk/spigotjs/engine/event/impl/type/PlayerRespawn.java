package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerRespawnEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerRespawn extends SpigotEventListener {
    public PlayerRespawn(Script script) {
        super(EventType.PLAYER_RESPAWN, script);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerRespawnEvent(event));
    }
}
