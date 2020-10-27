package me.zodiakk.spigotjs.engine;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public class JavascriptContext {
    private Source source;
    private Context context;
    private ClassLoader threadClassLoader;
    private ClassLoader graalClassLoader;
    private boolean currentClassLoaderIsThread = true;

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

    public void setScript(Script script) throws IOException {
        switchClassLoader();
        context.getBindings("js").putMember("___spigotjs", script.getLinker());
        execute("const ___require = require;" +
                "require = function(path) {" +
                "    if (path == 'spigotjs') {" +
                "        return ___spigotjs;" +
                "    }" +
                "    return ___require(path);" +
                "}");
        switchClassLoader();
    }

    public void loadFile(File file) throws IOException {
        switchClassLoader();
        source = Source.newBuilder("js", file).build();
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
}
