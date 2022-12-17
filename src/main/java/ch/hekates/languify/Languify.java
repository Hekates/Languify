package ch.hekates.languify;

import ch.hekates.languify.language.Text;
import org.bukkit.plugin.Plugin;

public final class Languify{

    private static String language;
    private static Plugin plugin;
    private static String fileDirectory;
    private static String prefix;

    /**
     * @return (if set) the prefix passed with the setup() or the setPrefix() method.
     * @see Languify#setup(Plugin, String, String)
     * @see Languify#setPrefix(String)
     */
    public static String getPrefix() { return prefix; }

    /**
     * Sets the prefix used by the plugin using Languify. The prefix gets added at the start of any text which is output by Languify. The prefix can be deactivated manually with each text request. It can also be optionally set in the setup method.
     * @param prefix The prefix of the plugin using the Languify library.
     * @see Languify#setup(Plugin, String, String)
     * @see Languify#getPrefix()
     * @see Text#get(String, Boolean)
     */
    public static void setPrefix(String prefix) { Languify.prefix = prefix; }

    /**
     * @return The language abbreviation passed in by the Languify#setLanguage() method.
     * @see Languify#setLanguage(String)
     */
    public static String getLanguage() {
        return language;
    }

    /**
     * Sets the language file name where texts will be taken from. For example: The language of the language file is German, but the name of the language file is de, so "de" is passed in.
     * @param language The language file name without the file ending .json.
     * @see Languify#getLanguage()
     */
    public static void setLanguage(String language) {
        Languify.language = language;
    }

    /**
     * @return The plugin instance passed in using the Languify#setPlugin() or the Languify#setup() methods
     * @see Languify#setPlugin(Plugin)
     * @see Languify#setup(Plugin, String, String)
     * @see Plugin
     */
    public static Plugin getPlugin() {
        return plugin;
    }

    /**
     * Sets the plugin instance which will be used by Languify to run tasks like logging. This is already done if the setup method got called.
     * @param plugin The plugin instance of the plugin using the Languify library.
     * @see Languify#getPlugin()
     * @see Languify#setup(Plugin, String, String)
     * @see Plugin
     */
    public static void setPlugin(Plugin plugin) {
        Languify.plugin = plugin;
    }

    /**
     * @return The filedirectory passed in by the Languify#setFileDirectory() or the Languify#setup() method.
     * @see Languify#setFileDirectory(String)
     * @see Languify#setup(Plugin, String)
     */
    public static String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * Sets the filedirectory where the language-files should be stored. In this diretory a folder will be created in which te language files are stored. I would recommend using the plugin root-directory. This is already done if the setup method got called.
     * @param fileDirectory The file directory where the language folder should be generated.
     */
    public static void setFileDirectory(String fileDirectory) {
        Languify.fileDirectory = fileDirectory;
    }


    /**
     * Sets up the Languify library by setting importnt variables
     * such as the plugin instance and the filedirectroy.
     * A prefix can be set optionally.
     * @param plugin The instance of the plugin using the Languify library.
     * @param directory The filedirectory where the language-files should be stored. In this diretory a folder will be created in which te language files are stored. I would recommend using the plugin root-directory.
     * */
    public static void setup(Plugin plugin, String directory) {
        Languify.setPlugin(plugin);
        Languify.setFileDirectory(directory);
    }

    /**
     * Sets up the Languify library by setting importnt variables
     * such as the plugin instance and the filedirectroy.
     * A prefix can be set optionally.
     * @param plugin The instance of the plugin using the Languify library.
     * @param directory The filedirectory where the language-files should be stored. In this diretory a folder will be created in which te language files are stored. I would recommend using the plugin root-directory.
     * @param prefix The prefix used by the plugin using Languify. The prefix gets added at the start of any text which is output by Languify. The prefix can be deactivated manually with each text request.
     */
    public static void setup(Plugin plugin, String directory, String prefix){
        Languify.setPlugin(plugin);
        Languify.setFileDirectory(directory);
        Languify.setPrefix(prefix);
    }
}
