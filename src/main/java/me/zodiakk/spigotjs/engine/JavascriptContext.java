package me.zodiakk.spigotjs.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import me.zodiakk.spigotjs.SpigotJs;
import me.zodiakk.spigotjs.SpigotJsApi;
import me.zodiakk.spigotjs.engine.script.Script;
import me.zodiakk.spigotjs.i18n.I18nLanguage;

public class JavascriptContext {
    private static final Map<String, Source> REQUIRE_PATH = new HashMap<String, Source>();
    private static I18nLanguage i18n = null;

    private Source source;
    private Context context;
    private ClassLoader threadClassLoader;
    private ClassLoader graalClassLoader;
    private boolean currentClassLoaderIsThread = true;
    private Script script;
    private File file;

    {
        if (i18n == null) {
            i18n = SpigotJsApi.getInstance().getI18n().getCurrentLanguage();
        }
    }

    public JavascriptContext() throws IOException {
        threadClassLoader = Thread.currentThread().getContextClassLoader();
        graalClassLoader = getClass().getClassLoader();
        file = null;
        switchClassLoader();
        context = Context.newBuilder("js").allowAllAccess(true).engine(SpigotJsApi.getInstance().getPolyglotEngine()).build();
        addBaseObjects();
        switchClassLoader();
    }

    public JavascriptContext(File file) throws IOException {
        this();
        loadFile(file);
        this.file = file;
    }

    public JavascriptContext(URL url) throws IOException, URISyntaxException {
        this();
        loadFile(url);
        try {
            file = new File(url.toURI());
        } catch (IllegalArgumentException ex) {
            // Do nothing as the URL may not lead to a file
        }
    }

    public void setScript(Script script) throws IOException {
        switchClassLoader();
        this.script = script;
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

    private void addBaseObjects() throws IOException {
        Function<String, Object> require = (id) -> {
            if (script != null && id.equals("spigotjs")) {
                return this.script.getLinker();
            }
            if (REQUIRE_PATH.containsKey(id)) {
                return context.eval(REQUIRE_PATH.get(id)).execute();
            }
            if (id.startsWith("./")) {
                if (!SpigotJs.getInstance().getSpigotJsConfig().getEnableExperimentalFeatures()) {
                    Bukkit.getLogger().warning(i18n.get("script.error.experimentalFeature",
                            script == null ? "(unknown)" : script.getDescription().toShortString(),
                            "local file imports"));
                }

                File importedFile;

                if (file == null || file.getParentFile() == null) {
                    importedFile = new File(SpigotJs.getInstance().getDataFolder(), id);
                } else {
                    importedFile = new File(file.getParentFile(), id);
                }

                Bukkit.getLogger().info(importedFile.getAbsolutePath());
                if (importedFile.exists()) {
                    try {
                        StringBuilder code = new StringBuilder();
                        Source source;

                        code.append("(() => { const module = { exports: null };\n");
                        code.append(readFile(importedFile));
                        code.append("; return module.exports; });");
                        source = Source.newBuilder("js", code.toString(), null).build();
                        Bukkit.getLogger().info(source.getCharacters().toString());
                        return context.eval(source).execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return context.eval("js", "{}");
                    }
                }
            }
            return null;
        };
        context.getBindings("js").putMember("require", require);
    }

    private String readFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        StringBuilder contents = new StringBuilder();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            contents.append(line);
        }
        reader.close();
        fileReader.close();
        return contents.toString();
    }

    public static void loadLibs(Plugin plugin) {
        // Load libraries
    }
}
