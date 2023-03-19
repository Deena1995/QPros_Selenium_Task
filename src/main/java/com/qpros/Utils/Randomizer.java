package com.qpros.Utils;

import java.util.Random;


public class Randomizer {


    public static String generateRandomizedNumber(){
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int result = r.nextInt(high-low)+low;
        return String.valueOf(result);
    }

    public static Integer randomFromMaxNum(int max){
        Random random = new Random();
        int min = 1;
        return random.nextInt((max - min) + 1) + min;
    }

}
