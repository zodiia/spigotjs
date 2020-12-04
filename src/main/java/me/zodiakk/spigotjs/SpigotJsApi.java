package me.zodiakk.spigotjs;

import java.io.File;
import java.io.IOException;

import org.graalvm.polyglot.Engine;

import me.zodiakk.spigotjs.engine.JavascriptContext;
import me.zodiakk.spigotjs.engine.ScriptManager;
import me.zodiakk.spigotjs.i18n.I18n;

/**
 * General SpigotJS API.
 */
public class SpigotJsApi {
    private static final SpigotJsApi INSTANCE = new SpigotJsApi();
    private final Engine engine;
    private final I18n i18n;
    private final ScriptManager scriptManager;

    private SpigotJsApi() {
        try {
            i18n = new I18n();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        scriptManager = new ScriptManager();

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
        return INSTANCE;
    }

    public JavascriptContext createJavascriptContext() throws IOException {
        return new JavascriptContext();
    }

    public JavascriptContext createJavascriptContext(File file) throws IOException {
        return new JavascriptContext(file);
    }

    public I18n getI18n() {
        return i18n;
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }

    public Engine getPolyglotEngine() {
        return engine;
    }
}
