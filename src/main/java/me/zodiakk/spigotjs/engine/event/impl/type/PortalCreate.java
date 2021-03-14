package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.PortalCreateEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPortalCreateEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PortalCreate extends SpigotEventListener {
    public PortalCreate(Script script) {
        super(EventType.PORTAL_CREATE, script);
    }

    @EventHandler
    public void onPortalCreate(PortalCreateEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPortalCreateEvent(event));
    }
}
