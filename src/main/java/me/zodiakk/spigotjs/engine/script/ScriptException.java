package me.zodiakk.spigotjs.engine.script;

public class ScriptException extends RuntimeException {
    private static final long serialVersionUID = 211356733537399068L;
    private Script script;

    public ScriptException(Script script, Throwable cause) {
        super("Unhandled exception in script " + script.getDescription().toShortString(), cause);
        this.script = script;
    }

    public Script getScript() {
        return script;
    }
}
