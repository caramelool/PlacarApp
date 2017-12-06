package br.com.fiap.placarapp;

import java.io.Serializable;

/**
 * Created by lucascaramelo on 04/12/17.
 */

public class Time implements Serializable {
    private String name;
    private int gols;

    public Time(String name) {
        this.name = name;
        gols = 0;
    }

    public String getName() {
        return name;
    }

    public int getGols() {
        return gols;
    }

    public void gol() {
        gols++;
    }
}
