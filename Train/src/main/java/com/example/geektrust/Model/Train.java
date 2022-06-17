package com.example.geektrust.Model;

import static com.example.geektrust.util.Constants.BEGIN_INDEX;

import java.util.List;
import java.util.Objects;

public class Train {
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";
    private List<Bogie> bogies;

    public Train() {

    }

    public List<Bogie> getBogies() {
        return bogies;
    }

    public void setBogies(List<Bogie> bogies) {
        this.bogies = bogies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return getBogies().equals(train.getBogies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBogies());
    }

    @Override
    public String toString() {
        String result = bogies.toString();
        return result.substring(BEGIN_INDEX,result.length()- BEGIN_INDEX).replace(COMMA, EMPTY_STRING);
    }
}
