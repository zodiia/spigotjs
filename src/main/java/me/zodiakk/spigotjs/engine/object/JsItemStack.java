package me.zodiakk.spigotjs.engine.object;

public interface JsItemStack extends ApiElement {
    public void addEnchantment(String enchantment, Number level);
    public void addEnchantment(String enchantment, Number level, Boolean ignoreLevelRestriction);
    public JsItemStack clone();
    public boolean equals(JsItemStack stack);
    public Number getAmount();
    public Number getDamage();
    public Number getEnchantmentLevel(String enchantment);
    public String[] getEnchantments();
    public Number getMaxStackSize();
    public String getType();
    public boolean isSimilar(JsItemStack stack);
    public void setAmount(Number amount);
    public void setDamage(Number damage);
    public void setType(String material);
    public String toString();
    public boolean isUnbreakable();
    public void setUnbreakable(Boolean unbreakable);
    public void addItemFlag(String itemFlag);
    public void addItemFlags(String[] itemFlags);
    public String getDisplayName();
    public String[] getItemFlags();
    public String[] getLore();
    public boolean hasConflictingEnchantment(String enchantment);
    public boolean hasDisplayName();
    public boolean hasEnchantment(String enchantment);
    public boolean hasEnchantments();
    public boolean hasItemFlag(String itemFlag);
    public boolean hasLore();
    public boolean removeEnchantment(String enchantment);
    public boolean removeEnchantments(String[] enchantments);
    public void removeItemFlag(String itemFlag);
    public void removeItemFlags(String[] itemFlags);
    public void setDisplayName(String name);
    public void setLore(String[] lore);
}
