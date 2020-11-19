package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.Location;
import org.bukkit.World;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotLocation implements JsLocation {
    Location location;

    public SpigotLocation(Location location) {
        this.location = location;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(location)) {
            return clazz.cast(location);
        }
        return null;
    }

    @Override
    public Number getBlockX() {
        return location.getBlockX();
    }

    @Override
    public Number getBlockY() {
        return location.getBlockY();
    }

    @Override
    public Number getBlockZ() {
        return location.getBlockZ();
    }

    @Override
    public Number getX() {
        return location.getX();
    }

    @Override
    public Number getY() {
        return location.getY();
    }

    @Override
    public Number getZ() {
        return location.getZ();
    }

    @Override
    public Number getPitch() {
        return location.getPitch();
    }

    @Override
    public Number getYaw() {
        return location.getYaw();
    }

    @Override
    public JsWorld getWorld() {
        return new SpigotWorld(location.getWorld());
    }

    @Override
    public JsBlock getBlock() {
        return new SpigotBlock(location.getBlock());
    }

    @Override
    public void setX(Number x) {
        location.setX(x.doubleValue());
    }

    @Override
    public void setY(Number y) {
        location.setY(y.doubleValue());
    }

    @Override
    public void setZ(Number z) {
        location.setZ(z.doubleValue());
    }

    @Override
    public void setPitch(Number pitch) {
        location.setPitch(pitch.floatValue());
    }

    @Override
    public void setYaw(Number yaw) {
        location.setYaw(yaw.floatValue());
    }

    @Override
    public void setWorld(JsWorld world) {
        location.setWorld(world.java(World.class));
    }

    @Override
    public void add(Number x, Number y, Number z) {
        location.add(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override
    public void add(JsLocation op) {
        location.add(op.java(location.getClass()));
    }

    @Override
    public void subtract(Number x, Number y, Number z) {
        location.subtract(x.doubleValue(), y.doubleValue(), z.doubleValue());
    }

    @Override
    public void subtract(JsLocation op) {
        location.subtract(op.java(location.getClass()));
    }
}
