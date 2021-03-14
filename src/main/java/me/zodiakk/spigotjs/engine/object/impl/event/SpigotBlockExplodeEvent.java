package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockExplodeEvent;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.event.JsBlockExplodeEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotBlock;

public class SpigotBlockExplodeEvent extends SpigotBlockEvent implements JsBlockExplodeEvent {
    private BlockExplodeEvent event;

    public SpigotBlockExplodeEvent(BlockExplodeEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public JsBlock[] getBlocks() {
        JsBlock[] blocks = new JsBlock[event.blockList().size()];
        int i = 0;

        for (Block block : event.blockList()) {
            blocks[i++] = new SpigotBlock(block);
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
