package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LangLoader {
    /**
     * This method loads the set language by checking if the file already exists. If not, it clones the file out of the plugin jar file into the language folder.
     * @param language The language file name without the file ending .json.
     * @see Languify#setFileDirectory(String)
     */
    public static void loadLanguage(String language) {

        Languify.setLanguage(language);

        Plugin plugin = Languify.getPlugin();

        String path = Languify.getFileDirectory();

        Logger log = plugin.getLogger();

        File file = new File(path + "/lang/" + language + ".json");

        if (file.exists()) {
            log.info("The specified language file is located in the right directory... proceeding.");
            plugin.saveResource("lang\\" + language + ".json", true);
            for (File languageFile : plugin.getDataFolder().listFiles()) {
                plugin.saveResource("lang/" + languageFile.getName(), true);
            }
        } else {
            log.warning("The specified language file is not located in the right directory... generating a new one.");
            plugin.saveResource("lang\\" + language + ".json", true);
            for (File languageFile : plugin.getDataFolder().listFiles()) {
                plugin.saveResource("lang/" + languageFile.getName(), true);
            }
        }
    }
}
