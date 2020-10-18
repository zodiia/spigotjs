package me.zodiakk.spigotjs.config;

/**
 * Represents a version string.
 *
 * @author Zodiak
 * @since 4.1
 */
public class Version implements Comparable<Version> {
    private final String version;

    /**
     * Create a new version from its String.
     * @param version Version string
     */
    public Version(String version) {
        this.version = version;
    }

    /**
     * Get the version string.
     * @return The version string
     */
    public final String getVersionString() {
        return this.version;
    }

    /**
     * Compare this version to another one lexicographically.
     * @see String#compareTo(String)
     * @param version Version to compare to
     * @return Returns a negative number if the provided version is newer, a positive number if the current version is newer, and 0 if they are equivalent.
     */
    @Override
    public int compareTo(Version version) {
        if (version == null) {
            return 1;
        }
        String[] actualParts = this.version.split("\\.");
        String[] newParts = version.getVersionString().split("\\.");
        int length = Math.max(actualParts.length, newParts.length);

        for (int i = 0; i < length; i++) {
            if (actualParts.length <= i) {
                return -1;
            } else if (newParts.length <= i) {
                return 1;
            }

            int res = actualParts[i].compareTo(newParts[i]);

            if (res != 0) {
                return res;
            }
        }
        return 0;
    }
}
