package me.zodiakk.spigotjs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.commands.spigotjs.PsCommand;
import me.zodiakk.spigotjs.commands.spigotjs.RunCommand;
import me.zodiakk.spigotjs.commands.spigotjs.TestCommand;

public class SpigotJsCommand extends SubCommand {
    public SpigotJsCommand() {
        super("sjs");

        this.addSubCommand(new RunCommand(this));
        this.addSubCommand(new PsCommand(this));
        this.addSubCommand(new TestCommand(this));
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(i18n.getArray("command.sjs.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
