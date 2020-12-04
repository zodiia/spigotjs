package me.zodiakk.spigotjs.engine.object.impl;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotEntity implements JsEntity {
    private Entity entity;

    public SpigotEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(entity)) {
            return clazz.cast(entity);
        }
        return null;
    }

    @Override
    public boolean ejectPassenger() {
        return entity.eject();
    }

    @Override
    public String getCustomName() {
        return entity.getCustomName();
    }

    @Override
    public Number getEntityId() {
        return entity.getEntityId();
    }

    @Override
    public Number getFallDistance() {
        return entity.getFallDistance();
    }

    @Override
    public Number getFireTicks() {
        return entity.getFireTicks();
    }

    @Override
    public JsLocation getLocation() {
        return new SpigotLocation(entity.getLocation());
    }

    @Override
    public Number getMaxFireTicks() {
        return entity.getMaxFireTicks();
    }

    @Override
    public String getName() {
        return entity.getName();
    }

    @Override
    public JsEntity[] getNearbyEntities(Number distance) {
        return getNearbyEntities(distance, distance, distance);
    }

    @Override
    public JsEntity[] getNearbyEntities(Number x, Number y, Number z) {
        List<JsEntity> entities = new ArrayList<JsEntity>();

        entity.getNearbyEntities(x.doubleValue(), y.doubleValue(), z.doubleValue()).forEach(ent -> entities.add(new SpigotEntity(ent)));
        return entities.toArray(new JsEntity[0]);
    }

    @Override
    public JsEntity[] getPassengers() {
        List<JsEntity> entities = new ArrayList<JsEntity>();

        entity.getPassengers().forEach(ent -> entities.add(new SpigotEntity(ent)));
        return entities.toArray(new JsEntity[0]);
    }

    @Override
    public Number getTicksLived() {
        return entity.getTicksLived();
    }

    @Override
    public String getType() {
        return entity.getType().toString().toLowerCase();
    }

    @Override
    public String getUniqueId() {
        return entity.getUniqueId().toString();
    }

    @Override
    public JsEntity getVehicle() {
        return new SpigotEntity(entity.getVehicle());
    }

    @Override
    public Number[] getVelocity() {
        Number[] velocity = {
            entity.getVelocity().getX(),
            entity.getVelocity().getY(),
            entity.getVelocity().getZ()
        };

        return velocity;
    }

    @Override
    public JsWorld getWorld() {
        return new SpigotWorld(entity.getWorld());
    }

    @Override
    public boolean isCustomNameVisible() {
        return entity.isCustomNameVisible();
    }

    @Override
    public boolean isDead() {
        return entity.isDead();
    }

    @Override
    public boolean isEmpty() {
        return entity.isEmpty();
    }

    @Override
    public boolean isInsideVehicle() {
        return entity.isInsideVehicle();
    }

    @Override
    public boolean isOnGround() {
        return entity.isOnGround();
    }

    @Override
    public boolean leaveVehicle() {
        return entity.leaveVehicle();
    }

    @Override
    public void remove() {
        entity.remove();
    }

    @Override
    public void setCustomName(String name) {
        entity.setCustomName(name);
    }

    @Override
    public void setCustomNameVisible(Boolean flag) {
        entity.setCustomNameVisible(flag);
    }

    @Override
    public void setFallDistance(Number distance) {
        entity.setFallDistance(distance.floatValue());
    }

    @Override
    public void setFireTicks(Number fireTicks) {
        entity.setFireTicks(fireTicks.intValue());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPassenger(JsEntity ent) {
        entity.setPassenger(ent.java(Entity.class));
    }

    @Override
    public void setPassengers(JsEntity[] entities) {
        entity.getPassengers().forEach(ent -> entity.removePassenger(ent));
        for (JsEntity ent : entities) {
            entity.addPassenger(ent.java(Entity.class));
        }
    }

    @Override
    public void setTicksLived(Number ticks) {
        entity.setTicksLived(ticks.intValue());
    }

    @Override
    public void setVelocity(Number[] velocity) {
        entity.setVelocity(new Vector(velocity[0].doubleValue(), velocity[1].doubleValue(), velocity[2].doubleValue()));
    }

    @Override
    public void setVelocity(Number x, Number y, Number z) {
        entity.setVelocity(new Vector(x.doubleValue(), y.doubleValue(), z.doubleValue()));
    }

    @Override
    public boolean teleport(JsEntity ent) {
        return entity.teleport(ent.java(Entity.class));
    }

    @Override
    public boolean teleport(JsLocation location) {
        return entity.teleport(location.java(Location.class));
    }

}
