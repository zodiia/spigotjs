package me.zodiakk.spigotjs.engine.object;

public interface JsLocation extends ApiElement {
    public Number getBlockX();
    public Number getBlockY();
    public Number getBlockZ();
    public Number getX();
    public Number getY();
    public Number getZ();
    public Number getPitch();
    public Number getYaw();
    public JsWorld getWorld();
    public JsBlock getBlock();
    public void setX(Number x);
    public void setY(Number y);
    public void setZ(Number z);
    public void setPitch(Number pitch);
    public void setYaw(Number yaw);
    public void setWorld(JsWorld world);
    public void add(Number x, Number y, Number z);
    public void subtract(Number x, Number y, Number z);
}
