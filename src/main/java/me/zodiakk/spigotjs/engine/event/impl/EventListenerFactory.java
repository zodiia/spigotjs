package me.zodiakk.spigotjs.engine.event.impl;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockBreak;
import me.zodiakk.spigotjs.engine.event.impl.type.BlockPlace;

public class EventListenerFactory {
    private static final EventListenerFactory INSTANCE = new EventListenerFactory();

    public JsEventListener create(EventType type) {
        switch (type) {
        case ENABLE: return new ScriptEventListener(EventType.ENABLE) {};
        case DISABLE: return new ScriptEventListener(EventType.DISABLE) {};
        case RELOAD: return new ScriptEventListener(EventType.RELOAD) {};
        case BLOCK_BREAK: return new BlockBreak();
        case BLOCK_PLACE: return new BlockPlace();
        default: return null;
        }
    }

    public static EventListenerFactory getInstance() {
        return INSTANCE;
    }
}
