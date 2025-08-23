package ru.runner1213.ui;

import ru.runner1213.logic.Actions;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public JLabel score = new JLabel();
    public Window(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);

        Actions list = new Actions(this);

        ButtonPanel buttonPanel = new ButtonPanel(list.rock, list.scissors, list.paper);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(score, BorderLayout.WEST);
        bottomPanel.add(Actions.reset, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        KeyBindings keyBindings = new KeyBindings(buttonPanel, list);
        keyBindings.setupButtonSelection();
        keyBindings.setupBindReset();

        updateScore(Actions.score.getUserScore(), Actions.score.getComputerScore());
    }

    public void updateScore(int userScore, int computerScore) {
        score.setText("Вы: " + userScore + " | Компьютер: " + computerScore);
    }


}
