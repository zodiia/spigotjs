package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockExplodeEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockExplodeEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockExplode extends SpigotEventListener {
    public BlockExplode(Script script) {
        super(EventType.BLOCK_EXPLODE, script);
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockExplodeEvent(event));
    }
}
