package me.zodiakk.spigotjs.engine.object;

public interface Location extends ApiElement {
    public Number getBlockX();
    public Number getBlockY();
    public Number getBlockZ();
    public Number getX();
    public Number getY();
    public Number getZ();
    public Number getPitch();
    public Number getYaw();
    public World getWorld();
    public Block getBlock();
    public void setX(Number x);
    public void setY(Number y);
    public void setZ(Number z);
    public void setPitch(Number pitch);
    public void setYaw(Number yaw);
    public void setWorld(World world);
    public void add(Number x, Number y, Number z);
    public void subtract(Number x, Number y, Number z);
}
