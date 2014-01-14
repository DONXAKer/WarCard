package com.mafia.warcard.BaseClass;

public class Map {

    private int[][] fields;

    // инициализируем параметры карты в базовом классе
    public void InitialMap(int countX, int countY) {
        fields = new int[countX][countY];
    }
}
