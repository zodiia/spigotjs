package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.inventory.ItemStack;

import me.zodiakk.spigotjs.engine.object.JsItemStack;

public class SpigotItemStack implements JsItemStack {
    private ItemStack stack;

    public SpigotItemStack(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(stack)) {
            return clazz.cast(stack);
        }
        return null;
    }

    @Override
    public void addEnchantment(String enchantment, Number level) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addEnchantment(String enchantment, Number level, Boolean ignoreLevelRestriction) {
        // TODO Auto-generated method stub

    }

    @Override
    public JsItemStack clone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals(JsItemStack stack) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Number getAmount() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getDamage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getEnchantmentLevel(String enchantment) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getEnchantments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getMaxStackSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSimilar(JsItemStack stack) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setAmount(Number amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDamage(Number damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setType(String material) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isUnbreakable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setUnbreakable(Boolean unbreakable) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addItemFlag(String itemFlag) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addItemFlags(String[] itemFlags) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDisplayName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getItemFlags() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getLore() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasConflictingEnchantment(String enchantment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasDisplayName() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasEnchantment(String enchantment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasEnchantments() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasItemFlag(String itemFlag) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasLore() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeEnchantment(String enchantment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeEnchantments(String[] enchantments) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeItemFlag(String itemFlag) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeItemFlags(String[] itemFlags) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDisplayName(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLore(String[] lore) {
        // TODO Auto-generated method stub

    }

}
