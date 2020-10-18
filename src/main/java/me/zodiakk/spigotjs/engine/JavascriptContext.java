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

    public JavascriptContext() {
        context = Context.newBuilder("js").allowAllAccess(true).allowExperimentalOptions(true).build();
    }

    public JavascriptContext(File file) throws IOException {
        this();
        loadFile(file);
    }

    public void loadFile(File file) throws IOException {
        source = Source.newBuilder("js", file).build();
    }

    public Value getMember(String identifier) {
        return context.getBindings("js").getMember(identifier);
    }

    public boolean removeMember(String identifier) {
        return context.getBindings("js").removeMember(identifier);
    }

    public void putMember(String identifier, Object value) {
        context.getBindings("js").putMember(identifier, value);
    }

    public Set<String> getMembers() {
        return context.getBindings("js").getMemberKeys();
    }

    public Value execute() {
        return context.eval(source);
    }

    public Value execute(File file) throws IOException {
        Source tempSource = Source.newBuilder("js", file).build();

        return context.eval(tempSource);
    }

    public Value getBindings() {
        return context.getBindings("js");
    }

    public void close() {
        context.close();
    }
}
