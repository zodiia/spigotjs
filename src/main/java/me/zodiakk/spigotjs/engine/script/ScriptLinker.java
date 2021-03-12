package me.zodiakk.spigotjs.engine.script;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.engine.event.EventType;
import me.zodiakk.spigotjs.i18n.I18nLanguage;

public class ScriptLinker {
    protected static I18nLanguage i18n = null;
    private final Script script;

    {
        if (i18n == null) {
            i18n = SpigotJsApi.getInstance().getI18n().getCurrentLanguage();
        }
    }

    public ScriptLinker(Script script) {
        this.script = script;
    }

    public void register(Value description) {
        if (!description.hasMembers()) {
            Bukkit.getLogger().severe(i18n.get("script.error.invalidDescription", script.getFileName()));
            return;
        }
        script.getDescription().fromValue(description);
    }

    public void on(String id, Value callback) {
        if (id == null) {
            throw new IllegalArgumentException("No event type provided.");
        }

        EventType type = EventType.fromName(id);

        if (type == null) {
            Bukkit.getLogger()
                    .warning(i18n.get("script.error.noSuchEventType", script.getDescription().toShortString(), id));
            return;
        }
        if (callback == null || callback.isNull()) {
            script.getEventManager().unregister(type);
            return;
        }
        if (!callback.canExecute()) {
            throw new IllegalArgumentException("Callback argument cannot be executed. Are you sure it is a function?");
        }
        if (!script.getEventManager().register(type, callback)) {
            throw new IllegalStateException("Could not register this event.");
        }
    }

    public void command(Value command, Value callback)
            throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        if (command == null || command.isNull() || callback == null || !callback.canExecute()) {
            throw new IllegalArgumentException("One of the arguments is invalid.");
        }
        if (command.isString()) {
            if (!script.getCommandManager().registerCommand(command.asString(), callback)) {
                throw new IllegalStateException("Could not register this command.");
            }
        } else if (command.hasMembers()) {
            if (!script.getCommandManager().registerCommand(command, callback)) {
                throw new IllegalStateException("Could not register this command.");
            }
        } else {
            throw new IllegalArgumentException("Command argument isn't a string.");
        }
    }

    public Number schedule(Number delay, Value callback) {
        if (delay == null || delay.longValue() < 0) {
            throw new IllegalArgumentException("Delay isn't a positive number.");
        }
        if (callback == null || callback.isNull() || !callback.canExecute()) {
            throw new IllegalArgumentException("Callback isn't executable.");
        }
        return script.getSchedulerManager().registerTask(delay.longValue(), callback);
    }

    public Number schedule(Number delay, Number repeat, Value callback) {
        if (delay == null || delay.longValue() < 0) {
            throw new IllegalArgumentException("Delay isn't a positive number.");
        }
        if (delay == null || repeat.longValue() < 0) {
            throw new IllegalArgumentException("Repeat isn't a positive number.");
        }
        if (callback == null || callback.isNull() || !callback.canExecute()) {
            throw new IllegalArgumentException("Callback isn't executable.");
        }
        return script.getSchedulerManager().registerTask(delay.longValue(), callback);
    }

    public void unschedule(Number taskId) {
        if (taskId == null || taskId.longValue() < 0L) {
            throw new IllegalArgumentException("Task ID isn't a positive number.");
        }
        if (!script.getSchedulerManager().unregisterTask(taskId.intValue())) {
            throw new IllegalArgumentException("Task ID is invalid.");
        }
    }

    public void include(String path) throws IOException {
        File newFile;

        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException("No path provided.");
        }
        newFile = new File(script.getFile().getParentFile(), path);
        if (!newFile.exists() || newFile.isDirectory()) {
            throw new IllegalArgumentException("File at path " + newFile.getAbsolutePath() + " does not exist.");
        }
        script.addSubContext(newFile);
    }
}
