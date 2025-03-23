package com.example.lennuk;

import java.time.LocalDate;

public class Lend {
    private String start;
    private String sihtkoht;
    private LocalDate väljumisAeg;
    private float lennuKestvus;
    private float hind;

    public Lend() {}

    public Lend(String start, String sihtkoht, LocalDate väljumisAeg, float lennuKestvus, float hind) {
        this.start = start;
        this.sihtkoht = sihtkoht;
        this.väljumisAeg = väljumisAeg;
        this.lennuKestvus = lennuKestvus;
        this.hind = hind;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getSihtkoht() {
        return sihtkoht;
    }

    public void setSihtkoht(String sihtkoht) {
        this.sihtkoht = sihtkoht;
    }

    public LocalDate getVäljumisAeg() {
        return väljumisAeg;
    }

    public void setVäljumisAeg(LocalDate väljumisAeg) {
        this.väljumisAeg = väljumisAeg;
    }

    public float getLennuKestvus() {
        return lennuKestvus;
    }

    public void setLennuKestvus(float lennuKestvus) {
        this.lennuKestvus = lennuKestvus;
    }

    public float getHind() {
        return hind;
    }

    public void setHind(float hind) {
        this.hind = hind;
    }

    
}
