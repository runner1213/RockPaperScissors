package ru.runner1213.score;

public class Data {
    private int userScore;
    private int computerScore;

    public Data(int userScore, int computerScore) {
        this.userScore = userScore;
        this.computerScore = computerScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }
}
