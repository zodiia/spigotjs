package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.event.player.PlayerEvent;

import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;

public class SpigotPlayerEvent extends SpigotEvent implements JsPlayerEvent {
    private PlayerEvent event;

    public SpigotPlayerEvent(PlayerEvent event) {
        super(event);

        this.event = event;
    }

    public JsPlayer getPlayer() {
        return new SpigotPlayer(event.getPlayer());
    }
}
