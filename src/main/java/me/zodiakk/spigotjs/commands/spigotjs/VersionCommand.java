package me.zodiakk.spigotjs.commands.spigotjs;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;

public class VersionCommand extends SubCommand {
    public VersionCommand(SpigotJsCommand parent) {
        super(parent, "version");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§6SpigotJS version §7" + JavaPlugin.getProvidingPlugin(SpigotJs.class).getDescription().getVersion());
        sender.sendMessage("§6Spigot version §7" + Bukkit.getBukkitVersion());
        sender.sendMessage("§6Server API version §7" + Bukkit.getVersion());
        sender.sendMessage("§6Java version §7" + System.getenv("java.version"));
        sender.sendMessage("§6Host software §7" + System.getenv("os.name"));
    }
}
