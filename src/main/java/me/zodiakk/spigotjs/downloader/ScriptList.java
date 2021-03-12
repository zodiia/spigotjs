package me.zodiakk.spigotjs.downloader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.bukkit.Bukkit;

public class ScriptList {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Set<DownloadableScript> scripts = new HashSet<DownloadableScript>();

    public ScriptList() {
        Bukkit.getLogger().info("Building scripts list...");
        buildList(null);
        Bukkit.getLogger().info("Scripts list built.");
    }

    public void buildList(String continuationToken) {
        try {
            String continuation = continuationToken == null ? "" : ("&continuationToken=" + continuationToken);
            URL url = new URL("http://repo.zodiakk.me/service/rest/v1/search/assets?repository=spigotjs-scripts" + continuation);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader in;
            String input;
            StringBuffer content = new StringBuffer();
            JsonObject res;

            con.setRequestMethod("GET");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((input = in.readLine()) != null) {
                content.append(input);
            }
            in.close();
            con.disconnect();
            res = new JsonParser().parse(content.toString()).getAsJsonObject();
            for (JsonElement elem : res.get("items").getAsJsonArray()) {
                scripts.add(new DownloadableScript(elem.getAsJsonObject()));
            }
            if (!res.get("continuationToken").isJsonNull()) {
                buildList(res.get("continuationToken").getAsString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Set<DownloadableScript> search(String keyword) {
        if (keyword == "*") {
            Set<DownloadableScript> res = new HashSet<DownloadableScript>(scripts);

            return res;
        }
        return scripts.stream().filter((sc) -> {
            if (sc.getAuthor().contains(keyword)) {
                return true;
            }
            if (sc.getName().contains(keyword)) {
                return true;
            }
            return false;
        }).collect(Collectors.toSet());
    }

    public Set<DownloadableScript> get(String name) {
        if (name.contains("/")) {
            String[] split = name.split("/");
            return scripts.stream().filter((sc) -> {
                if (sc.getAuthor().equals(split[0])
                        && (sc.getName().equals(split[1])
                            || sc.getName().equals(split[1] + ".js"))) {
                    return true;
                }
                return false;
            }).collect(Collectors.toSet());
        } else {
            return scripts.stream().filter((sc) -> {
                if (sc.getName().equals(name)
                        || sc.getName().equals(name + ".js")) {
                    return true;
                }
                return false;
            }).collect(Collectors.toSet());
        }
    }
}
