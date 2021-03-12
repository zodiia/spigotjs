package me.zodiakk.spigotjs.commands.spigotjs;

import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.commands.CommandOptions;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.downloader.DownloadableScript;

public class SearchCommand extends SubCommand {
    public SearchCommand(SpigotJsCommand parent) {
        super(parent, "search");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandOptions opts = new CommandOptions(args);

        if (opts.argumentCount() < 1) {
            displayHelp(sender, label);
            return;
        }

        Set<DownloadableScript> scripts = SpigotJsApi.getInstance().getScriptDownloader().getList().search(opts.getArgument(0));
        int i = 0;

        sender.sendMessage(i18n.get("command.sjs.search.results", opts.getArgument(0)));
        for (DownloadableScript script : scripts) {
            sender.sendMessage(i18n.get("command.sjs.search.resultLine", script.getName(), script.getAuthor()));
            if (++i == 10) {
                break;
            }
        }
        if (scripts.size() == 0) {
            sender.sendMessage(i18n.get("command.sjs.search.noResults"));
        }
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.search.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }
}
