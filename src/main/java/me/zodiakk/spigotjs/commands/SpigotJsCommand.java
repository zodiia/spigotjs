package me.zodiakk.spigotjs.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.commands.spigotjs.RunCommand;
import me.zodiakk.spigotjs.engine.JavascriptContext;

public class SpigotJsCommand extends SubCommand {
    public SpigotJsCommand() {
        super("sjs");

        this.addSubCommand(new RunCommand(this));
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

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
