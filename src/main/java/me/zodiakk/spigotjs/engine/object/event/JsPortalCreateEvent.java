package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;

public interface JsPortalCreateEvent extends JsWorldEvent {
    public JsBlock[] getBlocks();
    public JsEntity getEntity();
    public String getReason();
}
