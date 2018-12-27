package com.example.myapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    private final Logic logic = new Logic();

    @Test
    public void checkWin3x3test() {

        boolean actualValue;

        // победа ноликов верхняя горизонталь
        Logic.cells.add(new Cell(1, 1, Cell.State.TAC));
        Logic.cells.add(new Cell(2, 1, Cell.State.TAC));
        Logic.cells.add(new Cell(3, 1, Cell.State.TAC));

        actualValue = logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();


        // победа крестиков нижняя горизонталь
        Logic.cells.add(new Cell(1, 3, Cell.State.TIC));
        Logic.cells.add(new Cell(2, 3, Cell.State.TIC));
        Logic.cells.add(new Cell(3, 3, Cell.State.TIC));

        actualValue = logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа нолииков левая вертикаль
        Logic.cells.add(new Cell(1, 1, Cell.State.TAC));
        Logic.cells.add(new Cell(1, 2, Cell.State.TAC));
        Logic.cells.add(new Cell(1, 3, Cell.State.TAC));

        actualValue =  logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа крестиков \ диагональ
        Logic.cells.add(new Cell(1, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(2, 2, Cell.State.TIC));
        Logic.cells.add(new Cell(3, 3, Cell.State.TIC));
        actualValue =  logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // не победа
        Logic.cells.add(new Cell(10, 10, Cell.State.TIC));
        Logic.cells.add(new Cell(100, 100, Cell.State.TIC));
        Logic.cells.add(new Cell(1000, 1000, Cell.State.TIC));
        actualValue =  logic.checkWin3x3();
        assertFalse(actualValue);
        Logic.cells.clear();

    }

    @Test
    public void checkWin5x5test() {

        boolean actualValue;

        // победа крестиков верхняя горизонталь
        Logic.cells.add(new Cell(1, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(2, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(3, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(4, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(5, 1, Cell.State.TIC));
        actualValue = logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();


        // победа нолииков нижняя горизонталь
        Logic.cells.add(new Cell(1, 5, Cell.State.TAC));
        Logic.cells.add(new Cell(2, 5, Cell.State.TAC));
        Logic.cells.add(new Cell(3, 5, Cell.State.TAC));
        Logic.cells.add(new Cell(4, 5, Cell.State.TAC));
        Logic.cells.add(new Cell(5, 5, Cell.State.TAC));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа крестиков левая вертикаль
        Logic.cells.add(new Cell(1, 1, Cell.State.TIC));
        Logic.cells.add(new Cell(1, 2, Cell.State.TIC));
        Logic.cells.add(new Cell(1, 3, Cell.State.TIC));
        Logic.cells.add(new Cell(1, 4, Cell.State.TIC));
        Logic.cells.add(new Cell(1, 5, Cell.State.TIC));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа ноликов \ диагональ
        Logic.cells.add(new Cell(1, 1, Cell.State.TAC));
        Logic.cells.add(new Cell(2, 2, Cell.State.TAC));
        Logic.cells.add(new Cell(3, 3, Cell.State.TAC));
        Logic.cells.add(new Cell(4, 4, Cell.State.TAC));
        Logic.cells.add(new Cell(5, 5, Cell.State.TAC));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // не победа
        Logic.cells.add(new Cell(10, 10, Cell.State.TAC));
        Logic.cells.add(new Cell(100, 100, Cell.State.TAC));
        Logic.cells.add(new Cell(1000, 1000, Cell.State.TAC));
        Logic.cells.add(new Cell(10000, 1000, Cell.State.TAC));
        Logic.cells.add(new Cell(100000, 1000, Cell.State.TAC));
        actualValue =  logic.checkWin5x5();
        assertFalse(actualValue);
        Logic.cells.clear();
    }
}