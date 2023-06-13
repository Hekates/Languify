package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import com.sun.tools.javac.Main;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

public class LangLoader {
    /**
     * This method loads the set language by checking if the file already exists. If not, it clones the file out of the plugin jar file into the language folder.
     * @param language The language file name without the file ending .json.
     * @see Languify#setFileDirectory(String)
     */
    public static void loadLanguage(String language) {
        Languify.setLanguage(language);
    }

    public static void saveLanguages(){
        Plugin plugin = Languify.getPlugin();

        File langFolder = new File(plugin.getDataFolder(), "lang");
        File[] files = langFolder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                plugin.saveResource("lang/" + file.getName(), true);
            }
        }
    }
}
