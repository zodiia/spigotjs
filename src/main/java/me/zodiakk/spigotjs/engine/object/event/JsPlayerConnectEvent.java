package me.zodiakk.spigotjs.engine.object.event;

public interface JsPlayerConnectEvent extends JsPlayerEvent {
    public String getMessage();
    public void setMessage(String message);
}
