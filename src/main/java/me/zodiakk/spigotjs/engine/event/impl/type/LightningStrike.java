package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.LightningStrikeEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotLightningStrikeEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class LightningStrike extends SpigotEventListener {
    public LightningStrike(Script script) {
        super(EventType.LIGHTNING_STRIKE, script);
    }

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotLightningStrikeEvent(event));
    }
}
