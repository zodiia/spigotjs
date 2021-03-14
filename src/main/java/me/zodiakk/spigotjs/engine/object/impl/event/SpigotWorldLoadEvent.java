package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.world.WorldLoadEvent;

import me.zodiakk.spigotjs.engine.object.event.JsWorldLoadEvent;

public class SpigotWorldLoadEvent extends SpigotWorldEvent implements JsWorldLoadEvent {
    public SpigotWorldLoadEvent(WorldLoadEvent event) {
        super(event);
    }
}
