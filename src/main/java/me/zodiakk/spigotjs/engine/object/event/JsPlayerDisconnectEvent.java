package me.zodiakk.spigotjs.engine.object.event;

public interface JsPlayerDisconnectEvent extends JsPlayerEvent {
    public String getMessage();
    public void setMessage(String message);
}
