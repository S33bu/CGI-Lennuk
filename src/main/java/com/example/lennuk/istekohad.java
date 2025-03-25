package com.example.lennuk;

import java.util.ArrayList;

public class istekohad {
    public static ArrayList<String> genereeriKohad(){
        ArrayList<String> kohad = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            double random = Math.random();
            if (random >= 0.75) {
                kohad.add("X");
            }else{
                kohad.add(String.valueOf(i));
            }
            
        }
        return kohad;
    }
}
