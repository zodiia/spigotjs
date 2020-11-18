package me.zodiakk.spigotjs.engine.object;

import org.graalvm.polyglot.Value;

public interface JsOfflinePlayer extends ApiElement {
    public void ban(String reason, Value expiresDate);
    public void pardon();
    public JsLocation getBedSpawnLocation();
    public long getFirstPlayed();
    public long getLastPlayed();
    public String getName();
    public JsPlayer getPlayer();
    public String getUniqueId();
    public boolean hasPlayedBefore();
    public boolean isBanned();
    public boolean isOnline();
    public boolean isOp();
    public boolean isWhitelisted();
    public void setOp(Boolean value);
    public void setWhitelisted(Boolean value);
}
