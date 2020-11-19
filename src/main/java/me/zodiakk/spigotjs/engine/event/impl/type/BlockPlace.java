package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockPlaceEvent;

public class BlockPlace extends SpigotEventListener {
    public BlockPlace() {
        super(EventType.BLOCK_PLACE);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        onEvent(new SpigotBlockPlaceEvent(event));
    }
}
