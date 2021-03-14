package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDamageEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotBlockDamageEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class BlockDamage extends SpigotEventListener {
    public BlockDamage(Script script) {
        super(EventType.BLOCK_DAMAGE, script);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotBlockDamageEvent(event));
    }
}
