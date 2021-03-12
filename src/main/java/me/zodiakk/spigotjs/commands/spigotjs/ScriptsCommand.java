package me.zodiakk.spigotjs.commands.spigotjs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;

public class ScriptsCommand extends SubCommand {
    public ScriptsCommand(SpigotJsCommand parent) {
        super(parent, "scripts");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {

    }
}
