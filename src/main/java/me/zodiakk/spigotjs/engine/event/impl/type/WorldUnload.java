package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldUnloadEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotWorldUnloadEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class WorldUnload extends SpigotEventListener {
    public WorldUnload(Script script) {
        super(EventType.WORLD_UNLOAD, script);
    }

    @EventHandler
    public void onWorldUnload(WorldUnloadEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotWorldUnloadEvent(event));
    }
}
