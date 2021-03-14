package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.weather.WeatherEvent;
import org.bukkit.event.world.WorldEvent;

import me.zodiakk.spigotjs.engine.object.JsWorld;
import me.zodiakk.spigotjs.engine.object.event.JsWorldEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotWorld;

public class SpigotWorldEvent extends SpigotEvent implements JsWorldEvent {
    private WorldEvent worldEvent;
    private WeatherEvent weatherEvent;

    public SpigotWorldEvent(WorldEvent event) {
        super(event);
        this.worldEvent = event;
    }

    public SpigotWorldEvent(WeatherEvent event) {
        super(event);
        this.weatherEvent = event;
    }

    @Override
    public JsWorld getWorld() {
        if (worldEvent != null) {
            return new SpigotWorld(worldEvent.getWorld());
        }
        return new SpigotWorld(weatherEvent.getWorld());
    }
}
