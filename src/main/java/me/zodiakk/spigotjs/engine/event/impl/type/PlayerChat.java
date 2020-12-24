package me.zodiakk.spigotjs.engine.event.impl.type;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.impl.SpigotEventListener;
import me.zodiakk.spigotjs.engine.object.impl.event.SpigotPlayerChatEvent;
import me.zodiakk.spigotjs.engine.script.Script;

public class PlayerChat extends SpigotEventListener {
    public PlayerChat(Script script) {
        super(EventType.PLAYER_CHAT, script);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        getScript().getEventManager().onEvent(getType(), new SpigotPlayerChatEvent(event));
    }
}
