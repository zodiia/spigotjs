package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockPlaceEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockPlace extends SpigotEventListener {
    public BlockPlace(Script script) {
        super(EventType.BLOCK_PLACE, script);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockPlaceEvent(event));
    }
}
