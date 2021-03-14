package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockDamageEvent;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsBlockDamageEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;

public class SpigotBlockDamageEvent extends SpigotBlockEvent implements JsBlockDamageEvent {
    private BlockDamageEvent event;

    public SpigotBlockDamageEvent(BlockDamageEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public boolean getInstantBreaking() {
        return event.getInstaBreak();
    }

    @Override
    public JsItemStack getItem() {
        return new SpigotItemStack(event.getItemInHand());
    }

    @Override
    public JsPlayer getPlayer() {
        return new SpigotPlayer(event.getPlayer());
    }

    @Override
    public void setInstaBreak(boolean instaBreak) {
        event.setInstaBreak(instaBreak);
    }
}
