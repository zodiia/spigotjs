package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;

public interface JsEntityDamageEvent extends JsEntityEvent {
    public String getCause();
    public Number getDamage();
    public Number getFinalDamage();
    public void setDamage(Number damage);
    public String getSourceType();
    public JsEntity getSourceEntity();
    public JsBlock getSourceBlock();
}
