package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public class SpigotPlayer extends SpigotLivingEntity implements JsPlayer {
    private Player player;

    public SpigotPlayer(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(player)) {
            return clazz.cast(player);
        }
        return null;
    }

    @Override
    public JsLocation getBedSpawnLocation() {
        return new SpigotLocation(player.getBedSpawnLocation());
    }

    @Override
    public Number getFirstPlayed() {
        return player.getFirstPlayed();
    }

    @Override
    public Number getLastPlayed() {
        return player.getLastPlayed();
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public JsPlayer getPlayer() {
        return new SpigotPlayer(player.getPlayer());
    }

    @Override
    public String getUniqueId() {
        return player.getUniqueId().toString();
    }

    @Override
    public boolean hasPlayedBefore() {
        return player.hasPlayedBefore();
    }

    @Override
    public boolean isBanned() {
        return player.isBanned();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public boolean isOp() {
        return player.isOp();
    }

    @Override
    public boolean isWhitelisted() {
        return player.isWhitelisted();
    }

    @Override
    public void setOp(Boolean value) {
        player.setOp(value);
    }

    @Override
    public void setWhitelisted(Boolean value) {
        player.setWhitelisted(value);
    }

    @Override
    public void chat(String message) {
        player.chat(ChatColor.translateAlternateColorCodes('&', message));
    }

    @Override
    public boolean getAllowFlight() {
        return player.getAllowFlight();
    }

    @Override
    public JsLocation getCompassTarget() {
        return new SpigotLocation(player.getCompassTarget());
    }

    @Override
    public String getDisplayName() {
        return player.getDisplayName();
    }

    @Override
    public Number getExhaustion() {
        return player.getExhaustion();
    }

    @Override
    public Number getExp() {
        return player.getExp();
    }

    @Override
    public Number getFlySpeed() {
        return player.getFlySpeed();
    }

    @Override
    public Number getFoodLevel() {
        return player.getFoodLevel();
    }

    @Override
    public Number getHealthScale() {
        return player.getHealthScale();
    }

    @Override
    public Number getLevel() {
        return player.getLevel();
    }

    @Override
    public String getListName() {
        return player.getPlayerListName();
    }

    @Override
    public Number getPlayerTime() {
        return player.getPlayerTime();
    }

    @Override
    public Number getPlayerTimeOffset() {
        return player.getPlayerTimeOffset();
    }

    @Override
    public String getPlayerWeather() {
        return player.getPlayerWeather().toString().toLowerCase();
    }

    @Override
    public Number getSaturation() {
        return player.getSaturation();
    }

    @Override
    public Number getTotalExperience() {
        return player.getTotalExperience();
    }

    @Override
    public Number getWalkSpeed() {
        return player.getWalkSpeed();
    }

    @Override
    public void giveExp(Number amount) {
        player.giveExp(amount.intValue());
    }

    @Override
    public void giveExpLevels(Number levels) {
        player.giveExpLevels(levels.intValue());
    }

    @Override
    public boolean isFlying() {
        return player.isFlying();
    }

    @Override
    public boolean isHealthScaled() {
        return player.isHealthScaled();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return player.isPlayerTimeRelative();
    }

    @Override
    public boolean isSneaking() {
        return player.isSneaking();
    }

    @Override
    public boolean isSprinting() {
        return player.isSprinting();
    }

    @Override
    public void kick(String reason) {
        player.kickPlayer(reason);
    }

    @Override
    public void runCommand(String command) {
        player.performCommand(command);
    }

    @Override
    public void playSound(String sound, Number volume, Number pitch) {
        player.playSound(player.getLocation(), Sound.valueOf(sound.toUpperCase()), volume.floatValue(), pitch.floatValue());
    }

    @Override
    public void playSound(String sound, Number volume, Number pitch, JsLocation location) {
        player.playSound(location.java(Location.class), Sound.valueOf(sound.toUpperCase()), volume.floatValue(), pitch.floatValue());
    }

    @Override
    public void resetPlayerTime() {
        player.resetPlayerTime();
    }

    @Override
    public void sendMessage(String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    @Override
    public void sendMessage(String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages[i]));
        }
    }

    @Override
    public void setAllowFlight(Boolean allowFlight) {
        player.setAllowFlight(allowFlight);
    }

    @Override
    public void setBedSpawnLocation(JsLocation location) {
        player.setBedSpawnLocation(location.java(Location.class));
    }

    @Override
    public void setCompassTarget(JsLocation location) {
        player.setCompassTarget(location.java(Location.class));
    }

    @Override
    public void setDisplayName(String displayName) {
        player.setDisplayName(displayName);
    }

    @Override
    public void setExhaustion(Number value) {
        player.setExhaustion(value.floatValue());
    }

    @Override
    public void setExp(Number exp) {
        player.setExp(exp.floatValue());
    }

    @Override
    public void setFlying(Boolean flying) {
        player.setFlying(flying);
    }

    @Override
    public void setFlySpeed(Number flySpeed) {
        player.setFlySpeed(flySpeed.floatValue());
    }

    @Override
    public void setFoodLevel(Number foodLevel) {
        player.setFoodLevel(foodLevel.intValue());
    }

    @Override
    public void setHealthScale(Number healthScale) {
        player.setHealthScale(healthScale.doubleValue());
    }

    @Override
    public void setHealthScaled(Boolean healthScaled) {
        player.setHealthScaled(healthScaled);
    }

    @Override
    public void setLevel(Number level) {
        player.setLevel(level.intValue());
    }

    @Override
    public void setPlayerListName(String name) {
        player.setPlayerListName(name);
    }

    @Override
    public void setPlayerTime(Number time, Boolean relative) {
        player.setPlayerTime(time.longValue(), relative);
    }

    @Override
    public void setPlayerWeather(String weather) {
        player.setPlayerWeather(WeatherType.valueOf(weather.toUpperCase()));
    }

    @Override
    public void setSaturation(Number saturation) {
        player.setSaturation(saturation.floatValue());
    }

    @Override
    public void setSneaking(Boolean sneaking) {
        player.setSneaking(sneaking);
    }

    @Override
    public void setSprinting(Boolean sprinting) {
        player.setSprinting(sprinting);
    }

    @Override
    public void setTotalExperience(Number totalExperience) {
        player.setTotalExperience(totalExperience.intValue());
    }

    @Override
    public void setWalkSpeed(Number walkSpeed) {
        player.setWalkSpeed(walkSpeed.floatValue());
    }

    @Override
    public void closeInventory() {
        player.closeInventory();
    }

    @Override
    public JsItemStack[] getEnderChest() {
        JsItemStack[] stacks = new JsItemStack[player.getEnderChest().getContents().length];
        int i = 0;

        for (ItemStack stack : player.getEnderChest().getContents()) {
            stacks[i++] = new SpigotItemStack(stack);
        }
        return stacks;
    }

    @Override
    public String getGameMode() {
        return player.getGameMode().toString().toLowerCase();
    }

    @Override
    public JsItemStack[] getInventory() {
        JsItemStack[] stacks = new JsItemStack[player.getInventory().getContents().length];
        int i = 0;

        for (ItemStack stack : player.getInventory().getContents()) {
            stacks[i++] = new SpigotItemStack(stack);
        }
        return stacks;
    }

    @Override
    public JsItemStack getItemInMainHand() {
        return new SpigotItemStack(player.getInventory().getItemInMainHand());
    }

    @Override
    public JsItemStack getItemInOffHand() {
        return new SpigotItemStack(player.getInventory().getItemInOffHand());
    }

    @Override
    public JsItemStack getItemOnCursor() {
        return new SpigotItemStack(player.getItemOnCursor());
    }

    @Override
    public boolean isBlocking() {
        return player.isBlocking();
    }

    @Override
    public boolean isSleeping() {
        return player.isSleeping();
    }

    @Override
    public void setEnderChest(JsItemStack[] items) {
        ItemStack[] stacks = new ItemStack[items.length];
        int i = 0;

        for (JsItemStack stack : items) {
            stacks[i++] = stack.java(ItemStack.class);
        }
        player.getEnderChest().setContents(stacks);
    }

    @Override
    public void setGameMode(String gameMode) {
        player.setGameMode(GameMode.valueOf(gameMode.toUpperCase()));
    }

    @Override
    public void setInventory(JsItemStack[] items) {
        ItemStack[] stacks = new ItemStack[items.length];
        int i = 0;

        for (JsItemStack stack : items) {
            stacks[i++] = stack.java(ItemStack.class);
        }
        player.getInventory().setContents(stacks);
    }

    @Override
    public void setItemInMainHand(JsItemStack item) {
        player.getInventory().setItemInMainHand(item.java(ItemStack.class));
    }

    @Override
    public void setItemInOffHand(JsItemStack item) {
        player.getInventory().setItemInOffHand(item.java(ItemStack.class));
    }

    @Override
    public boolean hasPermission(String permission) {
        return player.hasPermission(permission);
    }
}
