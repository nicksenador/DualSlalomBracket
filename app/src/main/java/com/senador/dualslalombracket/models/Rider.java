package com.senador.dualslalombracket.models;

import java.util.Objects;

public class Rider implements Comparable<Rider> {

    private int plateNumber;
    private double qualifyingTime;

    public Rider(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setQualifyingTime(double qualifyingTime) {
        this.qualifyingTime = qualifyingTime;
    }

    @Override
    public int compareTo(Rider that) {
        return Double.compare(this.qualifyingTime, that.qualifyingTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rider)) return false;
        Rider rider = (Rider) o;
        return plateNumber == rider.plateNumber &&
                Double.compare(rider.qualifyingTime, qualifyingTime) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(plateNumber, qualifyingTime);
    }
}
