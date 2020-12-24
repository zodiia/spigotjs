package me.zodiakk.spigotjs.engine.object.impl.event;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.event.JsPlayerChatEvent;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;

public class SpigotPlayerChatEvent extends SpigotPlayerEvent implements JsPlayerChatEvent {
    private AsyncPlayerChatEvent event;

    public SpigotPlayerChatEvent(AsyncPlayerChatEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getFormat() {
        return event.getFormat();
    }

    @Override
    public String getMessage() {
        return event.getMessage();
    }

    @Override
    public JsPlayer[] getRecipients() {
        JsPlayer[] players = new JsPlayer[event.getRecipients().size()];
        int i = 0;

        for (Player player : event.getRecipients()) {
            players[i++] = new SpigotPlayer(player);
        }
        return players;
    }

    @Override
    public void setFormat(String format) {
        event.setFormat(format);
    }

    @Override
    public void setMessage(String message) {
        event.setMessage(message);
    }

    @Override
    public void setRecipients(JsPlayer[] recipients) {
        event.getRecipients().clear();

        for (JsPlayer player : recipients) {
            event.getRecipients().add(player.java(Player.class));
        }
    }
}
