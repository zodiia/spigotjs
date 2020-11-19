package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockExpEvent;

import me.zodiakk.spigotjs.engine.object.event.JsBlockExpEvent;

public class SpigotBlockExpEvent extends SpigotBlockEvent implements JsBlockExpEvent {
    private BlockExpEvent event;

    public SpigotBlockExpEvent(BlockExpEvent event) {
        super(event);
    }

    @Override
    public int getExpToDrop() {
        return event.getExpToDrop();
    }

    @Override
    public void setExpToDrop(Number exp) {
        event.setExpToDrop(exp.intValue());
    }
}
