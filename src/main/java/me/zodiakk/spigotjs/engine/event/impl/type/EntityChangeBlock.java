package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotEntityChangeBlockEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class EntityChangeBlock extends SpigotEventListener {
    public EntityChangeBlock(Script script) {
        super(EventType.ENTITY_CHANGE_BLOCK, script);
    }

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotEntityChangeBlockEvent(event));
    }
}
