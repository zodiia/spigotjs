package me.zodiakk.spigotjs.engine.event;

import org.graalvm.polyglot.Value;

public interface JsEventListener {
    public void register(Value callback);
    public void unregister();
    public EventType getType();
    public void onEvent(Object arg);
}
