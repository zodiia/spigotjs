package me.zodiakk.spigotjs.engine;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import me.zodiakk.spigotjs.engine.script.Script;

public class ScriptManager {
    private Set<Script> registeredScripts = new HashSet<Script>();

    public void createScriptsInDirectory(File directory) throws IOException {
        if (!directory.isDirectory()) {
            return;
        }
        for (File file : directory.listFiles()) {
            createScript(file);
        }
    }

    public Script createScript(File file) throws IOException {
        Script script = new Script();

        script.importFromFile(file);
        registerScript(script);
        return script;
    }

    public void registerScript(Script script) {
        registeredScripts.add(script);
    }

    public void enable() {
        for (Script script : registeredScripts) {
            script.enable();
        }
    }

    public void disable() {
        for (Script script : registeredScripts) {
            script.disable();
        }
    }
}
