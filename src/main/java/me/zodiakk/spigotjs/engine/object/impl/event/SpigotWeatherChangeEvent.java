package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.weather.WeatherChangeEvent;

import me.zodiakk.spigotjs.engine.object.event.JsWeatherChangeEvent;

public class SpigotWeatherChangeEvent extends SpigotWorldEvent implements JsWeatherChangeEvent {
    private WeatherChangeEvent event;

    public SpigotWeatherChangeEvent(WeatherChangeEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public boolean toWeatherState() {
        return event.toWeatherState();
    }
}
