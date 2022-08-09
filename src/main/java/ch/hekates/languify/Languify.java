package ch.hekates.languify;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Languify extends JavaPlugin {

    private static String language;
    private static Plugin plugin;
    private static String fileDirectory;

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        Languify.language = language;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(Plugin plugin) {
        Languify.plugin = plugin;
    }

    public static String getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(String fileDirectory) {
        Languify.fileDirectory = fileDirectory;
    }

    public static void setup(Plugin plugin, String directory) {
        Languify.setPlugin(plugin);
        Languify.setFileDirectory(directory);
    }
}
