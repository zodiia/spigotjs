package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityInteractEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsEntityInteractEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

public class SpigotEntityInteractEvent extends SpigotEntityEvent implements JsEntityInteractEvent {
    private EntityInteractEvent event;

    public SpigotEntityInteractEvent(EntityInteractEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock getBlock() {
        return new SpigotBlock(event.getBlock());
    }

}
