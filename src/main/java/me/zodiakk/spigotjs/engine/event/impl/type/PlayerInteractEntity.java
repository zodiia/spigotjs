package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerInteractEntityEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerInteractEntity extends SpigotEventListener {
    public PlayerInteractEntity(Script script) {
        super(EventType.PLAYER_INTERACT_ENTITY, script);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerInteractEntityEvent(event));
    }
}
