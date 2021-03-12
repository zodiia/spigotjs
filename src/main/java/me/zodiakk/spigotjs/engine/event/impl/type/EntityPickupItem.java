package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityPickupItemEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityPickupItem extends SpigotEventListener {
    public EntityPickupItem(Script script) {
        super(EventType.ENTITY_PICKUP_ITEM, script);
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityPickupItemEvent(event));
    }
}
