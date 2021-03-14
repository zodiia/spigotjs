package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockPistonEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockPiston extends SpigotEventListener {
    public BlockPiston(Script script) {
        super(EventType.BLOCK_PISTON, script);
    }

    @EventHandler
    public void onPistonExtend(BlockPistonExtendEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockPistonEvent(event));
    }

    @EventHandler
    public void onPistonRetract(BlockPistonRetractEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockPistonEvent(event));
    }
}
