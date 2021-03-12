package me.zodiakk.spigotjs.downloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.plugin.java.JavaPlugin;

import me.zodiakk.spigotjs.SpigotJs;

public class ScriptDownloader {
    private ScriptList list;

    public ScriptDownloader() {
        list = new ScriptList();
    }

    public ScriptList getList() {
        return list;
    }

    public void download(DownloadableScript script) throws IOException {
        try {
            URL url = new URL(script.getDownloadUrl());
            URLConnection con = url.openConnection();
            DataInputStream in = new DataInputStream(con.getInputStream());
            FileOutputStream out = new FileOutputStream(new File(JavaPlugin.getProvidingPlugin(SpigotJs.class).getDataFolder(), "scripts/" + script.getName()));
            byte[] data = new byte[con.getContentLength()];

            for (int i = 0; i < data.length; i++) {
                data[i] = in.readByte();
            }
            in.close();
            out.write(data);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
