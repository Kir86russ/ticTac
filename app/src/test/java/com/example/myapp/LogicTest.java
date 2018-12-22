package com.example.myapp;



import android.graphics.Point;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LogicTest {

    private Logic logic = new Logic();
    ArrayList<Cell> testCells = new ArrayList<>();

    @Test
    public void checkWin3x3test() {

        boolean actualValue;

        // победа крестиков верхняя горизонталь
        Logic.cells.add(new Cell(new Point(163, 163), 0));
        Logic.cells.add(new Cell(new Point(490, 163), 0));
        Logic.cells.add(new Cell(new Point(817, 163), 0));
        actualValue = logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();


        // победа крестиков нижняя горизонталь
        Logic.cells.add(new Cell(new Point(163, 861), 0));
        Logic.cells.add(new Cell(new Point(490, 861), 0));
        Logic.cells.add(new Cell(new Point(817, 861), 0));
        actualValue =  logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа крестиков левая вертикаль
        Logic.cells.add(new Cell(new Point(163, 163), 0));
        Logic.cells.add(new Cell(new Point(163, 523), 0));
        Logic.cells.add(new Cell(new Point(163, 861), 0));
        actualValue =  logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа крестиков \ диагональ
        Logic.cells.add(new Cell(new Point(163, 163), 0));
        Logic.cells.add(new Cell(new Point(490, 523), 0));
        Logic.cells.add(new Cell(new Point(817, 861), 0));
        actualValue =  logic.checkWin3x3();
        assertTrue(actualValue);
        Logic.cells.clear();

        // не победа
        Logic.cells.add(new Cell(new Point(10, 10), 0));
        Logic.cells.add(new Cell(new Point(100, 100), 0));
        Logic.cells.add(new Cell(new Point(1000, 1000), 0));
        actualValue =  logic.checkWin3x3();
        assertFalse(actualValue);
        Logic.cells.clear();

    }

    @Test
    public void checkWin5x5test() {

        boolean actualValue;

        // победа ноликов верхняя горизонталь
        Logic.cells.add(new Cell(new Point(102, 104), 1));
        Logic.cells.add(new Cell(new Point(297, 104), 1));
        Logic.cells.add(new Cell(new Point(496, 104), 1));
        Logic.cells.add(new Cell(new Point(695, 104), 1));
        Logic.cells.add(new Cell(new Point(886, 104), 1));
        actualValue = logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();


        // победа ноликов нижняя горизонталь
        Logic.cells.add(new Cell(new Point(102, 946), 1));
        Logic.cells.add(new Cell(new Point(297, 946), 1));
        Logic.cells.add(new Cell(new Point(496, 946), 1));
        Logic.cells.add(new Cell(new Point(695, 946), 1));
        Logic.cells.add(new Cell(new Point(886, 946), 1));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа ноликов левая вертикаль
        Logic.cells.add(new Cell(new Point(102, 104), 1));
        Logic.cells.add(new Cell(new Point(102, 312), 1));
        Logic.cells.add(new Cell(new Point(102, 525), 1));
        Logic.cells.add(new Cell(new Point(102, 735), 1));
        Logic.cells.add(new Cell(new Point(102, 946), 1));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // победа ноликов \ диагональ
        Logic.cells.add(new Cell(new Point(102, 104), 1));
        Logic.cells.add(new Cell(new Point(297, 312), 1));
        Logic.cells.add(new Cell(new Point(496, 525), 1));
        Logic.cells.add(new Cell(new Point(695, 735), 1));
        Logic.cells.add(new Cell(new Point(886, 946), 1));
        actualValue =  logic.checkWin5x5();
        assertTrue(actualValue);
        Logic.cells.clear();

        // не победа
        Logic.cells.add(new Cell(new Point(10, 10), 1));
        Logic.cells.add(new Cell(new Point(100, 100), 1));
        Logic.cells.add(new Cell(new Point(1000, 1000), 1));
        Logic.cells.add(new Cell(new Point(10000, 1000), 1));
        Logic.cells.add(new Cell(new Point(100000, 1000), 1));
        actualValue =  logic.checkWin5x5();
        assertFalse(actualValue);
        Logic.cells.clear();
    }
}