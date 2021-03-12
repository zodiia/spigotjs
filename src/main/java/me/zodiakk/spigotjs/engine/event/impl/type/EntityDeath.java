package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityDeathEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityDeath extends SpigotEventListener {
    public EntityDeath(Script script) {
        super(EventType.ENTITY_DEATH, script);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityDeathEvent(event));
    }
}
