package me.zodiakk.spigotjs.engine.object;

public interface JsEvent extends ApiElement {
    public String   getEventName();
    public boolean  isAsynchronous();
    public boolean  isCancellable();
    public boolean  isCancelled();
    public boolean  setCancelled(Boolean cancelled);
}
