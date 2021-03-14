package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockDispenseEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockDispense extends SpigotEventListener {
    public BlockDispense(Script script) {
        super(EventType.BLOCK_DISPENSE, script);
    }

    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockDispenseEvent(event));
    }
}
