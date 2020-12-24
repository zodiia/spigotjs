package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPortalEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerPortalEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerPortal extends SpigotEventListener {
    public PlayerPortal(Script script) {
        super(EventType.PLAYER_PORTAL, script);
    }

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerPortalEvent(event));
    }
}
