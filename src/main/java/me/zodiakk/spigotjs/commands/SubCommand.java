package me.zodiakk.spigotjs.commands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.i18n.I18nLanguage;

public abstract class SubCommand implements CommandExecutor {
    protected static I18nLanguage i18n = null;
    private Set<SubCommand> childrens = new HashSet<SubCommand>();
    private SubCommand parent = null;
    private String command;

    {
        if (i18n == null) {
            i18n = SpigotJsApi.getInstance().getI18n().getCurrentLanguage();
        }
    }

    protected SubCommand(SubCommand parent, String command) {
        this.parent = parent;
        this.command = command;
    }

    protected SubCommand(String command) {
        this.command = command;
    }

    public CommandExecutor getParentCommand() {
        return parent;
    }

    public String getCommand() {
        return command;
    }

    public Set<SubCommand> getSubCommands() {
        return childrens;
    }

    public String getLabel(String cmdLabel) {
        if (parent == null) {
            return cmdLabel;
        }
        return parent.getLabel(cmdLabel) + " " + getCommand();
    }

    public void addSubCommand(SubCommand command) {
        childrens.add(command);
    }

    public boolean permissionCheck(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(i18n.get("error.noPermission"));
            return false;
        }
        return true;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(i18n.get("error.consoleSender"));
        } else if (!(sender instanceof Player)) {
            sender.sendMessage(i18n.get("error.entitySender"));
        }

        if (args.length > 0) {
            for (SubCommand sub : childrens) {
                if (sub.getCommand().equalsIgnoreCase(args[0])) {
                    sub.onCommand(sender, command, label + " " + args[0], Arrays.copyOfRange(args, 1, args.length));
                    return true;
                }
            }
        }

        onSubCommand(sender, command, label, args);

        return true;
    }

    public abstract void onSubCommand(CommandSender sender, Command command, String label, String[] args);
}
