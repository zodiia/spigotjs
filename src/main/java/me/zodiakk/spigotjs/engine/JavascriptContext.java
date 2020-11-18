package me.zodiakk.spigotjs.engine;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.engine.script.Script;

public class JavascriptContext {
    private static final Set<JavascriptContext> JS_LIBS;
    private static final Map<String, Object> REQUIRE_PATH;

    static {
        JS_LIBS = new HashSet<JavascriptContext>();
        REQUIRE_PATH = new HashMap<String, Object>();
    }

    private Source source;
    private Context context;
    private ClassLoader threadClassLoader;
    private ClassLoader graalClassLoader;
    private boolean currentClassLoaderIsThread = true;
    private Script script;

    public JavascriptContext() throws IOException {
        threadClassLoader = Thread.currentThread().getContextClassLoader();
        graalClassLoader = getClass().getClassLoader();
        switchClassLoader();
        context = Context.newBuilder("js").allowAllAccess(true).allowExperimentalOptions(true).build();
        switchClassLoader();
    }

    public JavascriptContext(File file) throws IOException {
        this();
        loadFile(file);
    }

    public JavascriptContext(URL url) throws IOException {
        this();
        loadFile(url);
    }

    public void setScript(Script script) throws IOException {
        switchClassLoader();
        this.script = script;
        Function<String, Object> require = (id) -> {
            if (id.equals("spigotjs")) {
                return this.script.getLinker();
            }
            // TODO: Import libraries
            // TODO: Import file
            return null;
        };
        context.getBindings("js").putMember("require", require);
        switchClassLoader();
    }

    public void loadFile(File file) throws IOException {
        switchClassLoader();
        source = Source.newBuilder("js", file).build();
        switchClassLoader();
    }

    public void loadFile(URL url) throws IOException {
        switchClassLoader();
        source = Source.newBuilder("js", url).build();
        switchClassLoader();
    }

    public Value getMember(String identifier) {
        switchClassLoader();
        Value value = context.getBindings("js").getMember(identifier);
        switchClassLoader();
        return value;
    }

    public boolean removeMember(String identifier) {
        switchClassLoader();
        boolean res = context.getBindings("js").removeMember(identifier);
        switchClassLoader();
        return res;
    }

    public void putMember(String identifier, Object value) {
        switchClassLoader();
        context.getBindings("js").putMember(identifier, value);
        switchClassLoader();
    }

    public Set<String> getMembers() {
        switchClassLoader();
        Set<String> keys = context.getBindings("js").getMemberKeys();
        switchClassLoader();
        return keys;
    }

    public Value execute() {
        return context.eval(source);
    }

    public Value execute(File file) throws IOException {
        switchClassLoader();
        Source tempSource = Source.newBuilder("js", file).build();
        Value res = context.eval(tempSource);
        switchClassLoader();
        return res;
    }

    public Value execute(String code) throws IOException {
        switchClassLoader();
        Source tempSource = Source.newBuilder("js", code, null).build();
        Value res = context.eval(tempSource);
        switchClassLoader();
        return res;
    }

    public Value getBindings() {
        switchClassLoader();
        Value bindings = context.getBindings("js");
        switchClassLoader();
        return bindings;
    }

    public void close() {
        switchClassLoader();
        context.close();
        switchClassLoader();
    }

    private void switchClassLoader() {
        if (currentClassLoaderIsThread) {
            Thread.currentThread().setContextClassLoader(graalClassLoader);
        } else {
            Thread.currentThread().setContextClassLoader(threadClassLoader);
        }
    }

    public static void loadLibs(Plugin plugin) {
        // plugin.getClass().getResourceAsStream(name)
    }
}
