package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockBreakEvent;

public class BlockBreak extends SpigotEventListener {
    public BlockBreak() {
        super(EventType.BLOCK_BREAK);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        onEvent(new SpigotBlockBreakEvent(event));
    }
}
