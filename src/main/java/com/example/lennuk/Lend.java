package com.example.lennuk;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Lend {
    private String start;
    private String sihtkoht;
    private LocalDateTime väljumisAeg;
    private float lennuKestvus;
    private float hind;
    private ArrayList<String> istekohad;

    public Lend() {}

    public Lend(String start, String sihtkoht, LocalDateTime väljumisAeg, float lennuKestvus, float hind, ArrayList<String> istekohad) {
        this.start = start;
        this.sihtkoht = sihtkoht;
        this.väljumisAeg = väljumisAeg;
        this.lennuKestvus = lennuKestvus;
        this.hind = hind;
        this.istekohad = istekohad;
    }

    public ArrayList<String> getIstekohad() {
        return istekohad;
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

    public LocalDateTime getVäljumisAeg() {
        return väljumisAeg;
    }

    public void setVäljumisAeg(LocalDateTime väljumisAeg) {
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
