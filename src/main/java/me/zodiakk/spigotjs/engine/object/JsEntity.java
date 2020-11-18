package me.zodiakk.spigotjs.engine.object;

public interface JsEntity extends ApiElement {
    public boolean ejectPassenger();
    public String getCustomName();
    public Number getEntityId();
    public Number getFallDistance();
    public Number getFireTicks();
    public JsLocation getLocation();
    public Number getMaxFireTicks();
    public String getName();
    public JsEntity[] getNearbyEntities(Number distance);
    public JsEntity[] getNearbyEntities(Number x, Number y, Number z);
    public JsEntity[] getPassengers();
    public Number getTicksLived();
    public String getType();
    public String getUniqueId();
    public JsEntity getVehicle();
    public Number[] getVelocity();
    public JsWorld getWorld();
    public boolean isCustomNameVisible();
    public boolean isDead();
    public boolean isEmpty();
    public boolean isInsideVehicle();
    public boolean isOnGround();
    public boolean leaveVehicle();
    public void remove();
    public void setCustomName(String name);
    public void setCustomNameVisible(Boolean flag);
    public void setFallDistance(Number distance);
    public void setFireTicks(Number fireTicks);
    public void setPassenger(JsEntity entity);
    public void setPassengers(JsEntity[] entities);
    public void setTicksLived(Number ticks);
    public void setVelocity(Number[] velocity);
    public void setVelocity(Number x, Number y, Number z);
    public boolean teleport(JsEntity entity);
    public boolean teleport(JsLocation location);
}
