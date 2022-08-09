package ch.hekates.languify.language;

import ch.hekates.languify.Languify;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Map;

public class Text {

    public static String get(String path) throws IOException {
        String language = Languify.getLanguage();

        Gson gson = new Gson();
        File file = new File(Languify.getFileDirectory() + "/lang/" + language + ".json");

        Reader reader = Files.newBufferedReader(file.toPath());

        Map<?, ?> langMap = gson.fromJson(reader, Map.class);

        return (String) langMap.get(path);
    }

    public Text() throws IOException {
    }
}
