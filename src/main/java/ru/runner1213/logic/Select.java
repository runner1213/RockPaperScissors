package ru.runner1213.logic;

import java.util.Random;

public class Select {
    char[] choices = {'К', 'Н', 'Б'}; // К = Камень и т.д.
    char selection;
    char computerChoice;

    protected Select(char selection) {
        this.selection = selection;
        this.computerChoice = generateComputerChoice();
    }

    private char generateComputerChoice() {
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    protected char getComputerChoice() {
        return computerChoice;
    }

    public boolean win() {
        return isBeats();
    }

    private boolean isBeats() {
        if (selection == computerChoice) {
            return false; // ничья → игрок НЕ победил
        }

        return switch (selection) {
            case 'К' -> computerChoice == 'Н'; // Камень бьёт ножницы
            case 'Н' -> computerChoice == 'Б'; // Ножницы бьют бумагу
            case 'Б' -> computerChoice == 'К'; // Бумага бьёт камень
            default -> false;
        };

    }
}
