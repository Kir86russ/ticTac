package com.example.myapp;

import java.util.ArrayList;

class Logic {

    static final ArrayList<Cell> cells = new ArrayList<>();

    enum InfoTeamWin {WIN_TIC, WIN_TAC} // X,O

    static int winX = 0;
    static int winO = 0;
    static InfoTeamWin infoTeamWin; //
    static int countStep = 0;  //
    int infoWin = 0;



    /*              documentation:

3x3
    1) 1строка ооо
    2) 2строка ооо
    3) 3строка ооо

    4) 1столбец  о
                 о
                 о

    5) 2столбец  о
                 о
                 о

    6) 3столбец  о
                 о
                 о

    7) крест \   о
    8) крест /   о
    ______________

    11) 1строка ооо
    12) 2строка ооо
    13) 3строка ооо

    14) 1столбец о
                 о
                 о

    15) 2столбец о
                 о
                 о

    16) 3столбец о
                 о
                 о

    17) крест \  о
    18) крест /  о
    */


    boolean checkWin3x3() {


        /* Проверка на победу ноликов, горизонтальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 1, Cell.State.TAC)) && checkInGrid(new Cell(3, 1, Cell.State.TAC))) {
            infoWin = 1;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 2, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 2, Cell.State.TAC))) {
            infoWin = 2;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 3, Cell.State.TAC)) && checkInGrid(new Cell(2, 3, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC))) {
            infoWin = 3;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }


        /* Проверка на победу ноликов, вертикальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(1, 2, Cell.State.TAC)) && checkInGrid(new Cell(1, 3, Cell.State.TAC))) {
            infoWin = 4;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(2, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(2, 3, Cell.State.TAC))) {
            infoWin = 5;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(3, 1, Cell.State.TAC)) && checkInGrid(new Cell(3, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC))) {
            infoWin = 6;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }


        /* Проверка на победу ноликов, диагональный \ ряд */
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC))) {
            infoWin = 7;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }


        /* Проверка на победу ноликов, диагональный / ряд */
        if (checkInGrid(new Cell(3, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(1, 3, Cell.State.TAC))) {
            infoWin = 8;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }





        /* Проверка на победу КРЕСТИКОВ, горизонтальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 1, Cell.State.TIC)) && checkInGrid(new Cell(3, 1, Cell.State.TIC))) {
            infoWin = 11;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 2, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 2, Cell.State.TIC))) {
            infoWin = 12;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 3, Cell.State.TIC)) && checkInGrid(new Cell(2, 3, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC))) {
            infoWin = 13;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }


        /* Проверка на победу крестиков, вертикальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(1, 2, Cell.State.TIC)) && checkInGrid(new Cell(1, 3, Cell.State.TIC))) {
            infoWin = 14;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(2, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(2, 3, Cell.State.TIC))) {
            infoWin = 15;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(3, 1, Cell.State.TIC)) && checkInGrid(new Cell(3, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC))) {
            infoWin = 16;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }


        /* Проверка на победу крестиков, диагональный \ ряд */
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC))) {
            infoWin = 17;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }


        /* Проверка на победу крестиков, диагональный / ряд */
        if (checkInGrid(new Cell(3, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(1, 3, Cell.State.TIC))) {
            infoWin = 18;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }
        infoWin = 0;
        return false;
    }




     /*              documentation:

5x5
    1) 1строка оооoo
    2) 2строка оооoo
    3) 3строка оооoo

    4) 1столбец  о
                 о
                 o
                 o
                 о

    5) 2столбец  о
                 o
                 o
                 о
                 о

    6) 3столбец  о
                 o
                 o
                 о
                 о

    7) крест \   о
    8) крест /   о
    ______________

    11) 1строка xxxxx
    12) 2строка xxxxx
    13) 3строка xxxxx

    14) 1столбец x
                 x
                 x
                 x
                 x

    15) 2столбец x
                 x
                 x
                 x
                 x

    16) 3столбец x
                 x
                 x
                 x
                 x

    17) крест \  x
    18) крест /  x
    */


    boolean checkWin5x5() {

        /* Проверка на победу ноликов, горизонтальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 1, Cell.State.TAC)) && checkInGrid(new Cell(3, 1, Cell.State.TAC)) && checkInGrid(new Cell(4, 1, Cell.State.TAC)) && checkInGrid(new Cell(5, 1, Cell.State.TAC))) {
            infoWin = 1;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 2, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 2, Cell.State.TAC)) && checkInGrid(new Cell(4, 2, Cell.State.TAC)) && checkInGrid(new Cell(5, 2, Cell.State.TAC))) {
            infoWin = 2;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 3, Cell.State.TAC)) && checkInGrid(new Cell(2, 3, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC)) && checkInGrid(new Cell(4, 3, Cell.State.TAC)) && checkInGrid(new Cell(5, 3, Cell.State.TAC))) {
            infoWin = 3;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 4, Cell.State.TAC)) && checkInGrid(new Cell(2, 4, Cell.State.TAC)) && checkInGrid(new Cell(3, 4, Cell.State.TAC)) && checkInGrid(new Cell(4, 4, Cell.State.TAC)) && checkInGrid(new Cell(5, 4, Cell.State.TAC))) {
            infoWin = 31;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(1, 5, Cell.State.TAC)) && checkInGrid(new Cell(2, 5, Cell.State.TAC)) && checkInGrid(new Cell(3, 5, Cell.State.TAC)) && checkInGrid(new Cell(4, 5, Cell.State.TAC)) && checkInGrid(new Cell(5, 5, Cell.State.TAC))) {
            infoWin = 32;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        /* Проверка на победу ноликов, вертикальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(1, 2, Cell.State.TAC)) && checkInGrid(new Cell(1, 3, Cell.State.TAC)) && checkInGrid(new Cell(1, 4, Cell.State.TAC)) && checkInGrid(new Cell(1, 5, Cell.State.TAC))) {
            infoWin = 4;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(2, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(2, 3, Cell.State.TAC)) && checkInGrid(new Cell(2, 4, Cell.State.TAC)) && checkInGrid(new Cell(2, 5, Cell.State.TAC))) {
            infoWin = 5;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(3, 1, Cell.State.TAC)) && checkInGrid(new Cell(3, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC)) && checkInGrid(new Cell(3, 4, Cell.State.TAC)) && checkInGrid(new Cell(3, 5, Cell.State.TAC))) {
            infoWin = 6;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(4, 1, Cell.State.TAC)) && checkInGrid(new Cell(4, 2, Cell.State.TAC)) && checkInGrid(new Cell(4, 3, Cell.State.TAC)) && checkInGrid(new Cell(4, 4, Cell.State.TAC)) && checkInGrid(new Cell(4, 5, Cell.State.TAC))) {
            infoWin = 61;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        if (checkInGrid(new Cell(5, 1, Cell.State.TAC)) && checkInGrid(new Cell(5, 2, Cell.State.TAC)) && checkInGrid(new Cell(5, 3, Cell.State.TAC)) && checkInGrid(new Cell(5, 4, Cell.State.TAC)) && checkInGrid(new Cell(5, 5, Cell.State.TAC))) {
            infoWin = 62;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }

        /* Проверка на победу ноликов, диагональный \ ряд */
        if (checkInGrid(new Cell(1, 1, Cell.State.TAC)) && checkInGrid(new Cell(2, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC)) && checkInGrid(new Cell(4, 4, Cell.State.TAC)) && checkInGrid(new Cell(5, 5, Cell.State.TAC))) {
            infoWin = 7;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }


        /* Проверка на победу ноликов, диагональный / ряд */
        if (checkInGrid(new Cell(5, 1, Cell.State.TAC)) && checkInGrid(new Cell(4, 2, Cell.State.TAC)) && checkInGrid(new Cell(3, 3, Cell.State.TAC)) && checkInGrid(new Cell(2, 4, Cell.State.TAC)) && checkInGrid(new Cell(1, 5, Cell.State.TAC))) {
            infoWin = 8;
            infoTeamWin = InfoTeamWin.WIN_TAC;
            return true;
        }



        /* Проверка на победу КРЕСТИКОВ, горизонтальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 1, Cell.State.TIC)) && checkInGrid(new Cell(3, 1, Cell.State.TIC)) && checkInGrid(new Cell(4, 1, Cell.State.TIC)) && checkInGrid(new Cell(5, 1, Cell.State.TIC))) {
            infoWin = 11;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 2, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 2, Cell.State.TIC)) && checkInGrid(new Cell(4, 2, Cell.State.TIC)) && checkInGrid(new Cell(5, 2, Cell.State.TIC))) {
            infoWin = 12;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 3, Cell.State.TIC)) && checkInGrid(new Cell(2, 3, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC)) && checkInGrid(new Cell(4, 3, Cell.State.TIC)) && checkInGrid(new Cell(5, 3, Cell.State.TIC))) {
            infoWin = 13;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 4, Cell.State.TIC)) && checkInGrid(new Cell(2, 4, Cell.State.TIC)) && checkInGrid(new Cell(3, 4, Cell.State.TIC)) && checkInGrid(new Cell(4, 4, Cell.State.TIC)) && checkInGrid(new Cell(5, 4, Cell.State.TIC))) {
            infoWin = 131;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(1, 5, Cell.State.TIC)) && checkInGrid(new Cell(2, 5, Cell.State.TIC)) && checkInGrid(new Cell(3, 5, Cell.State.TIC)) && checkInGrid(new Cell(4, 5, Cell.State.TIC)) && checkInGrid(new Cell(5, 5, Cell.State.TIC))) {
            infoWin = 132;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        /* Проверка на победу крестиков, вертикальный ряд*/
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(1, 2, Cell.State.TIC)) && checkInGrid(new Cell(1, 3, Cell.State.TIC)) && checkInGrid(new Cell(1, 4, Cell.State.TIC)) && checkInGrid(new Cell(1, 5, Cell.State.TIC))) {
            infoWin = 14;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(2, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(2, 3, Cell.State.TIC)) && checkInGrid(new Cell(2, 4, Cell.State.TIC)) && checkInGrid(new Cell(2, 5, Cell.State.TIC))) {
            infoWin = 15;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(3, 1, Cell.State.TIC)) && checkInGrid(new Cell(3, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC)) && checkInGrid(new Cell(3, 4, Cell.State.TIC)) && checkInGrid(new Cell(3, 5, Cell.State.TIC))) {
            infoWin = 16;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(4, 1, Cell.State.TIC)) && checkInGrid(new Cell(4, 2, Cell.State.TIC)) && checkInGrid(new Cell(4, 3, Cell.State.TIC)) && checkInGrid(new Cell(4, 4, Cell.State.TIC)) && checkInGrid(new Cell(4, 5, Cell.State.TIC))) {
            infoWin = 161;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        if (checkInGrid(new Cell(5, 1, Cell.State.TIC)) && checkInGrid(new Cell(5, 2, Cell.State.TIC)) && checkInGrid(new Cell(5, 3, Cell.State.TIC)) && checkInGrid(new Cell(5, 4, Cell.State.TIC)) && checkInGrid(new Cell(5, 5, Cell.State.TIC))) {
            infoWin = 162;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }

        /* Проверка на победу крестиков, диагональный \ ряд */
        if (checkInGrid(new Cell(1, 1, Cell.State.TIC)) && checkInGrid(new Cell(2, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC)) && checkInGrid(new Cell(4, 4, Cell.State.TIC)) && checkInGrid(new Cell(5, 5, Cell.State.TIC))) {
            infoWin = 17;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }


        /* Проверка на победу крестиков, диагональный / ряд */
        if (checkInGrid(new Cell(5, 1, Cell.State.TIC)) && checkInGrid(new Cell(4, 2, Cell.State.TIC)) && checkInGrid(new Cell(3, 3, Cell.State.TIC)) && checkInGrid(new Cell(2, 4, Cell.State.TIC)) && checkInGrid(new Cell(1, 5, Cell.State.TIC))) {
            infoWin = 18;
            infoTeamWin = InfoTeamWin.WIN_TIC;
            return true;
        }
        infoWin = 0;
        return false;
    }

    boolean checkInGrid(Cell cell) {
        for (int i = 0; i != Logic.cells.size(); i++) {
            if (Logic.cells.get(i) != null && Logic.cells.get(i).equals(cell))
                return true;
        }
        return false;
    }

    boolean isEmptyOnCell(Cell cell) {
        for (int i = 0; i != Logic.cells.size(); i++) {
            if (Logic.cells.get(i) != null)
                if (Logic.cells.get(i).getX() == cell.getX() && Logic.cells.get(i).getY() == cell.getY())
                    return false;
        }
        return true;
    }

    void addFieldCell(Cell point) {
        cells.add(point);
    }


}