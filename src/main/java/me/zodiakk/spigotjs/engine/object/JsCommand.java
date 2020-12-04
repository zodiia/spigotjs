package me.zodiakk.spigotjs.engine.object;

public interface JsCommand extends ApiElement {
    public String getCommandName();
    public void register();
    public void unregister();
    public void onCommand(JsPlayer player, String[] arguments);
}
