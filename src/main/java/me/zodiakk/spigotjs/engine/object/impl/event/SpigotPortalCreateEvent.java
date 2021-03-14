package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.block.BlockState;
import org.bukkit.event.world.PortalCreateEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsPortalCreateEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;

public class SpigotPortalCreateEvent extends SpigotWorldEvent implements JsPortalCreateEvent {
    private PortalCreateEvent event;

    public SpigotPortalCreateEvent(PortalCreateEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock[] getBlocks() {
        JsBlock[] blocks = new JsBlock[event.getBlocks().size()];
        int i = 0;

        for (BlockState block : event.getBlocks()) {
            blocks[i++] = new SpigotBlock(block.getBlock());
        }
        return blocks;
    }

    @Override
    public JsEntity getEntity() {
        return new SpigotEntity(event.getEntity());
    }

    @Override
    public String getReason() {
        return event.getReason().toString().toLowerCase();
    }
}
