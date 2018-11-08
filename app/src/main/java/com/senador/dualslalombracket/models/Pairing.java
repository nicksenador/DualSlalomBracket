package com.senador.dualslalombracket.models;

import java.util.Objects;

/**
 * Class that represents a matching with two riders. Riders get a run on both slalom lanes.
 * The winner is the rider with the lowest time of both runs.
 */
public class Pairing {

    public enum Winner {
        HIGHSEED, LOWSEED
    }

    private Rider highSeed;
    private Rider lowSeed;
    private int firstRunTimeSplit;
    private Rider firstRunWinner;
    private Rider winner;

    public Pairing(Rider highSeed, Rider lowSeed) {
        this.highSeed = highSeed;
        this.lowSeed = lowSeed;
    }

    public Rider getHighSeed() {
        return highSeed;
    }

    public Rider getLowSeed() {
        return lowSeed;
    }

    public int getFirstRunTimeSplit() {
        return firstRunTimeSplit;
    }

    public void setFirstRunTimeSplit(int firstRunTimeSplit) {
        this.firstRunTimeSplit = firstRunTimeSplit;
    }

    public Rider getFirstRunWinner() {
        return firstRunWinner;
    }

    public void setFirstRunWinner(Winner firstRunWinner) {
        if (firstRunWinner.equals(Winner.HIGHSEED)) {
            this.firstRunWinner = highSeed;
        } else {
            this.firstRunWinner = lowSeed;
        }
    }

    public Rider getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        if (winner.equals(Winner.HIGHSEED)) {
            this.winner = highSeed;
        } else {
            this.winner = lowSeed;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pairing)) return false;
        Pairing pairing = (Pairing) o;
        return firstRunTimeSplit == pairing.firstRunTimeSplit &&
                Objects.equals(highSeed, pairing.highSeed) &&
                Objects.equals(lowSeed, pairing.lowSeed) &&
                Objects.equals(firstRunWinner, pairing.firstRunWinner) &&
                Objects.equals(winner, pairing.winner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(highSeed, lowSeed, firstRunTimeSplit, firstRunWinner, winner);
    }
}
