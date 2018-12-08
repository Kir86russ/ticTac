package com.example.myapp;

import android.graphics.Point;

public class Cell {

    int kek; // 0 -> nolik, 1 -> krestik
    Point point;


    Cell(Point point, int kek){
        this.point = point;
        this.kek = kek;

    }

}
