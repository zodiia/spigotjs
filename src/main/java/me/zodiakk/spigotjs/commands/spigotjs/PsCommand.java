package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.engine.script.Script;

public class PsCommand extends SubCommand {
    public PsCommand(SpigotJsCommand parent) {
        super(parent, "ps");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args, "apu");

        if (opts.argumentCount() != 0) {
            displayHelp(sender, label);
            return;
        }

        boolean displayDisabled = opts.hasOption("a");
        boolean displayPaused = !opts.hasOption("u");
        boolean displayRunning = !opts.hasOption("p");

        Set<Script> scripts = SpigotJsApi.getInstance().getScriptManager().getScripts();

        sender.sendMessage(i18n.get("command.sjs.ps.header"));
        for (Script script : scripts) {
            String name = script.getDescription().toShortString();

            if (script.isEnabled()) {
                if (script.isPaused() && displayPaused) {
                    sender.sendMessage(i18n.get("command.sjs.ps.pausedScript", name));
                } else if (!script.isPaused() && displayRunning) {
                    sender.sendMessage(i18n.get("command.sjs.ps.enabledScript", name));
                }
            } else if (!script.isEnabled() && displayDisabled) {
                sender.sendMessage(i18n.get("command.sjs.ps.disabledScript", name));
            }
            sender.sendMessage("> §7" + script.getDescription().getDescription());
        }
        sender.sendMessage(i18n.get("command.sjs.ps.footer"));
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.ps.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
