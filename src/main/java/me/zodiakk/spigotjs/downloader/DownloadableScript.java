package me.zodiakk.spigotjs.downloader;

import com.google.gson.JsonObject;

public class DownloadableScript {
    String name;
    String author;
    String downloadUrl;

    public DownloadableScript(JsonObject obj) {
        String path = obj.get("path").getAsString();

        this.name = path.split("/")[1];
        this.author = path.split("/")[0];
        this.downloadUrl = obj.get("downloadUrl").getAsString();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}
