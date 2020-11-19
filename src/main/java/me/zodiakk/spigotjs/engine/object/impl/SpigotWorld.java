package me.zodiakk.spigotjs.engine.object.impl;

import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsEntity;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLivingEntity;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotWorld implements JsWorld {
    World world;

    public SpigotWorld(World world) {
        this.world = world;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(world)) {
            return clazz.cast(world);
        }
        return null;
    }

    @Override
    public boolean canGenerateStructures() {
        return world.canGenerateStructures();
    }

    @Override
    public boolean createExplosion(Number x, Number y, Number z, Number power) {
        return world.createExplosion(x.doubleValue(), y.doubleValue(), z.doubleValue(), power.floatValue());
    }

    @Override
    public boolean createExplosion(Number x, Number y, Number z, Number power, Boolean setFire) {
        return world.createExplosion(x.doubleValue(), y.doubleValue(), z.doubleValue(), power.floatValue(), setFire);
    }

    @Override
    public boolean createExplosion(Number x, Number y, Number z, Number power, Boolean setFire, Boolean breakBlocks) {
        return world.createExplosion(x.doubleValue(), y.doubleValue(), z.doubleValue(), power.floatValue(), setFire, breakBlocks);
    }

    @Override
    public boolean createExplosion(Number x, Number y, Number z, Number power, Boolean setFire, Boolean breakBlocks, JsEntity source) {
        return world.createExplosion(x.doubleValue(), y.doubleValue(), z.doubleValue(), power.floatValue(), setFire, breakBlocks, source.java(Entity.class));
    }

    @Override
    public boolean createExplosion(JsLocation location, Number power) {
        return world.createExplosion(location.java(Location.class), power.floatValue());
    }

    @Override
    public boolean createExplosion(JsLocation location, Number power, Boolean setFire) {
        return world.createExplosion(location.java(Location.class), power.floatValue(), setFire);
    }

    @Override
    public boolean createExplosion(JsLocation location, Number power, Boolean setFire, Boolean breakBlocks) {
        return world.createExplosion(location.java(Location.class), power.floatValue(), setFire, breakBlocks);
    }

    @Override
    public boolean createExplosion(JsLocation location, Number power, Boolean setFire, Boolean breakBlocks, JsEntity source) {
        return world.createExplosion(location.java(Location.class), power.floatValue(), setFire, breakBlocks, source.java(Entity.class));
    }

    @Override
    public void dropItem(JsLocation location, JsItemStack item) {
        world.dropItem(location.java(Location.class), item.java(ItemStack.class));
    }

    @Override
    public void dropItemNaturally(JsLocation location, JsItemStack item) {
        world.dropItemNaturally(location.java(Location.class), item.java(ItemStack.class));
    }

    @Override
    public boolean generateTree(JsLocation location, String treeType) {
        return world.generateTree(location.java(Location.class), TreeType.valueOf(treeType.toUpperCase()));
    }

    @Override
    public boolean getAllowAnimals() {
        return world.getAllowAnimals();
    }

    @Override
    public boolean getAllowMonsters() {
        return world.getAllowMonsters();
    }

    @Override
    public int getAmbientSpawnLimit() {
        return world.getAmbientSpawnLimit();
    }

    @Override
    public int getAnimalSpawnLimit() {
        return world.getAnimalSpawnLimit();
    }

    @Override
    public String getBiome(Number x, Number y, Number z) {
        return world.getBiome(x.intValue(), y.intValue(), z.intValue()).toString().toLowerCase();
    }

    @Override
    public String getBiome(JsLocation location) {
        return getBiome(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public JsBlock getBlock(Number x, Number y, Number z) {
        return new SpigotBlock(world.getBlockAt(x.intValue(), y.intValue(), z.intValue()));
    }

    @Override
    public JsBlock getBlock(JsLocation location) {
        return new SpigotBlock(world.getBlockAt(location.java(Location.class)));
    }

    @Override
    public String getDifficulty() {
        return world.getDifficulty().toString().toLowerCase();
    }

    @Override
    public JsEntity[] getEntities() {
        // TODO: SpigotEntity implementation
        return null;
    }

    @Override
    public JsEntity[] getEntities(String type) {
        // TODO: SpigotEntity implementation
        return null;
    }

    @Override
    public JsEntity[] getEntities(String[] types) {
        // TODO: SpigotEntity implementation
        return null;
    }

    @Override
    public String getEnvironment() {
        return world.getEnvironment().toString().toLowerCase();
    }

    @Override
    public Number getFullTime() {
        return world.getFullTime();
    }

    @Override
    public String[] getGameRules() {
        return world.getGameRules();
    }

    @Override
    public String getGameRule(String value) {
        return world.getGameRuleValue(GameRule.getByName(value.toUpperCase())).toString();
    }

    @Override
    public JsBlock getHighestBlockAt(Number x, Number z) {
        return new SpigotBlock(world.getHighestBlockAt(x.intValue(), z.intValue()));
    }

    @Override
    public JsBlock getHighestBlockAt(JsLocation location) {
        return new SpigotBlock(world.getHighestBlockAt(location.java(Location.class)));
    }

    @Override
    public Number getHighestBlockYAt(Number x, Number z) {
        return world.getHighestBlockYAt(x.intValue(), z.intValue());
    }

    @Override
    public Number getHighestBlockYAt(JsLocation location) {
        return world.getHighestBlockYAt(location.java(Location.class));
    }

    @Override
    public Number getHumidity(Number x, Number y, Number z) {
        return world.getHumidity(x.intValue(), y.intValue(), z.intValue());
    }

    @Override
    public Number getHumidity(JsLocation location) {
        return getHumidity(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        return world.getKeepSpawnInMemory();
    }

    @Override
    public JsLivingEntity[] getLivingEntities() {
        // TODO: SpigotLivingEntity
        return null;
    }

    @Override
    public Number getMaxHeight() {
        return world.getMaxHeight();
    }

    @Override
    public Number getMonsterSpawnLimit() {
        return world.getMonsterSpawnLimit();
    }

    @Override
    public String getName() {
        return world.getName();
    }

    @Override
    public JsEntity[] getNearbyEntities(JsLocation location, Number x, Number y, Number z) {
        // TODO: SpigotEntity
        return null;
    }

    @Override
    public JsEntity[] getNearbyEntities(JsLocation location, Number distance) {
        // TODO: SpigotEntity
        return null;
    }

    @Override
    public JsPlayer[] getPlayers() {
        // TODO: SpigotPlayer
        return null;
    }

    @Override
    public boolean getPvp() {
        return world.getPVP();
    }

    @Override
    public Number getSeaLevel() {
        return world.getSeaLevel();
    }

    @Override
    public Number getSeed() {
        return world.getSeed();
    }

    @Override
    public JsLocation getSpawnLocation() {
        return new SpigotLocation(world.getSpawnLocation());
    }

    @Override
    public Number getTemperature(Number x, Number y, Number z) {
        return world.getTemperature(x.intValue(), y.intValue(), z.intValue());
    }

    @Override
    public Number getTemperature(JsLocation location) {
        return getTemperature(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public Number getThunderDuration() {
        return world.getThunderDuration();
    }

    @Override
    public Number getTicksPerAmbientSpawns() {
        return world.getTicksPerAmbientSpawns();
    }

    @Override
    public Number getTicksPerAnimalSpawns() {
        return world.getTicksPerAnimalSpawns();
    }

    @Override
    public Number getTicksPerMonsterSpawns() {
        return world.getTicksPerMonsterSpawns();
    }

    @Override
    public Number getTicksPerWaterAmbientSpawns() {
        return world.getTicksPerWaterAmbientSpawns();
    }

    @Override
    public Number getTicksPerWaterSpawns() {
        return world.getTicksPerWaterSpawns();
    }

    @Override
    public Number getTime() {
        return world.getTime();
    }

    @Override
    public String getId() {
        return world.getUID().toString();
    }

    @Override
    public Number getWaterSpawnLimit() {
        return world.getWaterAnimalSpawnLimit();
    }

    @Override
    public Number getWaterAmbientSpawnLimit() {
        return world.getWaterAmbientSpawnLimit();
    }

    @Override
    public Number getWeatherDuration() {
        return world.getWeatherDuration();
    }

    @Override
    public boolean hasStorm() {
        return world.hasStorm();
    }

    @Override
    public boolean hasAutoSave() {
        return world.isAutoSave();
    }

    @Override
    public boolean isGameRule(String gameRule) {
        return world.isGameRule(gameRule);
    }

    @Override
    public boolean isThundering() {
        return world.isThundering();
    }

    @Override
    public void loadChunk(Number chunkX, Number chunkZ) {
        world.loadChunk(chunkX.intValue(), chunkZ.intValue());
    }

    @Override
    public void loadChunk(Number chunkX, Number chunkZ, Boolean generate) {
        world.loadChunk(chunkX.intValue(), chunkZ.intValue(), generate);
    }

    @Override
    public void playSound(JsLocation location, String sound, Number volume, Number pitch) {
        world.playSound(location.java(Location.class), Sound.valueOf(sound.toUpperCase()), volume.floatValue(), pitch.floatValue());
    }

    @Override
    public void playSound(JsLocation location, String sound, String category, Number volume, Number pitch) {
        world.playSound(location.java(Location.class), Sound.valueOf(sound.toUpperCase()), SoundCategory.valueOf(category.toUpperCase()), volume.floatValue(), pitch.floatValue());
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean regenerateChunk(Number chunkX, Number chunkZ) {
        return world.regenerateChunk(chunkX.intValue(), chunkZ.intValue());
    }

    @Override
    public void save() {
        world.save();
    }

    @Override
    public void setAmbientSpawnLimit(Number limit) {
        world.setAmbientSpawnLimit(limit.intValue());
    }

    @Override
    public void setAnimalSpawnLimit(Number limit) {
        world.setAnimalSpawnLimit(limit.intValue());
    }

    @Override
    public void setAutoSave(Boolean value) {
        world.setAutoSave(value);
    }

    @Override
    public void setBiome(Number x, Number y, Number z, String biome) {
        world.setBiome(x.intValue(), y.intValue(), z.intValue(), Biome.valueOf(biome.toUpperCase()));
    }

    @Override
    public void setBiome(JsLocation location, String biome) {
        setBiome(location.getBlockX(), location.getBlockY(), location.getBlockZ(), biome);
    }

    @Override
    public void setDifficulty(String difficulty) {
        world.setDifficulty(Difficulty.valueOf(difficulty.toUpperCase()));
    }

    @Override
    public void setFullTime(Number time) {
        world.setFullTime(time.longValue());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setGameRule(String rule, String value) {
        // FIXME: Looking for an implementation with World#setGameRule(GameRule<T>, T)
        world.setGameRuleValue(rule, value);
    }

    @Override
    public void setKeepSpawnInMemory(Boolean keepLoaded) {
        world.setKeepSpawnInMemory(keepLoaded);
    }

    @Override
    public void setMonsterSpawnLimit(Number limit) {
        world.setMonsterSpawnLimit(limit.intValue());
    }

    @Override
    public void setPvp(Boolean pvp) {
        world.setPVP(pvp);
    }

    @Override
    public void setSpawnFlags(Boolean allowMonsters, Boolean allowAnimals) {
        world.setSpawnFlags(allowMonsters, allowAnimals);
    }

    @Override
    public boolean setSpawnLocation(Number x, Number y, Number z) {
        return world.setSpawnLocation(x.intValue(), y.intValue(), z.intValue());
    }

    @Override
    public boolean setSpawnLocation(JsLocation location) {
        return world.setSpawnLocation(location.java(Location.class));
    }

    @Override
    public void setStorm(Boolean hasStorm) {
        world.setStorm(hasStorm);
    }

    @Override
    public void setThunderDuration(Number duration) {
        world.setThunderDuration(duration.intValue());
    }

    @Override
    public void setThundering(Boolean thundering) {
        world.setThundering(thundering);
    }

    @Override
    public void setTicksPerAmbientSpawn(Number ticks) {
        world.setTicksPerAmbientSpawns(ticks.intValue());
    }

    @Override
    public void setTicksPerAnimalSpawn(Number ticks) {
        world.setTicksPerAnimalSpawns(ticks.intValue());
    }

    @Override
    public void setTicksPerMonsterSpawn(Number ticks) {
        world.setTicksPerMonsterSpawns(ticks.intValue());
    }

    @Override
    public void setTicksPerWaterAmbientSpawn(Number ticks) {
        world.setTicksPerWaterAmbientSpawns(ticks.intValue());
    }

    @Override
    public void setTicksPerWaterSpawn(Number ticks) {
        world.setTicksPerWaterSpawns(ticks.intValue());
    }

    @Override
    public void setTime(Number time) {
        world.setTime(time.longValue());
    }

    @Override
    public void setWaterAmbientSpawnLimit(Number limit) {
        world.setWaterAmbientSpawnLimit(limit.intValue());
    }

    @Override
    public void setWaterSpawnLimit(Number limit) {
        world.setWaterAnimalSpawnLimit(limit.intValue());
    }

    @Override
    public void setWeatherDuration(Number duration) {
        world.setWeatherDuration(duration.intValue());
    }

    @Override
    public JsEntity spawnEntity(Number x, Number y, Number z, String entityType) {
        // TODO: SpigotEntity
        return null;
    }

    @Override
    public JsEntity spawnEntity(JsLocation location, String entityType) {
        // TODO: SpigotEntity
        return null;
    }

    @Override
    public void spawnArrow(JsLocation location, Number velocityX, Number velocityY, Number velocityZ, Number speed, Number spread) {
        world.spawnArrow(location.java(Location.class), new Vector(velocityX.doubleValue(), velocityY.doubleValue(), velocityZ.doubleValue()), speed.floatValue(), spread.floatValue());
    }

    @Override
    public void strikeLightning(Number x, Number y, Number z) {
        world.strikeLightning(new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue()));
    }

    @Override
    public void strikeLightning(JsLocation location) {
        world.strikeLightning(location.java(Location.class));
    }

    @Override
    public void strikeLightningEffect(Number x, Number y, Number z) {
        world.strikeLightningEffect(new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue()));
    }

    @Override
    public void strikeLightningEffect(JsLocation location) {
        world.strikeLightningEffect(location.java(Location.class));
    }

    @Override
    public boolean unloadChunk(Number chunkX, Number chunkZ) {
        return world.unloadChunk(chunkX.intValue(), chunkZ.intValue());
    }

    @Override
    public boolean unloadChunk(Number chunkX, Number chunkZ, Boolean save) {
        return world.unloadChunk(chunkX.intValue(), chunkZ.intValue(), save);
    }

    @Override
    public boolean unloadChunkRequest(Number chunkX, Number chunkZ) {
        return world.unloadChunkRequest(chunkX.intValue(), chunkZ.intValue());
    }
}
