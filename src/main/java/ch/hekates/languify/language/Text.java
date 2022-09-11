package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Map;

public class Text {

    /**
     * This string returns the requested string + prefix by following the path in the active language file.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
     * @param usePrefix If you have set a prefix but don't want to use it for this string set it to false. If you  want to use the set prefix leave this blank or set this to true.
     * @throws IOException
     * @see Languify#setLanguage(String)
     */
    public static String get(String path, Boolean usePrefix) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        if (Languify.getPrefix() == null || usePrefix == false) {
            return (String) langMap.get(path);
        } else {
            return (String) Languify.getPrefix() + " " + langMap.get(path);
        }
    }
    /**
     * This string returns the requested string + the prefix by following the path in the active language file.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
     * @throws IOException
     * @see Languify#setLanguage(String)
     */
    public static String get(String path) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        if (Languify.getPrefix() == null) {
            return (String) langMap.get(path);
        } else {
            return (String) Languify.getPrefix() + " " + langMap.get(path);
        }
    }

    public Text() throws IOException {
    }
}
