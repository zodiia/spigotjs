package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerInteractEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerInteractEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;

public class SpigotPlayerInteractEvent extends SpigotPlayerEvent implements JsPlayerInteractEvent {
    private PlayerInteractEvent event;

    public SpigotPlayerInteractEvent(PlayerInteractEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getAction() {
        return event.getAction().toString().toLowerCase();
    }

    @Override
    public String getBlockFace() {
        return event.getBlockFace().toString().toLowerCase();
    }

    @Override
    public JsBlock getBlock() {
        return new SpigotBlock(event.getClickedBlock());
    }

    @Override
    public String getHand() {
        return event.getHand().toString().toLowerCase();
    }

    @Override
    public JsItemStack getItem() {
        return new SpigotItemStack(event.getItem());
    }

    @Override
    public boolean hasBlock() {
        return event.hasBlock();
    }

    @Override
    public boolean hasItem() {
        return event.hasItem();
    }

    @Override
    public boolean isBlockInHand() {
        return event.isBlockInHand();
    }
}
