package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.OfflinePlayer;

import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsOfflinePlayer;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public class SpigotOfflinePlayer implements JsOfflinePlayer {
    private OfflinePlayer player;

    public SpigotOfflinePlayer(OfflinePlayer player) {
        this.player = player;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(player)) {
            return clazz.cast(player);
        }
        return null;
    }

    @Override
    public JsLocation getBedSpawnLocation() {
        return new SpigotLocation(player.getBedSpawnLocation());
    }

    @Override
    public Number getFirstPlayed() {
        return player.getFirstPlayed();
    }

    @Override
    public Number getLastPlayed() {
        return player.getLastPlayed();
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public JsPlayer getPlayer() {
        return new SpigotPlayer(player.getPlayer());
    }

    @Override
    public String getUniqueId() {
        return player.getUniqueId().toString();
    }

    @Override
    public boolean hasPlayedBefore() {
        return player.hasPlayedBefore();
    }

    @Override
    public boolean isBanned() {
        return player.isBanned();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public boolean isOp() {
        return player.isOp();
    }

    @Override
    public boolean isWhitelisted() {
        return player.isWhitelisted();
    }

    @Override
    public void setOp(Boolean value) {
        player.setOp(value);
    }

    @Override
    public void setWhitelisted(Boolean value) {
        player.setWhitelisted(value);
    }
}
