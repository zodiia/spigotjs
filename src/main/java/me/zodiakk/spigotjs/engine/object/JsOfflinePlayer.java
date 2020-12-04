package me.zodiakk.spigotjs.engine.object;

public interface JsOfflinePlayer extends ApiElement {
    public JsLocation getBedSpawnLocation();
    public Number getFirstPlayed();
    public Number getLastPlayed();
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
