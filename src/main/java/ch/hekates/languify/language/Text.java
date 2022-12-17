package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Text {

    /**
     * This string returns the requested string + prefix by following the path in the active language file.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
     * @param usePrefix If you have set a prefix but don't want to use it for this string set it to false. If you  want to use the set prefix leave this blank or set this to true.
     * @see Languify#setLanguage(String)
     */
    public static String get(String path, Boolean usePrefix) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        if (Languify.getPrefix() == null || !usePrefix) {
            return (String) langMap.get(path);
        } else {
            return (String) Languify.getPrefix() + " " + langMap.get(path);
        }
    }

    /**
     * This string returns the requested string + prefix by following the path in the active language file.
     * The in the hashmap specified strings get replaced by its values.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
     * @param replacements A map of keys and replacements to dynamically replace elements of the string.
     * @param usePrefix If you have set a prefix but don't want to use it for this string set it to false. If you  want to use the set prefix leave this blank or set this to true.
     * @see Languify#setLanguage(String)
     */
    public static String get(String path,HashMap<String, String> replacements, Boolean usePrefix) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        if (Languify.getPrefix() == null || !usePrefix) {
            return fromReplacements((String) langMap.get(path), replacements);
        } else {
            return fromReplacements(Languify.getPrefix() + " " + langMap.get(path), replacements);
        }
    }
    /**
     * This string returns the requested string + the prefix by following the path in the active language file.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
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
            return Languify.getPrefix() + " " + langMap.get(path);
        }
    }
    /**
     * This string returns the requested string + the prefix by following the path in the active language file.
     * The in the hashmap specified strings get replaced by its values.
     * @return The requested string by following the path.
     * @param path The path to the requested string in the language.json file. Example: "command.error.no_player"
     * @param replacements A map of keys and replacements to dynamically replace elements of the string.
     * @see Languify#setLanguage(String)
     */
    public static String get(String path, HashMap<String, ?> replacements) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        if (Languify.getPrefix() == null) {
            return fromReplacements((String) langMap.get(path), (HashMap<String, String>) replacements);
        } else {
            return fromReplacements(Languify.getPrefix() + " " + langMap.get(path), (HashMap<String, String>) replacements);
        }
    }

    private static String fromReplacements(String text, HashMap<String, String> replacements){
        String finalString = text;
        String[] keys = (String[]) replacements.keySet().toArray();

        for (String key : keys) {
            finalString = finalString.replaceAll(key, replacements.get(key));
        }

        return finalString;

    }
}
