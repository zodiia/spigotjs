package me.zodiakk.spigotjs.engine.script;

import java.util.HashSet;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.event.impl.EventListenerFactory;

class ScriptEventManager {
    private HashSet<JsEventListener> registeredListeners = new HashSet<JsEventListener>();
    private final Script script;

    public ScriptEventManager(Script script) {
        this.script = script;
    }

    public boolean register(EventType type, Value callback) {
        JsEventListener listener = EventListenerFactory.getInstance().create(type);

        if (listener == null) {
            return false;
        }
        listener.register(callback);
        registeredListeners.add(listener);
        return true;
    }

    public void unregisterAll(EventType type) {
        for (JsEventListener listener : registeredListeners) {
            if (!listener.getType().equals(type)) {
                continue;
            }
            listener.unregister();
            registeredListeners.remove(listener);
        }
    }

    public void onEvent(EventType type, Object... arguments) {
        if (script.isPaused()) {
            return;
        }
        registeredListeners.forEach(listener -> {
            if (!listener.getType().equals(type)) {
                return;
            }
            listener.onEvent(arguments);
        });
    }
}
