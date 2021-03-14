package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherChangeEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotWeatherChangeEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class WeatherChange extends SpigotEventListener {
    public WeatherChange(Script script) {
        super(EventType.WEATHER_CHANGE, script);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotWeatherChangeEvent(event));
    }
}
