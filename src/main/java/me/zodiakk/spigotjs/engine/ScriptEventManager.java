package me.zodiakk.spigotjs.engine;

import java.util.HashSet;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.ScriptEventListener;
import me.zodiakk.spigotjs.engine.event.impl.EventListenerFactory;

class ScriptEventManager {
    private HashSet<ScriptEventListener> registeredListeners;

    public ScriptEventManager() {
        registeredListeners = new HashSet<ScriptEventListener>();
    }

    public boolean register(EventType type, Value callback) {
        ScriptEventListener listener = EventListenerFactory.getInstance().create(type);

        if (listener == null) {
            return false;
        }
        listener.register(callback);
        registeredListeners.add(listener);
        return true;
    }

    public void unregisterAll(EventType type) {
        for (ScriptEventListener listener : registeredListeners) {
            if (!listener.getType().equals(type)) {
                continue;
            }
            listener.unregister();
            registeredListeners.remove(listener);
        }
    }

    public void onEvent(EventType type, Object... arguments) {
        registeredListeners.forEach(listener -> {
            if (!listener.getType().equals(type)) {
                return;
            }
            listener.onEvent(arguments);
        });
    }
}
