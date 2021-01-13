package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.event.JsEntityDeathEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotItemStack;
import me.zodiakk.spigotjs.engine.object.impl.SpigotLivingEntity;

public class SpigotEntityDeathEvent extends SpigotEntityEvent implements JsEntityDeathEvent {
    private EntityDeathEvent event;

    public SpigotEntityDeathEvent(EntityDeathEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public Number getDroppedExp() {
        return event.getDroppedExp();
    }

    @Override
    public JsItemStack[] getDroppedItems() {
        JsItemStack[] stacks = new JsItemStack[event.getDrops().size()];

        for (int i = 0; i < event.getDrops().size(); i++) {
            stacks[i] = new SpigotItemStack(event.getDrops().get(i));
        }
        return stacks;
    }

    @Override
    public void setDroppedExp(Number exp) {
        event.setDroppedExp(exp.intValue());
    }

    @Override
    public void setDroppedItems(JsItemStack[] items) {
        event.getDrops().clear();

        for (JsItemStack stack : items) {
            event.getDrops().add(stack.java(ItemStack.class));
        }
    }

    @Override
    public JsLivingEntity getEntity() {
        return new SpigotLivingEntity(event.getEntity());
    }
}
