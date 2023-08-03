package com.curling.statistic;

public class GameStats {
    private Position position;
    private Score score;
    private Turn turn;

    public String name() {
        return position.name() + score.name() + turn.name();
    }

    public int score() {
        return score.getScore();
    }

    public int turn() {
        int turn_1;
        int turn_2;
        int turn_3;
        int turn_4;

        return 0;
    }

    public int position() {
        int position_1;
        int position_2;
        int position_3;
        int position_4;
        return 0;
    }
}
