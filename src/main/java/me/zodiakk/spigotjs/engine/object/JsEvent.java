package me.zodiakk.spigotjs.engine.object;

public interface JsEvent extends ApiElement {
    public String getName();
    public boolean isAsynchronous();
    public boolean isCancellable();
    public boolean isCancelled();
    public void setCancelled(Boolean cancelled);
}
