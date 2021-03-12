package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerDeathEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerDeath extends SpigotEventListener {
    public PlayerDeath(Script script) {
        super(EventType.PLAYER_DEATH, script);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerDeathEvent(event));
    }
}
