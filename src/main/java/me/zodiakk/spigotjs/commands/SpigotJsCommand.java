package me.zodiakk.spigotjs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.engine.JavascriptContext;

public class SpigotJsCommand extends SubCommand {
    public SpigotJsCommand() {
        super("sjs");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        JavascriptContext context = new JavascriptContext();

        if (context.getBindings().hasMember("require")) {
            sender.sendMessage("require is a member");
        } else {
            sender.sendMessage("require is not a member");
        }

        if (context.getBindings().canInvokeMember("require")) {
            sender.sendMessage("require is invokable");
        } else {
            sender.sendMessage("require is not invokable");
        }
    }
}
