package me.zodiakk.spigotjs;

import java.io.File;
import java.io.IOException;

import org.graalvm.polyglot.Engine;

import me.zodiakk.spigotjs.downloader.ScriptDownloader;
import me.zodiakk.spigotjs.engine.JavascriptContext;
import me.zodiakk.spigotjs.engine.ScriptManager;
import me.zodiakk.spigotjs.i18n.I18n;

/**
 * General SpigotJS API.
 */
public class SpigotJsApi {
    private static SpigotJsApi INSTANCE;
    private final Engine engine;
    private final I18n i18n;
    private final ScriptManager scriptManager;
    private final ScriptDownloader scriptDownloader;

    private SpigotJsApi() {
        try {
            i18n = new I18n();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        scriptManager = new ScriptManager();
        scriptDownloader = new ScriptDownloader();

        ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        engine = Engine.create();
        Thread.currentThread().setContextClassLoader(threadClassLoader);
    }

    /**
     * Get the current SpigotJsApi instance.
     * @return The API instance
     */
    public static final SpigotJsApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SpigotJsApi();
        }
        return INSTANCE;
    }

    public JavascriptContext createJavascriptContext() throws IOException {
        return new JavascriptContext(null);
    }

    public JavascriptContext createJavascriptContext(File file) throws IOException {
        return new JavascriptContext(file, null);
    }

    public I18n getI18n() {
        return i18n;
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }

    public ScriptDownloader getScriptDownloader() {
        return scriptDownloader;
    }

    public Engine getPolyglotEngine() {
        return engine;
    }
}
