package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LangLoader {
    /**
     * This method loads the set language by checking if the file already exists. If not, it clones the file out of the plugin jar file into the language folder.
     *
     * @param language The language file name without the file ending .json.
     * @see Languify#setFileDirectory(String)
     */
    private static final Plugin plugin = Languify.getPlugin();

    public static void loadLanguage(String language) {
        Languify.setLanguage(language);
    }

    public static void saveLanguages(String pluginName, String version) {
        File targetDirectory = new File("plugins/" + pluginName);
        String jarFilePath = "plugins/" + pluginName + version + ".jar";

        try (ZipFile jarFile = new ZipFile(jarFilePath)) {
            for (ZipEntry entry : Collections.list(jarFile.entries())) {
                if (entry.getName().startsWith("lang/") && !entry.isDirectory()) {
                    String targetFilePath = targetDirectory.getPath() + "/" + entry.getName();

                    File targetFile = new File(targetFilePath);
                    targetFile.getParentFile().mkdirs();

                    try (InputStream inputStream = jarFile.getInputStream(entry)) {
                        Files.copy(inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
