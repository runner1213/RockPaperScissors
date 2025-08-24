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
        bindKeyToButton("1", list.rock);
        bindKeyToButton("2", list.scissors);
        bindKeyToButton("3", list.paper);
    }

    private void bindKeyToButton(String key, JButton button) {
        inputMap.put(KeyStroke.getKeyStroke(key), key);
        actionMap.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
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
