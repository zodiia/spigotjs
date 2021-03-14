package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockBurnEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsBlockBurnEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

public class SpigotBlockBurnEvent extends SpigotBlockEvent implements JsBlockBurnEvent {
    private BlockBurnEvent event;

    public SpigotBlockBurnEvent(BlockBurnEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock getIgnitingBlock() {
        return new SpigotBlock(event.getIgnitingBlock());
    }

}
