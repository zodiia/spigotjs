package me.zodiakk.spigotjs.engine.object;

public interface JsBlock extends ApiElement {
    public boolean breakNaturally();
    public boolean breakNaturally(JsItemStack tool);
    public String getBiome();
    public Number getPower();
    public Number getPower(String face);
    public JsItemStack[] getDrops();
    public JsItemStack[] getDrops(JsItemStack tool);
    public String getFace(JsBlock block);
    public Number getHumidity();
    public Number getBlocksLightLevel();
    public Number getSkyLightLevel();
    public Number getLightLevel();
    public JsLocation getLocation();
    public String getPistonReaction();
    public JsBlock getRelative(String face);
    public JsBlock getRelative(String face, Number distance);
    public JsBlock getRelative(Number x, Number y, Number z);
    public Number getTemperature();
    public String getType();
    public JsWorld getWorld();
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
    public void setType(String material, Boolean applyPhysics);
}
