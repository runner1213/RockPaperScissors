package ru.runner1213.ui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel(JButton rock, JButton scissors, JButton paper) {
        setLayout(new GridLayout(1, 3, 10, 10));

        add(rock);
        add(scissors);
        add(paper);

        setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
    }
}
