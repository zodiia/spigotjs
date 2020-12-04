package me.zodiakk.spigotjs.engine.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.engine.event.JsEventListener;
import me.zodiakk.spigotjs.engine.object.impl.SpigotServer;
import me.zodiakk.spigotjs.engine.script.Script;
import me.zodiakk.spigotjs.engine.script.ScriptException;

public abstract class SpigotEventListener implements JsEventListener, Listener {
    private static Plugin PLUGIN;
    private Value callback;
    private EventType type;
    private Script script;

    {
        if (PLUGIN == null) {
            PLUGIN = Bukkit.getServer().getPluginManager().getPlugin("SpigotJS");
        }
    }

    public SpigotEventListener(EventType type, Script script) {
        this.type = type;
        this.script = script;
    }

    @Override
    public void register(Value callback) {
        Bukkit.getServer().getPluginManager().registerEvents(this, PLUGIN);
        this.callback = callback;
    }

    @Override
    public void unregister() {
        HandlerList.unregisterAll(this);
    }

    @Override
    public void onEvent(Object arg) {
        try {
            callback.executeVoid(arg, new SpigotServer(Bukkit.getServer()));
        } catch (Throwable th) {
            throw new ScriptException(script, th);
        }
    }

    @Override
    public EventType getType() {
        return type;
    }

    protected Script getScript() {
        return script;
    }
}
