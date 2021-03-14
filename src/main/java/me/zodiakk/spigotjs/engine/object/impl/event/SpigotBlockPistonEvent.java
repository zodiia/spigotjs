package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import me.zodiakk.spigotjs.engine.object.event.JsBlockPistonEvent;

public class SpigotBlockPistonEvent extends SpigotBlockEvent implements JsBlockPistonEvent {
    private BlockPistonEvent event;
    private String action;

    public SpigotBlockPistonEvent(BlockPistonRetractEvent event) {
        super(event);
        this.event = event;
        this.action = "retract";
    }

    public SpigotBlockPistonEvent(BlockPistonExtendEvent event) {
        super(event);
        this.event = event;
        this.action = "extend";
    }

    @Override
    public String getDirection() {
        return event.getDirection().toString().toLowerCase();
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public boolean isSticky() {
        return event.isSticky();
    }
}
