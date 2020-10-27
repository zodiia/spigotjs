package me.zodiakk.spigotjs.engine.event.impl;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.ScriptEventListener;

public abstract class JsEventListener implements ScriptEventListener {
    private Value callback;
    private EventType type;

    protected JsEventListener(EventType type) {
        this.type = type;
    }

    @Override
    public void register(Value callback) {
        this.callback = callback;
    }

    @Override
    public void unregister() {
        // Nothing
    }

    @Override
    public void onEvent(Object... args) {
        callback.executeVoid(args);
    }

    @Override
    public EventType getType() {
        return type;
    }
}
