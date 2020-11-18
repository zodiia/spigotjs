package me.zodiakk.spigotjs.engine.object;

public interface ApiElement {
    public <T extends Object> T java(Class<T> clazz);
}
