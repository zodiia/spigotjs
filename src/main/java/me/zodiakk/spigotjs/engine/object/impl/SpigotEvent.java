package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

import me.zodiakk.spigotjs.engine.object.JsEvent;

public class SpigotEvent implements JsEvent {
    private Event event;

    public SpigotEvent(Event event) {
        this.event = event;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(event)) {
            return clazz.cast(event);
        }
        return null;
    }

    @Override
    public String getEventName() {
        return event.getEventName();
    }

    @Override
    public boolean isAsynchronous() {
        return event.isAsynchronous();
    }

    @Override
    public boolean isCancellable() {
        if (event instanceof Cancellable) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCancelled() {
        if (event instanceof Cancellable) {
            return ((Cancellable) event).isCancelled();
        }
        return false;
    }

    @Override
    public boolean setCancelled(Boolean cancelled) {
        if (event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(cancelled);
            return true;
        }
        return false;
    }
}
