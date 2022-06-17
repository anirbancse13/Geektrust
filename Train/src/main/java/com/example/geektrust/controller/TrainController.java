package com.example.geektrust.controller;

import com.example.geektrust.Model.Train;
import com.example.geektrust.service.TrainService;
import com.example.geektrust.service.TrainServiceImpl;
import static com.example.geektrust.util.Constants.*;

import java.util.List;
import java.util.Map;

public class TrainController {
    private final TrainService service = new TrainServiceImpl();

    public void showTrains(Map<String, List<String>> inputMap) {
        Train trainA = service.getHYBArrival(TRAIN_A_NAME,inputMap.get(TRAIN_A_NAME));
        Train trainB = service.getHYBArrival(TRAIN_B_NAME,inputMap.get(TRAIN_B_NAME));
        Train trainAB = service.getHYBDeparture(trainA, trainB);

        System.out.println(ARRIVAL + TRAIN_A_NAME + ENGINE + trainA);
        System.out.println(ARRIVAL + TRAIN_B_NAME + ENGINE + trainB);
        System.out.println(!trainAB.getBogies().isEmpty() ? DEPARTURE_TRAIN_AB_ENGINE_ENGINE + trainAB : JOURNEY_ENDED);
    }
}
