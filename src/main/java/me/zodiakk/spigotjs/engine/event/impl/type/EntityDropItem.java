package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDropItemEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityDropItemEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityDropItem extends SpigotEventListener {
    public EntityDropItem(Script script) {
        super(EventType.ENTITY_DROP_ITEM, script);
    }

    @EventHandler
    public void onEntityDropItem(EntityDropItemEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityDropItemEvent(event));
    }
}
