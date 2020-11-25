package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockPlaceEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsBlockPlaceEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

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
        // TODO: SpigotItemStack
        return null;
    }

    @Override
    public JsPlayer getPlayer() {
        // TODO: SpigotPlayer
        return null;
    }

    @Override
    public void setCanBuild(Boolean canBuild) {
        event.setBuild(canBuild);
    }
}
