package com.example.geektrust.service;

import com.example.geektrust.Model.Train;

import java.util.List;

public interface TrainService {
    Train getHYBArrival(String trainName,List<String> train_a);
    Train getHYBDeparture(Train trainA, Train trainB);
}
