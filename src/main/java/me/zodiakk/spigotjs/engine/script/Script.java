package me.zodiakk.spigotjs.engine.script;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    private JavascriptContext mainContext;
    private Set<JavascriptContext> subContexts;
    private String fileName = "";
    private boolean isPaused = true;
    private boolean isEnabled = false;

    public Script() {
        linker = new ScriptLinker(this);
        description = new ScriptDescription(this);
        eventManager = new ScriptEventManager(this);
        commandManager = new ScriptCommandManager(this);
        schedulerManager = new ScriptSchedulerManager(this);
        mainContext = null;
        subContexts = new HashSet<JavascriptContext>();
    }

    public JavascriptContext getMainContext() { // TODO: Set to protected
        return mainContext;
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
        Bukkit.getLogger().info(fileName);
        mainContext = new JavascriptContext(file, this);
        mainContext.execute();
    }

    public void addSubContext(File file) throws IOException {
        JavascriptContext subContext = new JavascriptContext(file, this);

        subContexts.add(subContext);
        subContext.execute();
    }

    public void enable() {
        isPaused = false;
        isEnabled = true;
        eventManager.onEvent(EventType.ENABLE, new SpigotServer(Bukkit.getServer()));
    }

    public void disable() {
        eventManager.onEvent(EventType.DISABLE, new SpigotServer(Bukkit.getServer()));
        isPaused = true;
        isEnabled = false;
    }

    public void reload() {
        eventManager.onEvent(EventType.RELOAD, new SpigotServer(Bukkit.getServer()));
    }

    public void unload() {
        commandManager.unregisterAll();
        eventManager.unregisterAll();
        schedulerManager.unregisterAll();
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return mainContext.getFile();
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void pause() {
        isPaused = true;
    }

    public void unpause() {
        isPaused = false;
    }
}
