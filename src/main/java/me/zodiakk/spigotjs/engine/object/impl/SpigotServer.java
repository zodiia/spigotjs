package me.zodiakk.spigotjs.engine.object.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.object.JsOfflinePlayer;
import me.zodiakk.spigotjs.engine.object.JsPlayer;
import me.zodiakk.spigotjs.engine.object.JsServer;
import me.zodiakk.spigotjs.engine.object.JsWorld;

public class SpigotServer implements JsServer {
    private org.bukkit.Server server;

    public SpigotServer(org.bukkit.Server server) {
        this.server = server;
    }

    @Override
    public <T> T java(Class<T> clazz) {
        if (clazz.isInstance(server)) {
            return clazz.cast(server);
        }
        return null;
    }

    @Override
    public void banIp(String ip, String reason, Date expiresDate, String source) {
        server.getBanList(BanList.Type.IP).addBan(ip, reason, expiresDate, source);
    }

    @Override
    public int broadcastMessage(String message) {
        return server.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    @Override
    public boolean runCommand(String command) {
        return server.dispatchCommand(server.getConsoleSender(), command.substring(1));
    }

    @Override
    public boolean runCommand(String command, JsPlayer player) {
        return server.dispatchCommand(player.java(Player.class), command);
    }

    @Override
    public JsPlayer[] matchPlayer(String player) {
        Set<JsPlayer> players = new HashSet<JsPlayer>();

        server.matchPlayer(player).forEach(pl -> players.add(new SpigotPlayer(pl)));
        return players.toArray(new JsPlayer[0]);
    }

    @Override
    public void shutdown() {
        server.shutdown();
    }

    @Override
    public void pardonIp(String ip) {
        server.getBanList(BanList.Type.IP).pardon(ip);
    }

    @Override
    public void cancelTask(Number taskId) {
        server.getScheduler().cancelTask(taskId.intValue());
    }

    @Override
    public void cancelScriptTasks() {
        // TODO: Scheduler implementation
    }

    @Override
    public boolean isTaskRunning(Number taskId) {
        return server.getScheduler().isCurrentlyRunning(taskId.intValue());
    }

    @Override
    public boolean isTaskQueued(Number taskId) {
        return server.getScheduler().isQueued(taskId.intValue());
    }

    @Override
    public int runTask(Value function) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public int runTaskLater(Value function, Number delay) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public int runTaskTimer(Value function, Number delay, Number timer) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public int runTaskAsync(Value function) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public int runTaskLaterAsync(Value function, Number delay) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public int runTaskTimerAsync(Value function, Number delay) {
        // TODO: Scheduler implementation
        return 0;
    }

    @Override
    public void addPermission(String permission) {
        server.getPluginManager().addPermission(new Permission(permission));
    }

    @Override
    public void addPermission(String permission, String defaultValue) {
        server.getPluginManager().addPermission(new Permission(permission, PermissionDefault.valueOf(defaultValue.toUpperCase())));
    }

    @Override
    public void addPermission(String permission, String defaultValue, String description) {
        server.getPluginManager().addPermission(new Permission(permission, description, PermissionDefault.valueOf(defaultValue.toUpperCase())));
    }

    @Override
    public void addPermission(String permission, Boolean defaultValue) {
        server.getPluginManager().addPermission(new Permission(permission, PermissionDefault.valueOf(defaultValue.toString().toUpperCase())));
    }

    @Override
    public void addPermission(String permission, Boolean defaultValue, String description) {
        server.getPluginManager().addPermission(new Permission(permission, description, PermissionDefault.valueOf(defaultValue.toString().toUpperCase())));
    }

    @Override
    public void setPermissionDefault(String permission, String newDefault) {
        server.getPluginManager().getPermission(permission).setDefault(PermissionDefault.valueOf(newDefault.toUpperCase()));
    }

    @Override
    public void setPermissionDefault(String permission, Boolean newDefault) {
        server.getPluginManager().getPermission(permission).setDefault(PermissionDefault.valueOf(newDefault.toString().toUpperCase()));
    }

    @Override
    public void setPermissionDescription(String permission, String description) {
        server.getPluginManager().getPermission(permission).setDescription(description);
    }

    @Override
    public void setPermissionParent(String permission, String parentPermission, Boolean value) {
        server.getPluginManager().getPermission(permission).addParent(parentPermission, value == null ? true : value);
    }

    @Override
    public String[] getPermissionParents(String permission) {
        return server.getPluginManager().getPermission(permission).getChildren().keySet().toArray(new String[0]);
    }

    @Override
    public void log(String message) {
        server.getLogger().info(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void info(String message) {
        server.getLogger().info(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void warn(String message) {
        server.getLogger().warning(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void warning(String message) {
        server.getLogger().warning(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void error(String message) {
        server.getLogger().severe(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void severe(String message) {
        server.getLogger().severe(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void fine(String message) {
        server.getLogger().fine(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void finer(String message) {
        server.getLogger().finer(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void finest(String message) {
        server.getLogger().finest(ChatColor.translateAlternateColorCodes('&', message));
        // TODO: Js console
    }

    @Override
    public void setLoggingLevel(String level) {
        server.getLogger().setLevel(Level.parse(level.toUpperCase()));
        // TODO: Js console
    }

    @Override
    public JsOfflinePlayer[] getBannedPlayers() {
        Set<JsOfflinePlayer> players = new HashSet<JsOfflinePlayer>();

        server.getBannedPlayers().forEach(offlinePlayer -> players.add(new SpigotOfflinePlayer(offlinePlayer)));
        return players.toArray(new JsOfflinePlayer[0]);
    }

    @Override
    public String[] getBannedIps() {
        return server.getIPBans().toArray(new String[0]);
    }

    @Override
    public JsOfflinePlayer getOfflinePlayer(String uuid) {
        return new SpigotOfflinePlayer(server.getOfflinePlayer(UUID.fromString(uuid)));
    }

    @Override
    public JsOfflinePlayer[] getOfflinePlayers() {
        Set<JsOfflinePlayer> players = new HashSet<JsOfflinePlayer>();

        server.getWhitelistedPlayers().forEach(offlinePlayer -> players.add(new SpigotOfflinePlayer(offlinePlayer)));
        return players.toArray(new JsOfflinePlayer[0]);
    }

    @Override
    public JsPlayer getPlayer(String player) {
        return new SpigotPlayer(server.getPlayer(player));
    }

    @Override
    public JsPlayer[] getPlayers() {
        Set<JsPlayer> players = new HashSet<JsPlayer>();

        server.getOnlinePlayers().forEach(player -> players.add(new SpigotPlayer(player)));
        return players.toArray(new JsPlayer[0]);
    }

    @Override
    public JsOfflinePlayer[] getWhitelistedPlayers() {
        Set<JsOfflinePlayer> players = new HashSet<JsOfflinePlayer>();

        server.getWhitelistedPlayers().forEach(offlinePlayer -> players.add(new SpigotOfflinePlayer(offlinePlayer)));
        return players.toArray(new JsOfflinePlayer[0]);
    }

    @Override
    public JsWorld getWorld(String world) {
        return new SpigotWorld(server.getWorld(world));
    }

    @Override
    public JsWorld getWorldById(String id) {
        return new SpigotWorld(server.getWorld(UUID.fromString(id)));
    }

    @Override
    public JsWorld[] getWorlds() {
        JsWorld[] worlds = new JsWorld[server.getWorlds().size()];
        int i = 0;

        for (World world : server.getWorlds()) {
            worlds[i++] = new SpigotWorld(world);
        }
        return worlds;
    }

    @Override
    public boolean getAllowEnd() {
        return server.getAllowEnd();
    }

    @Override
    public boolean getAllowFlight() {
        return server.getAllowFlight();
    }

    @Override
    public boolean getAllowNether() {
        return server.getAllowFlight();
    }

    @Override
    public int getAmbientSpawnLimit() {
        return server.getAmbientSpawnLimit();
    }

    @Override
    public int getAnimalSpawnLimit() {
        return server.getAnimalSpawnLimit();
    }

    @Override
    public String getServerVersion() {
        return server.getBukkitVersion();
    }

    @Override
    public String getMinecraftVersion() {
        return server.getVersion();
    }

    @Override
    public long getConnectionThrottle() {
        return server.getConnectionThrottle();
    }

    @Override
    public String getDefaultGameMode() {
        return server.getDefaultGameMode().toString();
    }

    @Override
    public boolean getGenerateStructures() {
        return server.getGenerateStructures();
    }

    @Override
    public int getIdleTimeout() {
        return server.getIdleTimeout();
    }

    @Override
    public String getIp() {
        return server.getIp();
    }

    @Override
    public int getMaxPlayers() {
        return server.getMaxPlayers();
    }

    @Override
    public int getMonsterSpawnLimit() {
        return server.getMonsterSpawnLimit();
    }

    @Override
    public String getMotd() {
        return server.getMotd();
    }

    @Override
    public String getName() {
        return server.getName();
    }

    @Override
    public boolean getOnlineMode() {
        return server.getOnlineMode();
    }

    @Override
    public int getPort() {
        return server.getPort();
    }

    @Override
    public String getServerName() {
        return server.getName();
    }

    @Override
    public String getShutdownMessage() {
        return server.getShutdownMessage();
    }

    @Override
    public int getSpawnRadius() {
        return server.getSpawnRadius();
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        return server.getTicksPerAnimalSpawns();
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        return server.getTicksPerMonsterSpawns();
    }

    @Override
    public int getViewDistance() {
        return server.getViewDistance();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        return server.getWaterAnimalSpawnLimit();
    }

    @Override
    public String getWorldContainer() {
        return server.getWorldContainer().getPath();
    }

    @Override
    public String getWorldType() {
        return server.getWorldType();
    }

    @Override
    public boolean hasWhitelist() {
        return server.hasWhitelist();
    }

    @Override
    public boolean isHardcore() {
        return server.isHardcore();
    }

    @Override
    public void setDefaultGameMode(String mode) {
        server.setDefaultGameMode(GameMode.valueOf(mode.toUpperCase()));
    }

    @Override
    public void setIdleTimeout(Number timeout) {
        server.setIdleTimeout(timeout.intValue());
    }

    @Override
    public void setSpawnRadius(Number value) {
        server.setSpawnRadius(value.intValue());
    }

    @Override
    public void setWhitelist(Boolean whitelist) {
        server.setWhitelist(whitelist);
    }

    @Override
    public String[] getPermissions() {
        Set<String> permissions = new HashSet<String>();

        server.getPluginManager().getPermissions().forEach(perm -> permissions.add(perm.getName()));
        return permissions.toArray(new String[0]);
    }
}
