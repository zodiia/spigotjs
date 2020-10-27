package me.zodiakk.spigotjs.engine.object;

import org.graalvm.polyglot.Value;

public interface OfflinePlayer extends ApiElement {
    public void ban(String reason, Value expiresDate);
    public void pardon();
    public Location getBedSpawnLocation();
    public long getFirstPlayed();
    public long getLastPlayed();
    public String getName();
    public Player getPlayer();
    public String getUniqueId();
    public boolean hasPlayedBefore();
    public boolean isBanned();
    public boolean isOnline();
    public boolean isOp();
    public boolean isWhitelisted();
    public void setOp(boolean value);
    public void setWhitelisted(boolean value);
}
