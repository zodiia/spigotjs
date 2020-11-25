package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockBreakEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockBreak extends SpigotEventListener {
    public BlockBreak(Script script) {
        super(EventType.BLOCK_BREAK, script);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockBreakEvent(event));
    }
}
