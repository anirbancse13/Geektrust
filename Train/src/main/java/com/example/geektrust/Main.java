package com.example.geektrust;

import com.example.geektrust.controller.TrainController;
import com.example.geektrust.util.Utility;

import java.io.IOException;

import static com.example.geektrust.util.Constants.INDEX;

public class Main {
    public static void main(String[] args) {
        TrainController controller = new TrainController();
        try {
            controller.showTrains(Utility.parseInputFile(args[INDEX]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
