package me.zodiakk.spigotjs.engine.object;

public interface Entity extends ApiElement {
    public boolean ejectPassenger();
    public String getCustomName();
    public Number getEntityId();
    public Number getFallDistance();
    public Number getFireTicks();
    public Location getLocation();
    public Number getMaxFireTicks();
    public String getName();
    public Entity[] getNearbyEntities(Number distance);
    public Entity[] getNearbyEntities(Number x, Number y, Number z);
    public Entity[] getPassengers();
    public Number getTicksLived();
    public String getType();
    public String getUniqueId();
    public Entity getVehicle();
    public Number[] getVelocity();
    public World getWorld();
    public boolean isCustomNameVisible();
    public boolean isDead();
    public boolean isEmpty();
    public boolean isInsideVehicle();
    public boolean isOnGround();
    public boolean leaveVehicle();
    public void remove();
    public void setCustomName(String name);
    public void setCustomNameVisible(boolean flag);
    public void setFallDistance(Number distance);
    public void setFireTicks(Number fireTicks);
    public void setPassenger(Entity entity);
    public void setPassengers(Entity[] entities);
    public void setTicksLived(Number ticks);
    public void setVelocity(Number[] velocity);
    public void setVelocity(Number x, Number y, Number z);
    public boolean teleport(Entity entity);
    public boolean teleport(Location location);
}
