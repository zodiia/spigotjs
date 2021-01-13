package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityChangeBlockEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsEntityChangeBlockEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

public class SpigotEntityChangeBlockEvent extends SpigotEntityEvent implements JsEntityChangeBlockEvent {
    private EntityChangeBlockEvent event;

    public SpigotEntityChangeBlockEvent(EntityChangeBlockEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock getBlock() {
        return new SpigotBlock(event.getBlock());
    }
}
