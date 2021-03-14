package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBurnEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockBurnEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockBurn extends SpigotEventListener {
    public BlockBurn(Script script) {
        super(EventType.BLOCK_BURN, script);
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockBurnEvent(event));
    }
}
