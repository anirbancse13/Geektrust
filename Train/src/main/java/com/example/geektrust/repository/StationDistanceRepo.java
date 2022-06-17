package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;
public class StationDistanceRepo {

    public static final int VALUE_350 = 350;
    public static final int VALUE_550 = 550;
    public static final int VALUE_900 = 900;
    public static final int VALUE_1200 = 1200;
    public static final int VALUE_1600 = 1600;
    public static final int VALUE_1900 = 1900;
    public static final int VALUE_2000 = 2000;
    public static final int VALUE_2500 = 2500;
    public static final int VALUE_2700 = 2700;
    public static final int VALUE_300 = 300;
    public static final int VALUE_600 = 600;
    public static final int VALUE_1000 = 1000;
    public static final int VALUE_1400 = 1400;
    public static final int VALUE_2400 = 2400;
    public static final int VALUE_2800 = 2800;
    public static final int VALUE_3800 = 3800;
    public static final int VALUE_4200 = 4200;
    public static final int VALUE_4700 = 4700;
    public static final String STATION_CODE_SLM = "SLM";
    public static final String STATION_CODE_BLR = "BLR";
    public static final String STATION_CODE_KRN = "KRN";
    public static final String STATION_CODE_HYB = "HYB";
    public static final String STATION_CODE_NGP = "NGP";
    public static final String STATION_CODE_ITJ = "ITJ";
    public static final String STATION_CODE_NDL = "NDL";
    public static final String STATION_CODE_SRR = "SRR";
    public static final String STATION_CODE_MAQ = "MAQ";
    public static final String STATION_CODE_MAO = "MAO";
    public static final String STATION_CODE_PNE = "PNE";
    public static final String STATION_CODE_PTA = "PTA";
    public static final String STATION_CODE_NJP = "NJP";
    public static final String STATION_CODE_GHY = "GHY";
    public static final String STATION_CODE_BPL = "BPL";
    public static final String STATION_CODE_AGA = "AGA";
    private static Map<String, Integer> chnToNdl;
    private static Map<String, Integer> tvcToGhy;

    static {
        populateChnToNdl();
        populateTvcToGhy();
    }

    private static void populateTvcToGhy() {
        chnToNdl = new HashMap<>();
        chnToNdl.put(STATION_CODE_SLM,VALUE_350);
        chnToNdl.put(STATION_CODE_BLR,VALUE_550);
        chnToNdl.put(STATION_CODE_KRN,VALUE_900);
        chnToNdl.put(STATION_CODE_HYB,VALUE_1200);
        chnToNdl.put(STATION_CODE_NGP,VALUE_1600);
        chnToNdl.put(STATION_CODE_ITJ,VALUE_1900);
        chnToNdl.put(STATION_CODE_BPL,VALUE_2000);
        chnToNdl.put(STATION_CODE_AGA,VALUE_2500);
        chnToNdl.put(STATION_CODE_NDL,VALUE_2700);
    }

    private static void populateChnToNdl() {
        tvcToGhy = new HashMap<>();
        tvcToGhy.put(STATION_CODE_SRR,VALUE_300);
        tvcToGhy.put(STATION_CODE_MAQ,VALUE_600);
        tvcToGhy.put(STATION_CODE_MAO,VALUE_1000);
        tvcToGhy.put(STATION_CODE_PNE,VALUE_1400);
        tvcToGhy.put(STATION_CODE_HYB,VALUE_2000);
        tvcToGhy.put(STATION_CODE_NGP,VALUE_2400);
        tvcToGhy.put(STATION_CODE_ITJ,VALUE_2700);
        tvcToGhy.put(STATION_CODE_BPL,VALUE_2800);
        tvcToGhy.put(STATION_CODE_PTA,VALUE_3800);
        tvcToGhy.put(STATION_CODE_NJP,VALUE_4200);
        tvcToGhy.put(STATION_CODE_GHY,VALUE_4700);
    }

    public static Map<String, Integer> getChnToNdl() {
        return chnToNdl;
    }

    public static Map<String, Integer> getTvcToGhy() {
        return tvcToGhy;
    }
}
