package com.example.myapp;

import android.graphics.Point;
import java.util.Random;

class bot {

    private Logic logic = new Logic();

    private Cell arrO3x3[] = {new Cell(new Point(163, 163), 1), new Cell(new Point(490, 163), 1), new Cell(new Point(817, 163), 1),
            new Cell(new Point(163, 523), 1), new Cell(new Point(490, 523), 1), new Cell(new Point(817, 523), 1),
            new Cell(new Point(163, 861), 1), new Cell(new Point(490, 861), 1), new Cell(new Point(817, 861), 1)};

    private Cell arrX3x3[] = {new Cell(new Point(163, 163), 0), new Cell(new Point(490, 163), 0), new Cell(new Point(817, 163), 0),
            new Cell(new Point(163, 523), 0), new Cell(new Point(490, 523), 0), new Cell(new Point(817, 523), 0),
            new Cell(new Point(163, 861), 0), new Cell(new Point(490, 861), 0), new Cell(new Point(817, 861), 0)};


    private Random random = new Random();


    void goBy3x3() {

        if (Logic.countStep != 9) {

            int index;

            do {
                index = random.nextInt(8);
            }
            while (logic.checkInGrid(arrO3x3[index].getPoint()) || logic.checkInGrid(arrX3x3[index].getPoint()));

            Logic.cells.add(arrO3x3[index]);
            Logic.countStep++;
        }
    }


    private Cell arrO5x5[] = {new Cell(new Point(102, 104), 1), new Cell(new Point(297, 104), 1), new Cell(new Point(496, 104), 1), new Cell(new Point(695, 104), 1), new Cell(new Point(886, 104), 1),
                              new Cell(new Point(102, 312), 1), new Cell(new Point(297, 312), 1), new Cell(new Point(496, 312), 1), new Cell(new Point(695, 312), 1), new Cell(new Point(886, 312), 1),
                              new Cell(new Point(102, 525), 1), new Cell(new Point(297, 525), 1), new Cell(new Point(496, 525), 1), new Cell(new Point(695, 525), 1), new Cell(new Point(886, 525), 1),
                              new Cell(new Point(102, 735), 1), new Cell(new Point(297, 735), 1), new Cell(new Point(496, 735), 1), new Cell(new Point(695, 735), 1), new Cell(new Point(886, 735), 1),
                              new Cell(new Point(102, 946), 1), new Cell(new Point(297, 946), 1), new Cell(new Point(496, 946), 1), new Cell(new Point(695, 946), 1), new Cell(new Point(886, 946), 1)};



    private Cell arrX5x5[] = {new Cell(new Point(102, 104), 0), new Cell(new Point(297, 104), 0), new Cell(new Point(496, 104), 0), new Cell(new Point(695, 104), 0), new Cell(new Point(886, 104), 0),
                              new Cell(new Point(102, 312), 0), new Cell(new Point(297, 312), 0), new Cell(new Point(496, 312), 0), new Cell(new Point(695, 312), 0), new Cell(new Point(886, 312), 0),
                              new Cell(new Point(102, 525), 0), new Cell(new Point(297, 525), 0), new Cell(new Point(496, 525), 0), new Cell(new Point(695, 525), 0), new Cell(new Point(886, 525), 0),
                              new Cell(new Point(102, 735), 0), new Cell(new Point(297, 735), 0), new Cell(new Point(496, 735), 0), new Cell(new Point(695, 735), 0), new Cell(new Point(886, 735), 0),
                              new Cell(new Point(102, 946), 0), new Cell(new Point(297, 946), 0), new Cell(new Point(496, 946), 0), new Cell(new Point(695, 946), 0), new Cell(new Point(886, 946), 0)};



    void goBy5x5() {

        if (Logic.countStep != 25) {

            int index;

            do {
                index = random.nextInt(24);
            }
            while (logic.checkInGrid(arrO5x5[index].getPoint()) || logic.checkInGrid(arrX5x5[index].getPoint()));

            Logic.cells.add(arrO5x5[index]);
            Logic.countStep++;
        }
    }
}
