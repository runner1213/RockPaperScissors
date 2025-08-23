package ru.runner1213.score;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void save(String filename, Data scoreData) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(scoreData, writer);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void reset(String filename) {
        save(filename, new Data(0, 0));
    }
}
