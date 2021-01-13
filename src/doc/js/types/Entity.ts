import { Location, World } from 'types';
import 'typedefs';

export abstract class Entity {
    static noop: Entity;

    ejectPassenger(): void {}
    getCustomName(): string { return ''; }
    getEntityId(): number { return 0; }
    getFallDistance(): number { return 0; }
    getFireTicks(): number { return 0; }
    getLocation(): Location { return Location.noop; }
    getMaxFireTicks(): number { return 0; }
    getName(): string { return ''; }
    getNearbyEntities(distance: number): Entity[];
    getNearbyEntities(x: number, y: number, z: number): Entity[];
    getNearbyEntities(a0: number, a1?: number, a2?: number): Entity[] { return []; }
    getPassengers(): Entity[] { return []; }
    getTicksLived(): number { return 0; }
    getType(): string { return ''; }
    getUniqueId(): string { return ''; }
    getVehicle(): Entity { return Entity.noop; }
    getWorld(): World { return World.noop; }
    isCustomNameVisible(): boolean { return false; }
    isDead(): boolean { return false; }
    isEmpty(): boolean { return false; }
    isInsideVehicle(): boolean { return false; }
    isOnGround(): boolean { return false; }
    leaveVehicle(): boolean { return false; }
    setCustomName(name: string): void {}
    setCustomNameVisible(flag: boolean): void {}
    setFallDistance(distance: number): void {}
    setFireTicks(ticks: number): void {}
    setPassenger(entity: Entity): void {}
    setPassengers(entities: Entity[]): void {}
    setTicksLived(ticks: number): void {}
    setVelocity(velocity: number[]): void;
    setVelocity(x: number, y: number, z: number): void;
    setVelocity(a0: number | number[], a1?: number, a2?: number): void {}
    teleport(to: Entity | Location): boolean { return false; }
}
