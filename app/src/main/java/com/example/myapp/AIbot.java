package com.example.myapp;

import java.util.Random;

public class AIbot {
    private final Logic logic = new Logic();

    private final Cell arrO3x3[] = {new Cell(1, 1, Cell.State.TAC), new Cell(2, 1, Cell.State.TAC), new Cell(3, 1, Cell.State.TAC),
                                    new Cell(1, 2, Cell.State.TAC), new Cell(2, 2, Cell.State.TAC), new Cell(3, 2, Cell.State.TAC),
                                    new Cell(1, 3, Cell.State.TAC), new Cell(2, 3, Cell.State.TAC), new Cell(3, 3, Cell.State.TAC)};

    private final Cell arrX3x3[] = {new Cell(1, 1, Cell.State.TIC), new Cell(2, 1, Cell.State.TIC), new Cell(3, 1, Cell.State.TIC),
                                    new Cell(1, 2, Cell.State.TIC), new Cell(2, 2, Cell.State.TIC), new Cell(3, 2, Cell.State.TIC),
                                    new Cell(1, 3, Cell.State.TIC), new Cell(2, 3, Cell.State.TIC), new Cell(3, 3, Cell.State.TIC)};


    private final Random random = new Random();


    void goBy3x3() {

        if (Logic.countStep != 9) {

            int index;

            do {
                index = random.nextInt(8);
            }
            while (logic.checkInGrid(arrO3x3[index]) || logic.checkInGrid(arrX3x3[index]));

            Logic.cells.add(arrO3x3[index]);
            Logic.countStep++;
        }
    }


    private final Cell arrO5x5[] = {new Cell(1, 1, Cell.State.TAC), new Cell(2, 1, Cell.State.TAC), new Cell(3, 1, Cell.State.TAC), new Cell(4, 1, Cell.State.TAC), new Cell(5, 1, Cell.State.TAC),
            new Cell(1, 2, Cell.State.TAC), new Cell(2, 2, Cell.State.TAC), new Cell(3, 2, Cell.State.TAC), new Cell(4, 2, Cell.State.TAC), new Cell(5, 2, Cell.State.TAC),
            new Cell(1, 3, Cell.State.TAC), new Cell(2, 3, Cell.State.TAC), new Cell(3, 3, Cell.State.TAC), new Cell(4, 3, Cell.State.TAC), new Cell(5, 3, Cell.State.TAC),
            new Cell(1, 4, Cell.State.TAC), new Cell(2, 4, Cell.State.TAC), new Cell(3, 4, Cell.State.TAC), new Cell(4, 4, Cell.State.TAC), new Cell(5, 4, Cell.State.TAC),
            new Cell(1, 5, Cell.State.TAC), new Cell(2, 5, Cell.State.TAC), new Cell(3, 5, Cell.State.TAC), new Cell(4, 5, Cell.State.TAC), new Cell(5, 5, Cell.State.TAC)};



    private final Cell arrX5x5[] = {new Cell(1, 1, Cell.State.TIC), new Cell(2, 1, Cell.State.TIC), new Cell(3, 1, Cell.State.TIC), new Cell(4, 1, Cell.State.TIC), new Cell(5, 1, Cell.State.TIC),
            new Cell(1, 2, Cell.State.TIC), new Cell(2, 2, Cell.State.TIC), new Cell(3, 2, Cell.State.TIC), new Cell(4, 2, Cell.State.TIC), new Cell(5, 2, Cell.State.TIC),
            new Cell(1, 3, Cell.State.TIC), new Cell(2, 3, Cell.State.TIC), new Cell(3, 3, Cell.State.TIC), new Cell(4, 3, Cell.State.TIC), new Cell(5, 3, Cell.State.TIC),
            new Cell(1, 4, Cell.State.TIC), new Cell(2, 4, Cell.State.TIC), new Cell(3, 4, Cell.State.TIC), new Cell(4, 4, Cell.State.TIC), new Cell(5, 4, Cell.State.TIC),
            new Cell(1, 5, Cell.State.TIC), new Cell(2, 5, Cell.State.TIC), new Cell(3, 5, Cell.State.TIC), new Cell(4, 5, Cell.State.TIC), new Cell(5, 5, Cell.State.TIC)};


    void goBy5x5() {

        if (Logic.countStep != 25) {

            int index;

            do {
                index = random.nextInt(24);
            }
            while (logic.checkInGrid(arrO5x5[index]) || logic.checkInGrid(arrX5x5[index]));

            Logic.cells.add(arrO5x5[index]);
            Logic.countStep++;
        }
    }
}
