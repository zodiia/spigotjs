package me.zodiakk.spigotjs.engine.script;

import org.graalvm.polyglot.Value;

public class ScriptCommandManager {
    private final Script script;

    public ScriptCommandManager(Script script) {
        this.script = script;
    }

    public void registerCommand(String command, Value callback) {

    }
}
