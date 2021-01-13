package me.zodiakk.spigotjs.engine.object.event;

import me.zodiakk.spigotjs.engine.object.JsPlayer;

public interface JsPlayerDeathEvent extends JsEntityDeathEvent {
    public String getDeathMessage();
    public JsPlayer getEntity();
    public JsPlayer getPlayer();
    public Boolean getKeepInventory();
    public Boolean getKeepExperience();
    public Number getNewExperience();
    public Number getNewLevel();
    public void setKeepInventory(Boolean keepInventory);
    public void setKeepExperience(Boolean keepExperience);
    public void setNewExperience(Number exp);
    public void setNewLevel(Number level);
}
