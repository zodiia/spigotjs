package me.zodiakk.spigotjs.util;

public enum McVersion {
    MC1_7(false, 0),
    MC1_8(false, 1),
    MC1_9(false, 2),
    MC1_10(false, 3),
    MC1_11(false, 4),
    MC1_12(false, 5),
    MC1_13(false, 6),
    MC1_14(false, 7),
    MC1_15(false, 8),
    MC1_16(true, 9),
    MC1_17(false, 10),
    MC1_18(false, 11),
    MC1_19(false, 12);

    private boolean supported;
    private int order;

    private McVersion(boolean supported, int order) {
        this.supported = supported;
        this.order = order;
    }

    public boolean isSupported() {
        return supported;
    }

    public static McVersion current() {
        // TODO:
        return MC1_16;
    }

    public boolean isOlderThan(McVersion version) {
        return order < version.order;
    }

    public static McVersion fromString(String value) {
        return valueOf("MC" + value.split("\\.")[0] + "_" + value.split("\\.")[1]);
    }
}
