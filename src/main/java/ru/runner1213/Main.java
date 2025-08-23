package ru.runner1213;

import ru.runner1213.ui.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window("Камень ножницы бумага").setVisible(true));
    }
}