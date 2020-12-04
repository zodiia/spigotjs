package me.zodiakk.spigotjs.engine.event.impl;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.script.Script;
import me.zodiakk.spigotjs.engine.script.ScriptException;

public abstract class ScriptEventListener implements JsEventListener {
    private Value callback;
    private EventType type;
    private Script script;

    protected ScriptEventListener(EventType type, Script script) {
        this.type = type;
        this.script = script;
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
    public void onEvent(Object arg) {
        try {
            callback.executeVoid(arg);
        } catch (Throwable th) {
            throw new ScriptException(script, th);
        }
    }

    @Override
    public EventType getType() {
        return type;
    }
}
