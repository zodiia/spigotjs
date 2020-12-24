package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerMoveEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerMove extends SpigotEventListener {
    public PlayerMove(Script script) {
        super(EventType.PLAYER_MOVE, script);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerMoveEvent(event));
    }
}
