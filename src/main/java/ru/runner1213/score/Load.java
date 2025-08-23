package ru.runner1213.score;

import java.io.FileReader;
import java.io.IOException;

import static ru.runner1213.score.Save.gson;

public class Load {
    public static Data load(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Data.class);
        } catch (IOException e) {
            return new Data(0, 0);
        }
    }
}
