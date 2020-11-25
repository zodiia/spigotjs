package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockBreakEvent;

import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsBlockBreakEvent;

public class SpigotBlockBreakEvent extends SpigotBlockExpEvent implements JsBlockBreakEvent {
    private BlockBreakEvent event;

    public SpigotBlockBreakEvent(BlockBreakEvent event) {
        super(event);
        this.event = event;
    }

    public JsPlayer getPlayer() {
        // TODO: SpigotPlayer implementation
        return null;
    }

    public boolean getDropItems() {
        return event.isDropItems();
    }

    public void setDropItems(Boolean dropItems) {
        event.setDropItems(dropItems);
    }
}
