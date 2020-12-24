package me.zodiakk.spigotjs.engine.script;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.engine.object.impl.SpigotPlayer;
import me.zodiakk.spigotjs.i18n.I18nLanguage;

public class ScriptCommandManager {
    private static I18nLanguage i18n;
    private static CommandMap commandMap;
    private final Script script;

    private Set<String> registeredCommands = new HashSet<String>();

    {
        if (i18n == null) {
            i18n = SpigotJsApi.getInstance().getI18n().getCurrentLanguage();
        }

        Field commandMapField;
        try {
            commandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            commandMap = (CommandMap) commandMapField.get(SpigotJs.getInstance().getServer().getPluginManager());
        } catch (Throwable t) {
            t.printStackTrace();
            // TODO: Big error message
        }
    }

    public ScriptCommandManager(Script script) {
        this.script = script;
    }

    public boolean registerCommand(String commandLabel, Value callback)
            throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<PluginCommand> commandConstructor = PluginCommand.class.getDeclaredConstructor(String.class,
                Plugin.class);
        PluginCommand command;

        commandConstructor.setAccessible(true);

        command = commandConstructor.newInstance(commandLabel, SpigotJs.getInstance());
        command.setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                Value retval;

                if (sender instanceof Player) {
                    retval = callback.execute(new SpigotPlayer((Player) sender), args, label);
                } else {
                    retval = callback.execute(null, args, label);
                }
                if (retval.isBoolean()) {
                    return retval.asBoolean();
                }
                return true;
            }
        });
        command.setDescription("A SpigotJs script command");
        commandMap.register(script.getDescription().getName().toLowerCase(), command);
        return true;
    }

    public boolean registerCommand(Value command, Value callback) {
        Bukkit.getLogger().warning(i18n.get("error.notYetImplemented"));
        return false;
    }

    public void unregister(String command) {
        if (!registeredCommands.contains(command)) {
            return;
        }
        commandMap.getCommand(command).unregister(commandMap);
    }

    public void unregisterAll() {
        for (String command : registeredCommands) {
            commandMap.getCommand(command).unregister(commandMap);
        }
    }
}
