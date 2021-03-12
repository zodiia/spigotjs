package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.Optional;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.engine.script.Script;

public class StopCommand extends SubCommand {
    public StopCommand(SpigotJsCommand parent) {
        super(parent, "stop");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args, "f");

        if (opts.argumentCount() < 1) {
            displayHelp(sender, label);
            return;
        }

        if (opts.hasOption("f")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }

        Optional<Script> script = Optional.empty();
        for (Script sc : SpigotJsApi.getInstance().getScriptManager().getScripts()) {
            if (sc.getFileName().equals(opts.getArgument(0))) {
                script = Optional.of(sc);
            }
        }

        if (!script.isPresent()) {
            sender.sendMessage(i18n.get("error.scriptNotFound", opts.getArgument(0)));
            return;
        }
        SpigotJsApi.getInstance().getScriptManager().unregisterScript(script.get());
        sender.sendMessage(i18n.get("command.sjs.stop.scriptStopped", opts.getArgument(0)));
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.stop.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
