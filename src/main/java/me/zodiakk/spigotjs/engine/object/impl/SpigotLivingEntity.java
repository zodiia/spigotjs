package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public class SpigotLivingEntity extends SpigotEntity implements JsLivingEntity {
    private LivingEntity entity;

    public SpigotLivingEntity(LivingEntity entity) {
        super(entity);
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
    public boolean addPotionEffect(String type, Number duration) {
        return entity.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type.toUpperCase()), duration.intValue(), 0));
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier) {
        return entity.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type.toUpperCase()), duration.intValue(), amplifier.intValue()));
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier, boolean ambient) {
        return entity.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type.toUpperCase()), duration.intValue(), amplifier.intValue(), ambient));
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier, boolean ambient, boolean particles) {
        return entity.addPotionEffect(new PotionEffect(PotionEffectType.getByName(type.toUpperCase()), duration.intValue(), amplifier.intValue(), ambient, particles));
    }

    @Override
    public String[] getActivePotionEffects() {
        String[] res = new String[entity.getActivePotionEffects().size()];
        int i = 0;

        for (PotionEffect effect : entity.getActivePotionEffects()) {
            res[i] = effect.getType().toString().toLowerCase();
            i++;
        }
        return res;
    }

    @Override
    public boolean getCanPickupItems() {
        return entity.getCanPickupItems();
    }

    @Override
    public Number getEyeHeight() {
        return entity.getEyeHeight();
    }

    @Override
    public Number getEyeHeight(Boolean ignorePose) {
        return entity.getEyeHeight(ignorePose);
    }

    @Override
    public JsLocation getEyeLocation() {
        return new SpigotLocation(entity.getEyeLocation());
    }

    @Override
    public JsPlayer getKiller() {
        return new SpigotPlayer(entity.getKiller());
    }

    @Override
    public Number getLastDamage() {
        return entity.getLastDamage();
    }

    @Override
    public JsEntity getLeashHolder() {
        return new SpigotEntity(entity.getLeashHolder());
    }

    @Override
    public Number getMaximumAir() {
        return entity.getMaximumAir();
    }

    @Override
    public Number getMaximumNoDamageTicks() {
        return entity.getMaximumNoDamageTicks();
    }

    @Override
    public Number getNoDamageTicks() {
        return entity.getNoDamageTicks();
    }

    @Override
    public boolean getPotionEffectAmbient(String type) {
        return entity.getPotionEffect(PotionEffectType.getByName(type.toUpperCase())).isAmbient();
    }

    @Override
    public Number getPotionEffectAmplifier(String type) {
        return entity.getPotionEffect(PotionEffectType.getByName(type.toUpperCase())).getAmplifier();
    }

    @Override
    public Number getPotionEffectDuration(String type) {
        return entity.getPotionEffect(PotionEffectType.getByName(type.toUpperCase())).getDuration();
    }

    @Override
    public boolean getPotionEffectParticles(String type) {
        return entity.getPotionEffect(PotionEffectType.getByName(type.toUpperCase())).hasParticles();
    }

    @Override
    public Number getRemainingAir() {
        return entity.getRemainingAir();
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return entity.getRemoveWhenFarAway();
    }

    @Override
    public boolean hasPotionEffect(String type) {
        return entity.hasPotionEffect(PotionEffectType.getByName(type.toUpperCase()));
    }

    @Override
    public boolean isLeashed() {
        return entity.isLeashed();
    }

    @Override
    public void removePotionEffect(String type) {
        entity.removePotionEffect(PotionEffectType.getByName(type));
    }

    @Override
    public void setCanPickupItems(Boolean pickup) {
        entity.setCanPickupItems(pickup);
    }

    @Override
    public void setLastDamage(Number damage) {
        entity.setLastDamage(damage.doubleValue());
    }

    @Override
    public void setLeashHolder(JsEntity holder) {
        entity.setLeashHolder(holder.java(Entity.class));
    }

    @Override
    public void setMaximumAir(Number ticks) {
        entity.setMaximumAir(ticks.intValue());
    }

    @Override
    public void setMaximumNoDamageTicks(Number ticks) {
        entity.setMaximumNoDamageTicks(ticks.intValue());
    }

    @Override
    public void setNoDamageTicks(Number ticks) {
        entity.setNoDamageTicks(ticks.intValue());
    }

    @Override
    public void setRemainingAir(Number ticks) {
        entity.setRemainingAir(ticks.intValue());
    }

    @Override
    public void setRemoveWhenFarAway(Boolean remove) {
        entity.setRemoveWhenFarAway(remove);
    }

    @Override
    public void damage(Number amount) {
        entity.damage(amount.doubleValue());
    }

    @Override
    public void damage(Number amount, JsEntity source) {
        entity.damage(amount.doubleValue(), source.java(Entity.class));
    }

    @Override
    public Number getHealth() {
        return entity.getHealth();
    }

    @SuppressWarnings("deprecation")
    @Override
    public Number getMaxHealth() {
        return entity.getMaxHealth(); // TODO: Find a better solution
    }

    @Override
    public void resetMaxHealth() {
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().forEach(modifier -> entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(modifier));
    }

    @Override
    public void setHealth(Number amount) {
        entity.setHealth(amount.doubleValue());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setMaxHealth(Number amount) {
        entity.setMaxHealth(amount.doubleValue()); // TODO: Find a better solution
    }
}
