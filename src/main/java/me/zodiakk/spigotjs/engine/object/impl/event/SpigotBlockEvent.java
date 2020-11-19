package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsBlockEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEvent;

public class SpigotBlockEvent extends SpigotEvent implements JsBlockEvent {
    private BlockEvent event;

    public SpigotBlockEvent(BlockEvent event) {
        super(event);
    }

    @Override
    public JsBlock getBlock() {
        return new SpigotBlock(event.getBlock());
    }
}
