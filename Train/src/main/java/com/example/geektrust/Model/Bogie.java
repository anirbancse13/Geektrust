package com.example.geektrust.Model;

import java.util.Objects;

public class Bogie {
    private String stationCode;
    private int distanceFromHYB;

    public Bogie() {

    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public int getDistanceFromHYB() {
        return distanceFromHYB;
    }

    public void setDistanceFromHYB(int distanceFromHYB) {
        this.distanceFromHYB = distanceFromHYB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bogie)) return false;
        Bogie bogie = (Bogie) o;
        return getDistanceFromHYB() == bogie.getDistanceFromHYB() && Objects.equals(getStationCode(), bogie.getStationCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStationCode(), getDistanceFromHYB());
    }

    @Override
    public String toString() {
        return stationCode;
    }
}
