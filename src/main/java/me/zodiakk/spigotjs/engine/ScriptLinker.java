package me.zodiakk.spigotjs.engine;

import java.util.NoSuchElementException;

import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;

public class ScriptLinker {
    private Script script;

    public ScriptLinker(Script script) {
        this.script = script;
    }

    public void on(String id, Value callback) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        EventType type = EventType.fromName(id);

        if (type == null) {
            throw new NoSuchElementException();
        }
        if (callback == null || callback.isNull()) {
            script.getEventManager().unregisterAll(type);
            return;
        }
        if (!callback.canExecute()) {
            throw new IllegalArgumentException();
        }
        if (!script.getEventManager().register(type, callback)) {
            throw new IllegalStateException();
        }
    }
}
