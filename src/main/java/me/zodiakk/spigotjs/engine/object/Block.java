package me.zodiakk.spigotjs.engine.object;

public interface Block extends ApiElement {
    public boolean breakNaturally();
    public boolean breakNaturally(ItemStack tool);
    public String getBiome();
    public Number getPower();
    public Number getPower(String face);
    public ItemStack[] getDrops();
    public ItemStack[] getDrops(ItemStack tool);
    public String getFace(Block block);
    public Number getHumidity();
    public Number getBlocksLightLevel();
    public Number getSkyLightLevel();
    public Number getLightLevel();
    public Location getLocation();
    public String getPistonReaction();
    public Block getRelative(String face);
    public Block getRelative(String face, Number distance);
    public Block getRelative(Number x, Number y, Number z);
    public Number getTemperature();
    public String getType();
    public World getWorld();
    public Number getX();
    public Number getY();
    public Number getZ();
    public boolean isBlockFaceIndirectlyPowered(String face);
    public boolean isBlockFacePowered(String face);
    public boolean isBlockIndirectlyPowered();
    public boolean isBlockPowered();
    public boolean isEmpty();
    public boolean isLiquid();
    public void setBiome(String biome);
    public void setType(String material);
    public void setType(String material, boolean applyPhysics);
}
