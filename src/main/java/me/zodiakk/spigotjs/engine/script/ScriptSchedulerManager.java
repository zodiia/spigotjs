package me.zodiakk.spigotjs.engine.script;

import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.engine.object.impl.SpigotServer;

public class ScriptSchedulerManager {
    private Script script;
    private HashSet<BukkitTask> runningTasks = new HashSet<BukkitTask>();

    public ScriptSchedulerManager(Script script) {
        this.script = script;
    }

    public void unregisterAll() {
        for (BukkitTask task : runningTasks) {
            task.cancel();
        }
        runningTasks.clear();
    }

    public boolean unregisterTask(int id) {
        for (BukkitTask task : runningTasks) {
            if (task.getTaskId() == id) {
                task.cancel();
                runningTasks.remove(task);
                return true;
            }
        }
        return false;
    }

    public int registerTask(long delay, Value callback) {
        BukkitTask task = Bukkit.getServer().getScheduler().runTaskLater(JavaPlugin.getProvidingPlugin(SpigotJs.class), new Runnable() {
                @Override
                public void run() {
                    if (script.isPaused()) {
                        return;
                    }
                    callback.executeVoid(new SpigotServer(Bukkit.getServer()));
                }
            }, delay);

        runningTasks.add(task);
        return task.getTaskId();
    }

    public int registerTask(long delay, long timer, Value callback) {
        BukkitTask task = Bukkit.getServer().getScheduler().runTaskTimer(JavaPlugin.getProvidingPlugin(SpigotJs.class), new Runnable() {
                @Override
                public void run() {
                    if (script.isPaused()) {
                        return;
                    }
                    callback.executeVoid(new SpigotServer(Bukkit.getServer()));
                }
            }, delay, timer);

        runningTasks.add(task);
        return task.getTaskId();
    }
}
