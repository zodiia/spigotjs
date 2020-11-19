package me.zodiakk.spigotjs.engine.script;

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

    public void on(String id, Value callback) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        EventType type = EventType.fromName(id);

        if (type == null) {
            Bukkit.getLogger().warning(i18n.get("script.error.noSuchEventType", script.getDescription().toShortString(), id));
            return;
        }
        if (callback == null || callback.isNull()) {
            script.getEventManager().unregisterAll(type);
            return;
        }
        if (!callback.canExecute()) {
            throw new IllegalArgumentException();
        }
        if (!script.getEventManager().register(type, callback)) {
            throw new IllegalStateException();
        }
    }

    public void register(Value description) {
        if (!description.hasMembers()) {
            Bukkit.getLogger().severe(i18n.get("script.error.invalidDescription", script.getFileName()));
            return;
        }
        script.getDescription().fromValue(description);
    }

    public void command(String command, Value callback) {
        Bukkit.getLogger().info("command");
    }
}