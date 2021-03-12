package me.zodiakk.spigotjs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.commands.spigotjs.GetCommand;
import me.zodiakk.spigotjs.commands.spigotjs.PauseCommand;
import me.zodiakk.spigotjs.commands.spigotjs.PsCommand;
import me.zodiakk.spigotjs.commands.spigotjs.RunCommand;
import me.zodiakk.spigotjs.commands.spigotjs.ScriptsCommand;
import me.zodiakk.spigotjs.commands.spigotjs.SearchCommand;
import me.zodiakk.spigotjs.commands.spigotjs.StopCommand;
import me.zodiakk.spigotjs.commands.spigotjs.TestCommand;
import me.zodiakk.spigotjs.commands.spigotjs.UnpauseCommand;
import me.zodiakk.spigotjs.commands.spigotjs.VersionCommand;

public class SpigotJsCommand extends SubCommand {
    public SpigotJsCommand() {
        super("sjs");

        this.addSubCommand(new RunCommand(this));
        this.addSubCommand(new PsCommand(this));
        this.addSubCommand(new TestCommand(this));
        this.addSubCommand(new PauseCommand(this));
        this.addSubCommand(new UnpauseCommand(this));
        this.addSubCommand(new VersionCommand(this));
        this.addSubCommand(new StopCommand(this));
        this.addSubCommand(new ScriptsCommand(this));
        this.addSubCommand(new GetCommand(this));
        this.addSubCommand(new SearchCommand(this));
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(i18n.getArray("command.sjs.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
