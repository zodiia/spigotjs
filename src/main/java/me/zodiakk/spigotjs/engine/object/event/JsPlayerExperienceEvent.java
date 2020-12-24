package me.zodiakk.spigotjs.engine.object.event;

public interface JsPlayerExperienceEvent extends JsPlayerEvent {
    public Number getAmount();
    public void setAmount(Number amount);
}
