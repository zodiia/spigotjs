package me.zodiakk.spigotjs.engine.object.impl;

import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public class SpigotLivingEntity extends SpigotEntity implements JsLivingEntity {

    @Override
    public boolean addPotionEffect(String type, Number duration) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier, boolean ambient) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier, boolean ambient, boolean particles) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addPotionEffect(String type, Number duration, Number amplifier, boolean ambient, boolean particles,
            boolean force) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String[] getActivePotionEffects() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getCanPickupItems() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Number getEyeHeight() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getEyeHeight(Boolean ignorePose) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsLocation getEyeLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsPlayer getKiller() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getLastDamage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsEntity getLeashHolder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getMaximumAir() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getMaximumNoDamageTicks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getNoDamageTicks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getPotionEffectAmbient(String type) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Number getPotionEffectAmplifier(String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getPotionEffectDuration(String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getPotionEffectParticles(String type) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Number getRemainingAir() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasPotionEffect(String type) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeashed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removePotionEffect(String type) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCanPickupItems(Boolean pickup) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLastDamage(Number damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLeashHolder(JsEntity holder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMaximumAir(Number ticks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMaximumNoDamageTicks(Number ticks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNoDamageTicks(Number ticks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRemainingAir(Number ticks) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRemoveWhenFarAway(Boolean remove) {
        // TODO Auto-generated method stub

    }

    @Override
    public void damage(Number amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void damage(Number amount, JsEntity source) {
        // TODO Auto-generated method stub

    }

    @Override
    public Number getHealth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getMaxHealth() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void resetMaxHealth() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHealth(Number amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setMaxHealth(Number amount) {
        // TODO Auto-generated method stub

    }

}
