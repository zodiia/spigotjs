package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.Optional;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.engine.script.Script;

public class UnpauseCommand extends SubCommand {
    public UnpauseCommand(SpigotJsCommand parent) {
        super(parent, "unpause");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args, "");

        if (opts.argumentCount() != 1) {
            displayHelp(sender, label);
            return;
        }

        Optional<Script> script = SpigotJsApi.getInstance().getScriptManager().getScripts().stream()
                .filter((sc) -> sc.getFileName() == opts.getArgument(0))
                .findFirst();

        if (!script.isPresent()) {
            sender.sendMessage(i18n.get("error.scriptNotFound", opts.getArgument(0)));
            return;
        }
        if (script.get().isPaused()) {
            sender.sendMessage(i18n.get("command.sjs.unpause.notPaused"));
            return;
        }
        script.get().unpause();
        sender.sendMessage(i18n.get("command.sjs.unpause.scriptUnaused", opts.getArgument(0)));
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.unpause.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
