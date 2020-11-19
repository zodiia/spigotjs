package me.zodiakk.spigotjs.engine.object.impl;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotEntity implements JsEntity {

    @Override
    public <T> T java(Class<T> clazz) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean ejectPassenger() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getCustomName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getEntityId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getFallDistance() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getFireTicks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsLocation getLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getMaxFireTicks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsEntity[] getNearbyEntities(Number distance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsEntity[] getNearbyEntities(Number x, Number y, Number z) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsEntity[] getPassengers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getTicksLived() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUniqueId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsEntity getVehicle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number[] getVelocity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsWorld getWorld() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCustomNameVisible() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isInsideVehicle() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOnGround() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean leaveVehicle() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCustomName(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCustomNameVisible(Boolean flag) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFallDistance(Number distance) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFireTicks(Number fireTicks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPassenger(JsEntity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPassengers(JsEntity[] entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTicksLived(Number ticks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setVelocity(Number[] velocity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setVelocity(Number x, Number y, Number z) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean teleport(JsEntity entity) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean teleport(JsLocation location) {
        // TODO Auto-generated method stub
        return false;
    }

}
