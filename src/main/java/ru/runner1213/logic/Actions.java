package ru.runner1213.logic;

import ru.runner1213.score.Data;
import ru.runner1213.score.Load;
import ru.runner1213.score.Save;
import ru.runner1213.ui.Window;

import javax.swing.*;

public class Actions {
    public JButton rock = new JButton("Камень");
    public JButton scissors = new JButton("Ножницы");
    public JButton paper = new JButton("Бумага");
    private char selection;
    private final Window window;

    public static JButton reset = new JButton("Сбросить счёт");
    private static final String FILE_NAME = "score.json";

    public static Data score = Load.load(FILE_NAME);

    public Actions(Window window) {
        this.window = window;

        rock.addActionListener(e -> handleChoice('К'));
        scissors.addActionListener(e -> handleChoice('Н'));
        paper.addActionListener(e -> handleChoice('Б'));
        reset.addActionListener(e -> resetScore());
    }

    private void resetScore() {
        int result = JOptionPane.showConfirmDialog(window, "Вы точно хотите сбросить счёт?", "Сброс", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Save.reset(FILE_NAME);
            window.updateScore(0, 0);
            JOptionPane.showMessageDialog(window, "Счёт успешно сброшен!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void handleChoice(char selection) {
        this.selection = selection;

        Select select = new Select(selection);
        char computerChoice = select.getComputerChoice();
        boolean win = select.win();

        if (win) {
            JOptionPane.showMessageDialog(window, "Вы выиграли! Компьютер выбрал " + getComputerChoice(computerChoice) + " !\n" + printUserChoice(), "Результат", JOptionPane.INFORMATION_MESSAGE);
            score.setUserScore(score.getUserScore() + 1);
        } else if (computerChoice == selection) {
            JOptionPane.showMessageDialog(window, "Ничья. Компьютер выбрал " + getComputerChoice(computerChoice) + " и " + printUserChoice().toLowerCase());
        } else {
            score.setComputerScore(score.getComputerScore() + 1);
            JOptionPane.showMessageDialog(window, "Вы проиграли! Компьютер выбрал " + getComputerChoice(computerChoice) + " !\n" + printUserChoice(), "Результат", JOptionPane.WARNING_MESSAGE);
        }
        window.updateScore(score.getUserScore(), score.getComputerScore());
        Save.save(FILE_NAME, score);
    }

    private String printUserChoice() {
        return "Вы выбрали " + getUserChoice() + ".";
    }

    private String getComputerChoice(char computerChoice) {
        return computerChoice == 'К' ? "камень" :
                computerChoice == 'Н' ? "ножницы" :
                        computerChoice == 'Б' ? "бумага" :
                                "Неизвестно";
    }

    private String getUserChoice() {
        char userChoice = selection;
        return userChoice == 'К' ? "камень" :
                userChoice == 'Н' ? "ножницы" :
                        userChoice == 'Б' ? "бумага" :
                                "Неизвестно";
    }
}
