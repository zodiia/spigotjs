package me.zodiakk.spigotjs.commands.spigotjs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.commands.SpigotJsCommand;
import me.zodiakk.spigotjs.commands.SubCommand;
import me.zodiakk.spigotjs.engine.script.Script;

public class TestCommand extends SubCommand {
    public TestCommand(SpigotJsCommand parent) {
        super(parent, "test");
    }

    @Override
    public void onSubCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Running performances test...");

        boolean isOp = sender.isOp();

        Long time = System.currentTimeMillis();
        Player player = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0])[0];
        for (int i = 0; i < 1000; i++) {
            player.setOp(i % 2 == 0 ? true : false);
        }
        Long timeEnd = System.currentTimeMillis();

        sender.sendMessage("(1/4) JAVA: 1k player operations: " + (timeEnd - time) + "ms.");

        Script script = new Script();
        try {
            script.importFromFile(new File(SpigotJs.getInstance().getDataFolder(), "scripts/_test.js"));

            time = System.currentTimeMillis();
            script.enable();
            timeEnd = System.currentTimeMillis();
            sender.sendMessage("(2/4) JS: 1k player operations: " + (timeEnd - time) + "ms.");
        } catch (IOException e) {
            sender.sendMessage("(2/4) JS: 1k player operations: ERROR");
            e.printStackTrace();
        }

        TimedCountDown latchJava = new TimedCountDown(1000);
        TimedCountDown latchJs = new TimedCountDown(1000);
        PlayerMoveEvent event = new PlayerMoveEvent((Player) sender, null, null);
        Listener javaListener = new Listener() {
            @EventHandler
            public void onPlayerMove(PlayerMoveEvent event) {
                if (event.getPlayer().isOp()) {
                    event.getPlayer().setOp(false);
                } else {
                    event.getPlayer().setOp(true);
                }
                Bukkit.getLogger().info("Java: " + latchJava.getCount());
                latchJava.countDown();
            }
        };

        Bukkit.getServer().getPluginManager().registerEvents(javaListener, SpigotJs.getInstance());
        script.getContext().getBindings().putMember("countdown", latchJs);

        for (int i = 0; i < 1001; i++) {
            Bukkit.getServer().getPluginManager().callEvent(event);
        }

        Thread th1 = new Thread() {
            @Override
            public void run() {
                try {
                    latchJava.await();
                    sender.sendMessage("(3/4) JAVA: 1k events: " + latchJava.getTime() + "ms.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread th2 = new Thread() {
            @Override
            public void run() {
                try {
                    latchJs.await();
                    sender.sendMessage("(4/4) JS: 1k events: " + latchJs.getTime() + "ms.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sender.sendMessage("End of tests.");
        sender.setOp(isOp);
    }

    public void displayHelp(CommandSender sender, String label) {
        sender.sendMessage(i18n.getArray("command.sjs.ps.?", i18n.get("spigotJs"), label).toArray(new String[0]));
    }

    public Long getTime() {
        return System.currentTimeMillis();
    }
}
