package me.zodiakk.spigotjs.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import me.zodiakk.spigotjs.engine.script.Script;

public class ScriptLoadEvent extends ScriptEvent implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean isCancelled;

    public ScriptLoadEvent(Script script) {
        super(script);
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
