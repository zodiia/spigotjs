package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.weather.LightningStrikeEvent;

import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.event.JsLightningStrikeEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLocation;

public class SpigotLightningStrikeEvent extends SpigotWorldEvent implements JsLightningStrikeEvent {
    private LightningStrikeEvent event;

    public SpigotLightningStrikeEvent(LightningStrikeEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getCause() {
        return event.getCause().toString().toLowerCase();
    }

    @Override
    public JsLocation getLocation() {
        return new SpigotLocation(event.getLightning().getLocation());
    }

}
