package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerDropItemEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerDropItem extends SpigotEventListener {
    public PlayerDropItem(Script script) {
        super(EventType.PLAYER_DROP_ITEM, script);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerDropItemEvent(event));
    }
}
