package me.zodiakk.spigotjs.engine.object.impl;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import me.zodiakk.spigotjs.engine.object.JsBlock;
import me.zodiakk.spigotjs.engine.object.JsItemStack;
import me.zodiakk.spigotjs.engine.object.JsLocation;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotBlock implements JsBlock {
    private Block block;

    public SpigotBlock(Block block) {
        this.block = block;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(block)) {
            return clazz.cast(block);
        }
        return null;
    }

    @Override
    public boolean breakNaturally() {
        return block.breakNaturally();
    }

    @Override
    public boolean breakNaturally(JsItemStack tool) {
        return block.breakNaturally(tool.java(ItemStack.class));
    }

    @Override
    public String getBiome() {
        return block.getBiome().toString().toLowerCase();
    }

    @Override
    public Number getPower() {
        return block.getBlockPower();
    }

    @Override
    public Number getPower(String face) {
        return block.getBlockPower(BlockFace.valueOf(face.toUpperCase()));
    }

    @Override
    public JsItemStack[] getDrops() {
        List<JsItemStack> stacks = new ArrayList<JsItemStack>();

        block.getDrops().forEach(stack -> stacks.add(new SpigotItemStack(stack)));
        return stacks.toArray(new JsItemStack[0]);
    }

    @Override
    public JsItemStack[] getDrops(JsItemStack tool) {
        List<JsItemStack> stacks = new ArrayList<JsItemStack>();

        block.getDrops(tool.java(ItemStack.class)).forEach(stack -> stacks.add(new SpigotItemStack(stack)));
        return stacks.toArray(new JsItemStack[0]);
    }

    @Override
    public String getFace(JsBlock block) {
        return this.block.getFace(block.java(this.block.getClass())).toString().toLowerCase();
    }

    @Override
    public Number getHumidity() {
        return block.getHumidity();
    }

    @Override
    public Number getBlocksLightLevel() {
        return block.getLightFromBlocks();
    }

    @Override
    public Number getSkyLightLevel() {
        return block.getLightFromSky();
    }

    @Override
    public Number getLightLevel() {
        return block.getLightLevel();
    }

    @Override
    public JsLocation getLocation() {
        return new SpigotLocation(block.getLocation());
    }

    @Override
    public String getPistonReaction() {
        return block.getPistonMoveReaction().toString().toLowerCase();
    }

    @Override
    public JsBlock getRelative(String face) {
        return new SpigotBlock(block.getRelative(BlockFace.valueOf(face.toUpperCase())));
    }

    @Override
    public JsBlock getRelative(String face, Number distance) {
        return new SpigotBlock(block.getRelative(BlockFace.valueOf(face.toUpperCase()), distance.intValue()));
    }

    @Override
    public JsBlock getRelative(Number x, Number y, Number z) {
        return new SpigotBlock(block.getRelative(x.intValue(), y.intValue(), z.intValue()));
    }

    @Override
    public Number getTemperature() {
        return block.getTemperature();
    }

    @Override
    public String getType() {
        return block.getType().toString().toLowerCase();
    }

    @Override
    public JsWorld getWorld() {
        return new SpigotWorld(block.getWorld());
    }

    @Override
    public Number getX() {
        return block.getX();
    }

    @Override
    public Number getY() {
        return block.getY();
    }

    @Override
    public Number getZ() {
        return block.getZ();
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(String face) {
        return block.isBlockFaceIndirectlyPowered(BlockFace.valueOf(face.toUpperCase()));
    }

    @Override
    public boolean isBlockFacePowered(String face) {
        return block.isBlockFacePowered(BlockFace.valueOf(face.toUpperCase()));
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        return block.isBlockIndirectlyPowered();
    }

    @Override
    public boolean isBlockPowered() {
        return block.isBlockPowered();
    }

    @Override
    public boolean isEmpty() {
        return block.isEmpty();
    }

    @Override
    public boolean isLiquid() {
        return block.isLiquid();
    }

    @Override
    public void setBiome(String biome) {
        block.setBiome(Biome.valueOf(biome.toUpperCase()));
    }

    @Override
    public void setType(String material) {
        block.setType(Material.valueOf(material.toUpperCase()));
    }

    @Override
    public void setType(String material, Boolean applyPhysics) {
        block.setType(Material.valueOf(material.toUpperCase()), applyPhysics);
    }
}
