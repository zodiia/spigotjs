package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockPlaceEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsBlockPlaceEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;

public class SpigotBlockPlaceEvent extends SpigotBlockEvent implements JsBlockPlaceEvent {
    private BlockPlaceEvent event;

    public SpigotBlockPlaceEvent(BlockPlaceEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public boolean getCanBuild() {
        return event.canBuild();
    }

    @Override
    public JsBlock getBlockAgainst() {
        return new SpigotBlock(event.getBlockAgainst());
    }

    @Override
    public JsItemStack getItemInHand() {
        return new SpigotItemStack(event.getItemInHand());
    }

    @Override
    public JsPlayer getPlayer() {
        return new SpigotPlayer(event.getPlayer());
    }

    @Override
    public void setCanBuild(Boolean canBuild) {
        event.setBuild(canBuild);
    }
}
