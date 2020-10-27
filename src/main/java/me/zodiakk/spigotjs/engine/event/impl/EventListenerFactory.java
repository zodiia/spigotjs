package me.zodiakk.spigotjs.engine.event.impl;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.ScriptEventListener;

public class EventListenerFactory {
    private static final EventListenerFactory INSTANCE = new EventListenerFactory();

    public ScriptEventListener create(EventType type) {
        switch (type) {
            case ENABLE: return createScriptEnable();
            case DISABLE: return createScriptDisable();
            default: return null;
        }
    }

    private ScriptEventListener createScriptEnable() {
        return new JsEventListener(EventType.ENABLE) {};
    }

    private ScriptEventListener createScriptDisable() {
        return new JsEventListener(EventType.DISABLE) {};
    }

    public static EventListenerFactory getInstance() {
        return INSTANCE;
    }
}
