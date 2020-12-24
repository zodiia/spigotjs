package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerInteractEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerInteract extends SpigotEventListener {
    public PlayerInteract(Script script) {
        super(EventType.PLAYER_INTERACT, script);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerInteractEvent(event));
    }
}
