package ru.runner1213.ui;

import ru.runner1213.logic.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static ru.runner1213.logic.Actions.reset;

public class KeyBindings {
    JPanel panel;
    Actions list;

    private final InputMap inputMap;
    private final ActionMap actionMap;

    protected KeyBindings(JPanel panel, Actions list) {
        this.panel = panel;
        this.list = list;

        inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = panel.getActionMap();
    }
    protected void setupButtonSelection() {

        inputMap.put(KeyStroke.getKeyStroke("1"), "rock");
        actionMap.put("rock", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                list.rock.doClick();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("2"), "scissors");
        actionMap.put("scissors", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                list.scissors.doClick();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("3"), "paper");
        actionMap.put("paper", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                list.paper.doClick();
            }
        });
    }
    protected void setupBindReset() {
        inputMap.put(KeyStroke.getKeyStroke("R"), "reset");
        actionMap.put("reset", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset.doClick();
            }
        });
    }
}
