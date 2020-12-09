package com.example.lt1;

public class TuVung {
    private String TuVung;
    private String DinhNghia;

    public String getTuVung() {
        return TuVung;
    }

    public String getDinhNghia() {
        return DinhNghia;
    }

    public TuVung() {

    }
    public TuVung(String word, String def) {
        TuVung = word;
        DinhNghia = def;
    }
}
