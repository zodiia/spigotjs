package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityExplodeEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityExplode extends SpigotEventListener {
    public EntityExplode(Script script) {
        super(EventType.ENTITY_EXPLODE, script);
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityExplodeEvent(event));
    }
}
