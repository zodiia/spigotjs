package me.zodiakk.spigotjs.engine.object;

import java.util.Date;

import org.graalvm.polyglot.Value;

public interface Server extends ApiElement {
    public void             banIp(String ip, String reason, Date expiresDate);
    public int              broadcastMessage(String message);
    public boolean          runCommand(String command);
    public boolean          runCommand(String command, Player player);
    public Player[]         matchPlayer(String player);
    public void             restart();
    public void             shutdown();
    public void             pardonIp(String ip);
    public void             cancelTask(Number taskId);
    public void             cancelScriptTasks();
    public boolean          isTaskRunning(Number taskId);
    public boolean          isTaskQueued(Number taskId);
    public boolean          isTaskAsync(Number taskId);
    public int              runTask(Value function);
    public int              runTaskLater(Value function, Number delay);
    public int              runTaskTimer(Value function, Number delay, Number timer);
    public int              runTaskAsync(Value function);
    public int              runTaskLaterAsync(Value function, Number delay);
    public int              runTaskTimerAsync(Value function, Number delay);
    public void             addPermission(String permission);
    public void             addPermission(String permission, String defaultValue);
    public void             addPermission(String permission, String defaultValue, String description);
    public void             addPermission(String permission, boolean defaultValue);
    public void             addPermission(String permission, boolean defaultValue, String description);
    public void             setPermissionDefault(String permission, String newDefault);
    public void             setPermissionDefault(String permission, boolean newDefault);
    public void             setPermissionDescription(String permission, String description);
    public void             setPermissionParent(String permission, String parentPermission, boolean value);
    public String[]         getPermissionParents(String permission);

    // Logs
    public void             log(String message);
    public void             info(String message);
    public void             warn(String message);
    public void             warning(String message);
    public void             error(String message);
    public void             severe(String message);
    public void             fine(String message);
    public void             finer(String message);
    public void             finest(String message);
    public void             debug(String message);

    // Properties
    public OfflinePlayer[]  getBannedPlayers();
    public String[]         getBannedIps();
    public OfflinePlayer    getOfflinePlayer(String player);
    public OfflinePlayer[]  getOfflinePlayers();
    public Player           getPlayer(String player);
    public Player[]         getPlayers();
    public OfflinePlayer[]  getWhitelistedPlayers();
    public World            getWorld(String world);
    public World[]          getWorlds();
    public boolean          getAllowEnd();
    public boolean          getAllowFlight();
    public boolean          getAllowNether();
    public int              getAmbientSpawnLimit();
    public int              getAnimalSpawnLimit();
    public String           getServerVersion();
    public String           getSpigotJsApiVersion();
    public String           getMinecraftVersion();
    public long             getConnectionThrottle();
    public String           getDefaultGameMode();
    public boolean          getGenerateStructures();
    public int              getIdleTimeout();
    public String           getIp();
    public int              getMaxPlayers();
    public int              getMonsterSpawnLimit();
    public String           getMotd();
    public String           getName();
    public boolean          getOnlineMode();
    public int              getPort();
    public String           getServerId();
    public String           getServerName();
    public String           getShutdownMessage();
    public int              getSpawnRadius();
    public int              getTicksPerAnimalSpawns();
    public int              getTicksPerMonsterSpawns();
    public int              getViewDistance();
    public int              getWaterAnimalSpawnLimit();
    public String           getWorldContainer();
    public String           getWorldType();
    public boolean          hasWhitelist();
    public boolean          isHardcore();
    public void             setDefaultGameMode(String mode);
    public void             setIdleTimeout(Number timeout);
    public void             setSpawnRadius(Number value);
    public void             setWhitelist(boolean whitelist);
    public String[]         getPermissions();
}
