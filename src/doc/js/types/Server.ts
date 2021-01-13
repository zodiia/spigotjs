import { Player } from './Player';

/** Represents the server instance */
export abstract class Server {
    /** Get a list of all online players */
    abstract getPlayers(): Player[];
}
