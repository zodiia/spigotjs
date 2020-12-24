package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerTeleportEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerTeleport extends SpigotEventListener {
    public PlayerTeleport(Script script) {
        super(EventType.PLAYER_TELEPORT, script);
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerTeleportEvent(event));
    }
}
