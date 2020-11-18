package me.zodiakk.spigotjs.engine.script;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;

import me.zodiakk.spigotjs.engine.JavascriptContext;
import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.object.impl.SpigotServer;

public class Script {
    private ScriptLinker linker;
    private ScriptDescription description;
    private ScriptEventManager eventManager;
    private ScriptSchedulerManager schedulerManager;
    private ScriptCommandManager commandManager;
    private JavascriptContext context;
    private String fileName = "";
    private boolean isPaused = true;

    public Script() {
        linker = new ScriptLinker(this);
        description = new ScriptDescription(this);
        eventManager = new ScriptEventManager(this);
        context = null;
    }

    protected JavascriptContext getContext() {
        return context;
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

    public ScriptSchedulerManager getSchedulerManager() {
        return schedulerManager;
    }

    public ScriptCommandManager getCommandManager() {
        return commandManager;
    }

    public void importFromFile(File file) throws IOException {
        fileName = file.getName();
        context = new JavascriptContext(file);
        context.setScript(this);
        context.execute();
    }

    public void enable() {
        isPaused = false;
        eventManager.onEvent(EventType.ENABLE, new SpigotServer(Bukkit.getServer()));
    }

    public void disable() {
        eventManager.onEvent(EventType.DISABLE, new SpigotServer(Bukkit.getServer()));
        isPaused = true;
    }

    public void reload() {
        eventManager.onEvent(EventType.RELOAD, new SpigotServer(Bukkit.getServer()));
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pause() {
        isPaused = true;
    }

    public void unpause() {
        isPaused = false;
    }
}
