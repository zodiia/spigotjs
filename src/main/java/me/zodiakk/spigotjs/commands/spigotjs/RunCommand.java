package me.zodiakk.spigotjs.commands.spigotjs;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.engine.script.Script;

public class RunCommand extends SubCommand {
    public RunCommand(SpigotJsCommand parent) {
        super(parent, "run");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args, "ae:i:o:");

        if (opts.argumentCount() < 1) {
            displayHelp(sender, label);
        }

        if (opts.hasOption("a")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }
        if (opts.hasOption("e")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }
        if (opts.hasOption("i")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }
        if (opts.hasOption("o")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }

        File scriptFile = new File(SpigotJs.getInstance().getSpigotJsConfig().getScriptsDirectory(), args[0]);

        try {
            Script script = SpigotJsApi.getInstance().getScriptManager().createScript(scriptFile);

            sender.sendMessage(i18n.get("command.sjs.run.runningScript", script.getDescription().toShortString()));
            sender.sendMessage(script.getDescription().toString());
            script.enable();
        } catch (IOException e) {
            sender.sendMessage(i18n.get("command.sjs.run.cannotLoad"));
            e.printStackTrace();
        }
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.run.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
