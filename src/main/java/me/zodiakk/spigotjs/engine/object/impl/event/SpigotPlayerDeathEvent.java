package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.entity.PlayerDeathEvent;

import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerDeathEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;

public class SpigotPlayerDeathEvent extends SpigotEntityDeathEvent implements JsPlayerDeathEvent {
    private PlayerDeathEvent event;

    public SpigotPlayerDeathEvent(PlayerDeathEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getDeathMessage() {
        return event.getDeathMessage();
    }

    @Override
    public JsPlayer getEntity() {
        return new SpigotPlayer(event.getEntity());
    }

    @Override
    public JsPlayer getPlayer() {
        return new SpigotPlayer(event.getEntity());
    }

    @Override
    public Boolean getKeepInventory() {
        return event.getKeepInventory();
    }

    @Override
    public Boolean getKeepExperience() {
        return event.getKeepLevel();
    }

    @Override
    public Number getNewExperience() {
        return event.getNewTotalExp();
    }

    @Override
    public Number getNewLevel() {
        return event.getNewLevel();
    }

    @Override
    public void setKeepInventory(Boolean keepInventory) {
        event.setKeepInventory(keepInventory);
    }

    @Override
    public void setKeepExperience(Boolean keepExperience) {
        event.setKeepLevel(keepExperience);
    }

    @Override
    public void setNewExperience(Number exp) {
        event.setNewTotalExp(exp.intValue());
    }

    @Override
    public void setNewLevel(Number level) {
        event.setNewLevel(level.intValue());
    }

}
