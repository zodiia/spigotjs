package me.zodiakk.spigotjs.event;

import org.bukkit.event.Event;

import me.zodiakk.spigotjs.engine.Script;

public abstract class ScriptEvent extends Event {
    private Script script;

    public ScriptEvent(Script script) {
        this.script = script;
    }

    public final Script getScript() {
        return script;
    }
}
