package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityDamageEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityDamage extends SpigotEventListener {
    public EntityDamage(Script script) {
        super(EventType.ENTITY_DAMAGE, script);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByBlockEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityDamageEvent(event));
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityDamageEvent(event));
    }
}
