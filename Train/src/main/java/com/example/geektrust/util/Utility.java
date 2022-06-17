package com.example.geektrust.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.example.geektrust.util.Constants.*;

public class Utility {


    public static Map<String, List<String>> parseInputFile(String input) throws FileNotFoundException {
        Map<String, List<String>> inputMap = new HashMap<>();
        FileInputStream fis = new FileInputStream(input);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            List<String> trainDetails = new ArrayList<>(Arrays.asList((line.split(SPACE))));

            //extract first word of the line and assign it as key
            String trainName = trainDetails.get(INDEX);

            //put it in inputMap
            inputMap.put(trainName,trainDetails);
        }
        sc.close();
        return inputMap;
    }

    private Utility() {

    }
}