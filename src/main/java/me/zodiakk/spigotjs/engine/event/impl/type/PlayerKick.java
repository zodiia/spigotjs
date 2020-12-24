package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerKickEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerKickEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerKick extends SpigotEventListener {
    public PlayerKick(Script script) {
        super(EventType.PLAYER_KICK, script);
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerKickEvent(event));
    }
}
