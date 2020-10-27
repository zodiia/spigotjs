package me.zodiakk.spigotjs.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.engine.JavascriptContext;

public class SpigotJsCommand extends SubCommand {
    public SpigotJsCommand() {
        super("sjs");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        JavascriptContext context;
        try {
            context = new JavascriptContext();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

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

        try {
            context.execute("const customBind = 18;");
        } catch (Exception ex) {
            // Truc
        }

        if (context.getBindings().hasMember("customBind")) {
            sender.sendMessage("require is a member");
        } else {
            sender.sendMessage("require is not a member");
        }
    }
}
