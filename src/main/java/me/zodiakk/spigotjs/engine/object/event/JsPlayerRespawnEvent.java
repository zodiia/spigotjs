package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsLocation;

public interface JsPlayerRespawnEvent extends JsPlayerEvent {
    public JsLocation getSpawnLocation();
    public boolean isBedSpawn();
    public boolean isAnchorSpawn();
    public void setSpawnLocation(JsLocation location);
}
