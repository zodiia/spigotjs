import { Entity } from "./Entity";
import { Location } from "./Location";

export abstract class World {
    static noop: World;

    canGenerateStructures(): boolean { return false; }
    createExplosion(x: number, y: number, z: number, power: number, setFire?: boolean, breakBlocks?: boolean, source?: Entity): boolean;
    createExplosion(location: Location, power: number, setFire?: boolean, breakBlocks?: boolean, source?: Entity): boolean;
    createExplosion(a0: number | Location, a1: number, a2?: number | boolean, a3?: number | boolean, a4?: boolean | Entity, a5?: boolean, a6?: Entity): boolean { return false; }
}
