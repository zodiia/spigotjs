package me.zodiakk.spigotjs.engine;

public class Script {
    private ScriptLinker linker;
    private ScriptDescription description;
    private ScriptEventManager eventManager;

    public Script() {
        linker = new ScriptLinker(this);
        description = new ScriptDescription(this);
        eventManager = new ScriptEventManager();
    }

    public ScriptLinker getLinker() {
        return linker;
    }

    public ScriptDescription getDescription() {
        return description;
    }

    public ScriptEventManager getEventManager() {
        return eventManager;
    }
}
