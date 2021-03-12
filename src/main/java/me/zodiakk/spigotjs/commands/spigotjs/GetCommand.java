package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.downloader.DownloadableScript;

public class GetCommand extends SubCommand {
    public GetCommand(SpigotJsCommand parent) {
        super(parent, "get");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args, "lr");

        if (opts.argumentCount() < 1) {
            displayHelp(sender, label);
            return;
        }

        if (opts.hasOption("l")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }
        if (opts.hasOption("r")) {
            sender.sendMessage(i18n.get("error.notYetImplemented"));
        }

        Set<DownloadableScript> scripts = SpigotJsApi.getInstance().getScriptDownloader().getList().get(opts.getArgument(0));

        if (scripts.size() < 1) {
            sender.sendMessage(i18n.get("command.sjs.get.noScriptFound"));
            return;
        } else if (scripts.size() > 1) {
            sender.sendMessage(i18n.get("command.sjs.get.multipleScriptsFound"));
            return;
        }
        try {
            DownloadableScript script = scripts.iterator().next();

            SpigotJsApi.getInstance().getScriptDownloader().download(script);
            sender.sendMessage(i18n.get("command.sjs.get.scriptDownloaded", label.split(" ")[0], script.getName()));
        } catch (Exception ex) {
            sender.sendMessage(i18n.get("error.unknownError"));
            return;
        }
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.get.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
