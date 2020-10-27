package me.zodiakk.spigotjs.engine.object;

public interface Event extends ApiElement {
    public String getName();
    public boolean isAsynchronous();
    public boolean isCancellable();
    public boolean isCancelled();
    public void setCancelled(boolean cancelled);
}
