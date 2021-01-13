import { Player } from 'types';

export abstract class Command {
    static noop: Command;

    getCommandName(): string { return ''; }
    register(): void {}
    unregister(): void {}
    onCommand(player: Player, args: string[]): void {}
}
