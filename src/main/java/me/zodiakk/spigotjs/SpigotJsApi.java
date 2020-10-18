package me.zodiakk.spigotjs;

import java.io.File;
import java.io.IOException;

import me.zodiakk.spigotjs.engine.JavascriptContext;
import me.zodiakk.spigotjs.i18n.I18n;

/**
 * General SpigotJS API.
 */
public class SpigotJsApi {
    private static final SpigotJsApi INSTANCE;
    private final I18n I18N;

    static {
        INSTANCE = new SpigotJsApi();
    }

    private SpigotJsApi() {
        try {
            I18N = new I18n();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    /**
     * Get the current SpigotJsApi instance.
     * @return The API instance
     */
    public static final SpigotJsApi getInstance() {
        return INSTANCE;
    }

    public JavascriptContext createJavascriptContext() {
        return new JavascriptContext();
    }

    public JavascriptContext createJavascriptContext(File file) throws IOException {
        return new JavascriptContext(file);
    }

    public I18n getI18n() {
        return I18N;
    }
}
