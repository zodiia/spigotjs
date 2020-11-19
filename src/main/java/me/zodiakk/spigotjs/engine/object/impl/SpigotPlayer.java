package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.entity.Player;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsPlayer;

public class SpigotPlayer extends SpigotLivingEntity implements JsPlayer {
    private Player player;

    public SpigotPlayer(Player player) {
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
    public void ban(String reason, Value expiresDate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pardon() {
        // TODO Auto-generated method stub

    }

    @Override
    public JsLocation getBedSpawnLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getFirstPlayed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getLastPlayed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public JsPlayer getPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPlayedBefore() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isBanned() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOnline() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isOp() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWhitelisted() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setOp(Boolean value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWhitelisted(Boolean value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void awardAchievement(String achievement) {
        // TODO Auto-generated method stub

    }

    @Override
    public void chat(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getAllowFlight() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JsLocation getCompassTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDisplayName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getExhaustion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getExp() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getFlySpeed() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getFoodLevel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getHealthScale() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getLevel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getListName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getPlayerTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getPlayerTimeOffset() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPlayerWeather() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getSaturation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getTotalExperience() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Number getWalkSpeed() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void giveExp(Number amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void giveExpLevels(Number levels) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasAchievement(String achievement) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFlying() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isHealthScaled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPlayerTimeRelative() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSneaking() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSprinting() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void kick(String reason) {
        // TODO Auto-generated method stub

    }

    @Override
    public void runCommand(String command) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playSound(String sound, Number volume, Number pitch) {
        // TODO Auto-generated method stub

    }

    @Override
    public void playSound(String sound, Number volume, Number pitch, JsLocation location) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeAchievement(String achievement) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resetPlayerTime() {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendMessage(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendMessage(String[] messages) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setAllowFlight(Boolean allowFlight) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBedSpawnLocation(JsLocation location) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCompassTarget(JsLocation location) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDisplayName(String displayName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setExhaustion(Number value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setExp(Number exp) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFlying(Boolean flying) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFlySpeed(Number flySpeed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFoodLevel(Number foodLevel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHealthScale(Number healthScale) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHealthScaled(Boolean healthScaled) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLevel(Number level) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPlayerListName(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPlayerTime(Number time, Boolean relative) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPlayerWeather(String weather) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSaturation(Number saturation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSneaking(Boolean sneaking) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSprinting(Boolean sprinting) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTotalExperience(Number totalExperience) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setWalkSpeed(Number walkSpeed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeInventory() {
        // TODO Auto-generated method stub

    }

    @Override
    public JsItemStack[] getEnderChest() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getGameMode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsItemStack[] getInventory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsItemStack getItemInMainHand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsItemStack getItemInOffHand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JsItemStack getItemOnCursor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isBlocking() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSleeping() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setEnderChest(JsItemStack[] items) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setGameMode(String gameMode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setInventory(JsItemStack[] items) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setItemInMainHand(JsItemStack item) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setItemInOffHand(JsItemStack item) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasPermission(String permission) {
        // TODO Auto-generated method stub
        return false;
    }
}
