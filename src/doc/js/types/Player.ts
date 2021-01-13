import { LivingEntity } from './LivingEntity';
import { OfflinePlayer } from './OfflinePlayer';

/**
 * [[include:Player.md]]
 */

export abstract class Player extends LivingEntity {
    /**
     *
     * @example
     * ```js
     * const name = player.getName();
     * // name = 'Player';
     * ```
     */
    getName(): string { return ''; }
}
