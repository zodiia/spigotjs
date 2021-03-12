
export abstract class Event {
    static noop: Event;

    getEventName(): string { return ''; }
    isAsynchronous(): boolean { return false; }
    isCancellable(): boolean { return false; }
    isCancelled(): boolean { return false; }
    setCancelled(cancelled: boolean): boolean { return false; }
}
