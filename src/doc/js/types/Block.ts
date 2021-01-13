import { ItemStack, Location, World } from 'types';
import 'typedefs';

/**
 * Represents a single Block in the world.
 */
export abstract class Block {
    static noop: Block;

    breakNaturally(tool?: ItemStack): boolean { return false; }
    getBiome(): Biome { return 'plains'; }
    getPower(face?: BlockFace): number { return 0; }
    getDrops(item?: ItemStack): ItemStack[] { return []; }
    getFace(block: Block): BlockFace | null { return null; }
    getHumidity(): number { return 0; }
    getBlocksLightLevel(): number { return 0; }
    getSkyLightLevel(): number { return 0; }
    getLightLevel(): number { return 0; }
    getLocation(): Location { return Location.noop; }
    getPistonReaction(): PistonReaction { return 'ignore'; }
    getRelative(face: string, distance?: number): Block;
    getRelative(x: number, y: number, z: number): Block;
    getRelative(a0: string | number, a1: number | void, a2: number | void): Block { return Block.noop; }
    getTemperature(): number { return 0; }
    getType(): string { return ''; }
    getWorld(): World { return World.noop; }
    getX(): number { return 0; }
    getY(): number { return 0; }
    getZ(): number { return 0; }
    isBlockFaceIndirectlyPowered(face: BlockFace): boolean { return false; }
    isBlockFacePowered(face: BlockFace): boolean { return false; }
    isBlockIndirectlyPowered(): boolean { return false; }
    isBlockPowered(): boolean { return false; }
    isEmpty(): boolean { return false; }
    isLiquid(): boolean { return false; }
    setBiome(biome: Biome): void {}
    setType(type: string, applyPhysics?: boolean): void {}
}
