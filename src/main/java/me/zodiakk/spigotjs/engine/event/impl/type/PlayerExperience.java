package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerExpChangeEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerExperienceEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerExperience extends SpigotEventListener {
    public PlayerExperience(Script script) {
        super(EventType.PLAYER_EXPERIENCE, script);
    }

    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerExperienceEvent(event));
    }
}
