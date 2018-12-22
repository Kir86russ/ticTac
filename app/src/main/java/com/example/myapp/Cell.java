package com.example.myapp;

import android.graphics.Point;

class Cell {

    private int kek; // 1 -> nolik, 0 -> krestik
    private Point point;

    int getKek() {
        return kek;
    }

    public Point getPoint() {
        return point;
    }

    Cell(Point point, int kek) {
        this.point = point;
        this.kek = kek;

    }

}
