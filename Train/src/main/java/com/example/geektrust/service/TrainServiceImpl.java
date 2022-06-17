package com.example.geektrust.service;

import com.example.geektrust.Model.Bogie;
import com.example.geektrust.Model.Train;
import com.example.geektrust.repository.StationDistanceRepo;
import static com.example.geektrust.util.Constants.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrainServiceImpl implements TrainService{

    @Override
    public Train getHYBArrival(String trainName, List<String> trains) {
        //Remove trainName and  engine
        trains.remove(INDEX);
        trains.remove(INDEX);

        //Create train for train <trainName>
        Train train = createTrain(trainName,trains);

        //Remove bogie from list of bogies when train arrives at HYB
        train.getBogies().removeAll(
                train.getBogies().stream().filter(bogie -> bogie.getDistanceFromHYB()< INDEX).collect(Collectors.toList()));

        //Return train
        return train;
    }

    @Override
    public Train getHYBDeparture(Train trainA, Train trainB) {
        final Comparator<Bogie> comparator = Comparator.comparingInt(Bogie::getDistanceFromHYB);
        final Train trainAB = new Train();
        final List<Bogie> bogiesAB = new ArrayList<>();
        final Predicate<Bogie> bogiePredicate = bogie -> !bogie.getStationCode().equals(STATION_CODE_HYB);
        //Sort each train bogies wrt distance from HYB

        List<Bogie> sortedA = trainA.getBogies().stream().sorted(
                comparator.reversed()).filter(bogiePredicate).collect(Collectors.toList());

        List<Bogie> sortedB =trainB.getBogies().stream().sorted(
                comparator.reversed()).filter(bogiePredicate).collect(Collectors.toList());

        // Merge trainA and train B such that result train trainAB's bogies are also arranged in desc order wrt distance from HYB
        bogiesAB.addAll(sortedA);
        bogiesAB.addAll(sortedB);
        trainAB.setBogies(
                bogiesAB.stream().sorted(comparator.reversed()).collect(Collectors.toList()));

        //Return trainAB
        return trainAB;
    }

    private Train createTrain(String trainName, List<String> input){
        Train train = new Train();
        List<Bogie> bogies = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String station : input) {
            if(TRAIN_A_NAME.equals(trainName)) {
                map = StationDistanceRepo.getChnToNdl();
                if(!StationDistanceRepo.getChnToNdl().containsKey(station)) {
                    map = StationDistanceRepo.getTvcToGhy();
                }
            } else  {
                map = StationDistanceRepo.getTvcToGhy();
                if(!StationDistanceRepo.getTvcToGhy().containsKey(station)) {
                    map = StationDistanceRepo.getChnToNdl();
                }
            }
            bogies.add(createBogie(station,map.get(station),map.get(STATION_CODE_HYB)));
        }

        train.setBogies(bogies);
        return train;
    }

    private Bogie createBogie(String stationCode, int stationDistance, int hybDistance){
        Bogie bogie = new Bogie();
        bogie.setStationCode(stationCode);
        bogie.setDistanceFromHYB(stationDistance-hybDistance);
        return bogie;
    }


}
