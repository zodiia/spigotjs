package me.zodiakk.spigotjs.engine.object.event;

public interface JsPlayerKickEvent extends JsPlayerEvent {
    public String getReason();
    public void setReason(String reason);
}
