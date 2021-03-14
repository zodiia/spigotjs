package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldLoadEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotWorldLoadEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class WorldLoad extends SpigotEventListener {
    public WorldLoad(Script script) {
        super(EventType.WORLD_LOAD, script);
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotWorldLoadEvent(event));
    }
}
