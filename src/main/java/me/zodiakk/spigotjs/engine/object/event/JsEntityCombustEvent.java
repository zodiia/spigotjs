package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;

public interface JsEntityCombustEvent extends JsEntityEvent {
    public Number getDuration();
    public void setDuration(Number duration);
    public String getSourceType();
    public JsEntity getSourceEntity();
    public JsBlock getSourceBlock();
}
