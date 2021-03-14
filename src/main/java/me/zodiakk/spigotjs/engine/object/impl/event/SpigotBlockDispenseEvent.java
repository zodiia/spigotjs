package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.event.JsBlockDispenseEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;

public class SpigotBlockDispenseEvent extends SpigotBlockEvent implements JsBlockDispenseEvent {
    private BlockDispenseEvent event;

    public SpigotBlockDispenseEvent(BlockDispenseEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsItemStack getItem() {
        return new SpigotItemStack(event.getItem());
    }

    @Override
    public void setItem(JsItemStack item) {
        event.setItem(item.java(ItemStack.class));
    }
}
