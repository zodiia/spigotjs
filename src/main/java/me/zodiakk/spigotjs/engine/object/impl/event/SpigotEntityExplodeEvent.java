package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.EntityExplodeEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsEntityExplodeEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

public class SpigotEntityExplodeEvent extends SpigotEntityEvent implements JsEntityExplodeEvent {
    private EntityExplodeEvent event;

    public SpigotEntityExplodeEvent(EntityExplodeEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock[] getBlocks() {
        JsBlock[] blocks = new JsBlock[event.blockList().size()];

        for (int i = 0; i < event.blockList().size(); i++) {
            blocks[i] = new SpigotBlock(event.blockList().get(i));
        }
        return blocks;
    }

    @Override
    public Number getYield() {
        return event.getYield();
    }

    @Override
    public void setYield(Number yield) {
        event.setYield(yield.floatValue());
    }
}
