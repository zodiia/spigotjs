package me.zodiakk.spigotjs.engine.event.impl;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.event.ScriptEventListener;

public abstract class SpigotEventListener implements ScriptEventListener, Listener {
    private static Plugin PLUGIN;
    private Value callback;

    {
        if (PLUGIN == null) {
            PLUGIN = Bukkit.getServer().getPluginManager().getPlugin("SpigotJS");
        }
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

    public void onEvent(Event event) {
        callback.executeVoid(event);
    }
}
