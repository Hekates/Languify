package ch.hekates.languify.language;

import ch.hekates.languify.Languify;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LangLoader {
    /**
     * Sets the specified language.
     * @param language
     * @deprecated Use {@link Languify#setLanguage} instead.
     */
    @Deprecated
    public static void loadLanguage(String language) {
        Languify.setLanguage(language);
    }

    /**
     * Saves the language files from the jar into the plugins folder.
     * @param pluginName The name of the plugin (as specified in the plugin.yml). Used to locate the plugin folder.
     * @see Languify#setOverWriteFiles(boolean)
     * @deprecated Probably useless for most use cases. Use {@link #saveLanguages(String)} and append the version to the plugin name.
     */
    @Deprecated
    public static void saveLanguages(String pluginName, @Deprecated String version) {
        File targetDirectory = new File("plugins/" + pluginName);
        String jarFilePath = "plugins/" + pluginName + version + ".jar";

        try (ZipFile jarFile = new ZipFile(jarFilePath)) {
            for (ZipEntry entry : Collections.list(jarFile.entries())) {
                if (entry.getName().startsWith("lang/") && !entry.isDirectory()) {
                    String targetFilePath = targetDirectory.getPath() + "/" + entry.getName();

                    File targetFile = new File(targetFilePath);
                    targetFile.getParentFile().mkdirs();

                    try (InputStream inputStream = jarFile.getInputStream(entry)) {
                        if (Languify.getOverWriteFiles()) {
                            Files.copy(inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } else {
                            Files.copy(inputStream, targetFile.toPath());
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves the language files from the jar into the plugins folder.
     * @param pluginName The name of the plugin (as specified in the plugin.yml). Used to locate the plugin folder.
     * @see Languify#setOverWriteFiles(boolean)
     */
    public static void saveLanguages(String pluginName) {
        File targetDirectory = new File("plugins/" + pluginName);
        String jarFilePath = "plugins/" + pluginName + ".jar";

        try (ZipFile jarFile = new ZipFile(jarFilePath)) {
            for (ZipEntry entry : Collections.list(jarFile.entries())) {
                if (entry.getName().startsWith("lang/") && !entry.isDirectory()) {
                    String targetFilePath = targetDirectory.getPath() + "/" + entry.getName();

                    File targetFile = new File(targetFilePath);
                    targetFile.getParentFile().mkdirs();

                    try (InputStream inputStream = jarFile.getInputStream(entry)) {
                        if (Languify.getOverWriteFiles()) {
                            Files.copy(inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } else {
                            Files.copy(inputStream, targetFile.toPath());
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
