package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerInteractEntityEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEntity;

public class SpigotPlayerInteractEntityEvent extends SpigotPlayerEvent implements JsPlayerInteractEntityEvent {
    private PlayerInteractEntityEvent event;

    public SpigotPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getHand() {
        return event.getHand().toString().toLowerCase();
    }

    @Override
    public JsEntity getClicked() {
        return new SpigotEntity(event.getRightClicked());
    }
}
