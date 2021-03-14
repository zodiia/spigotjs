package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.world.WorldUnloadEvent;

import me.zodiakk.spigotjs.engine.object.event.JsWorldUnloadEvent;

public class SpigotWorldUnloadEvent extends SpigotWorldEvent implements JsWorldUnloadEvent {
    public SpigotWorldUnloadEvent(WorldUnloadEvent event) {
        super(event);
    }
}
