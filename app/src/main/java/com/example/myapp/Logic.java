package com.example.myapp;

import android.graphics.Point;

import java.util.ArrayList;

class Logic {

    static ArrayList<Cell> cells = new ArrayList<>();

    static int winX = 0;
    static int winO = 0;
    static int flagTeamWin = 0; // 1-x, 2-o
    static int countStep = 0;
    int[] arrWin = new int[1];



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
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(490, 163)) && checkInGrid(new
                Point(817, 163)) && checkInGridKek(new
                Point(163, 163)) == 1 && checkInGridKek(new
                Point(490, 163)) == 1 && checkInGridKek(new
                Point(817, 163)) == 1) {
            arrWin[0] = 1;
            flagTeamWin = 2;
            return true;
        }


        if (checkInGrid(new
                Point(163, 523)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(817, 523)) && checkInGridKek(new
                Point(163, 523)) == 1 && checkInGridKek(new
                Point(490, 523)) == 1 && checkInGridKek(new
                Point(817, 523)) == 1) {
            arrWin[0] = 2;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new
                Point(163, 861)) && checkInGrid(new
                Point(490, 861)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(163, 861)) == 1 && checkInGridKek(new
                Point(490, 861)) == 1 && checkInGridKek(new
                Point(817, 861)) == 1) {
            arrWin[0] = 3;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, вертикальный ряд*/
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(163, 523)) && checkInGrid(new
                Point(163, 861)) && checkInGridKek(new
                Point(163, 163)) == 1 && checkInGridKek(new
                Point(163, 523)) == 1 && checkInGridKek(new
                Point(163, 861)) == 1) {
            arrWin[0] = 4;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new
                Point(490, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(490, 861)) && checkInGridKek(new
                Point(490, 163)) == 1 && checkInGridKek(new
                Point(490, 523)) == 1 && checkInGridKek(new
                Point(490, 861)) == 1) {
            arrWin[0] = 5;
            flagTeamWin = 2;
            return true;
        }


        if (checkInGrid(new
                Point(817, 163)) && checkInGrid(new
                Point(817, 523)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(817, 163)) == 1 && checkInGridKek(new
                Point(817, 523)) == 1 && checkInGridKek(new
                Point(817, 861)) == 1) {
            arrWin[0] = 6;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, диагональный \ ряд */
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(163, 163)) == 1 && checkInGridKek(new
                Point(490, 523)) == 1 && checkInGridKek(new
                Point(817, 861)) == 1) {
            arrWin[0] = 7;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, диагональный / ряд */
        if (checkInGrid(new
                Point(817, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(163, 861)) && checkInGridKek(new
                Point(817, 163)) == 1 && checkInGridKek(new
                Point(490, 523)) == 1 && checkInGridKek(new
                Point(163, 861)) == 1) {
            arrWin[0] = 8;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, горизонтальный ряд*/
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(490, 163)) && checkInGrid(new
                Point(817, 163)) && checkInGridKek(new
                Point(163, 163)) == 0 && checkInGridKek(new
                Point(490, 163)) == 0 && checkInGridKek(new
                Point(817, 163)) == 0) {
            arrWin[0] = 11;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new
                Point(163, 523)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(817, 523)) && checkInGridKek(new
                Point(163, 523)) == 0 && checkInGridKek(new
                Point(490, 523)) == 0 && checkInGridKek(new
                Point(817, 523)) == 0) {
            arrWin[0] = 12;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new
                Point(163, 861)) && checkInGrid(new
                Point(490, 861)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(163, 861)) == 0 && checkInGridKek(new
                Point(490, 861)) == 0 && checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 13;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, вертикальный ряд*/
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(163, 523)) && checkInGrid(new
                Point(163, 861)) && checkInGridKek(new
                Point(163, 163)) == 0 && checkInGridKek(new
                Point(163, 523)) == 0 && checkInGridKek(new
                Point(163, 861)) == 0) {
            arrWin[0] = 14;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new
                Point(490, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(490, 861)) && checkInGridKek(new
                Point(490, 163)) == 0 && checkInGridKek(new
                Point(490, 523)) == 0 && checkInGridKek(new
                Point(490, 861)) == 0) {
            arrWin[0] = 15;
            flagTeamWin = 1;
            return true;
        }


        if (checkInGrid(new
                Point(817, 163)) && checkInGrid(new
                Point(817, 523)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(817, 163)) == 0 && checkInGridKek(new
                Point(817, 523)) == 0 && checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 16;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, диагональный \ ряд */
        if (checkInGrid(new
                Point(163, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(817, 861)) && checkInGridKek(new
                Point(163, 163)) == 0 && checkInGridKek(new
                Point(490, 523)) == 0 && checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 17;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, диагональный / ряд */
        if (checkInGrid(new
                Point(817, 163)) && checkInGrid(new
                Point(490, 523)) && checkInGrid(new
                Point(163, 861)) && checkInGridKek(new
                Point(817, 163)) == 0 && checkInGridKek(new
                Point(490, 523)) == 0 && checkInGridKek(new
                Point(163, 861)) == 0) {
            arrWin[0] = 18;
            flagTeamWin = 1;
            return true;
        }
        arrWin[0] = 0;
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
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(297, 104)) && checkInGrid(new Point(496, 104)) && checkInGrid(new Point(695, 104)) && checkInGrid(new Point(886, 104)) && checkInGridKek(new Point(102, 104)) == 1 && checkInGridKek(new Point(297, 104)) == 1 && checkInGridKek(new Point(496, 104)) == 1 && checkInGridKek(new Point(695, 104)) == 1 && checkInGridKek(new Point(886, 104)) == 1) {
            arrWin[0] = 1;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(102, 312)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(496, 312)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(886, 312)) && checkInGridKek(new Point(102, 312)) == 1 && checkInGridKek(new Point(297, 312)) == 1 && checkInGridKek(new Point(496, 312)) == 1 && checkInGridKek(new Point(695, 312)) == 1 && checkInGridKek(new Point(886, 312)) == 1) {
            arrWin[0] = 2;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(102, 525)) && checkInGrid(new Point(297, 525)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(695, 525)) && checkInGrid(new Point(886, 525)) && checkInGridKek(new Point(102, 525)) == 1 && checkInGridKek(new Point(297, 525)) == 1 && checkInGridKek(new Point(496, 525)) == 1 && checkInGridKek(new Point(695, 525)) == 1 && checkInGridKek(new Point(886, 525)) == 1) {
            arrWin[0] = 3;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(102, 735)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(496, 735)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(886, 735)) && checkInGridKek(new Point(102, 735)) == 1 && checkInGridKek(new Point(297, 735)) == 1 && checkInGridKek(new Point(496, 735)) == 1 && checkInGridKek(new Point(695, 735)) == 1 && checkInGridKek(new Point(886, 735)) == 1) {
            arrWin[0] = 31;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(102, 946)) && checkInGrid(new Point(297, 946)) && checkInGrid(new Point(496, 946)) && checkInGrid(new Point(695, 946)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(102, 946)) == 1 && checkInGridKek(new Point(297, 946)) == 1 && checkInGridKek(new Point(496, 946)) == 1 && checkInGridKek(new Point(695, 946)) == 1 && checkInGridKek(new Point(886, 946)) == 1) {
            arrWin[0] = 32;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, вертикальный ряд*/
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(102, 312)) && checkInGrid(new Point(102, 525)) && checkInGrid(new Point(102, 735)) && checkInGrid(new Point(102, 946)) && checkInGridKek(new Point(102, 104)) == 1 && checkInGridKek(new Point(102, 312)) == 1 && checkInGridKek(new Point(102, 525)) == 1 && checkInGridKek(new Point(102, 735)) == 1 && checkInGridKek(new Point(102, 946)) == 1) {
            arrWin[0] = 4;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(297, 104)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(297, 525)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(297, 946)) && checkInGridKek(new Point(297, 104)) == 1 && checkInGridKek(new Point(297, 312)) == 1 && checkInGridKek(new Point(297, 525)) == 1 && checkInGridKek(new Point(297, 735)) == 1 && checkInGridKek(new Point(297, 946)) == 1) {
            arrWin[0] = 5;
            flagTeamWin = 2;
            return true;
        }


        if (checkInGrid(new Point(496, 104)) && checkInGrid(new Point(496, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(496, 735)) && checkInGrid(new Point(496, 946)) && checkInGridKek(new Point(496, 104)) == 1 && checkInGridKek(new Point(496, 312)) == 1 && checkInGridKek(new Point(496, 525)) == 1 && checkInGridKek(new Point(496, 735)) == 1 && checkInGridKek(new Point(496, 946)) == 1) {
            arrWin[0] = 6;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(695, 104)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(695, 525)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(695, 946)) && checkInGridKek(new Point(695, 104)) == 1 && checkInGridKek(new Point(695, 312)) == 1 && checkInGridKek(new Point(695, 525)) == 1 && checkInGridKek(new Point(695, 735)) == 1 && checkInGridKek(new Point(695, 946)) == 1) {
            arrWin[0] = 61;
            flagTeamWin = 2;
            return true;
        }

        if (checkInGrid(new Point(886, 104)) && checkInGrid(new Point(886, 312)) && checkInGrid(new Point(886, 525)) && checkInGrid(new Point(886, 735)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(886, 104)) == 1 && checkInGridKek(new Point(886, 312)) == 1 && checkInGridKek(new Point(886, 525)) == 1 && checkInGridKek(new Point(886, 735)) == 1 && checkInGridKek(new Point(886, 946)) == 1) {
            arrWin[0] = 62;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, диагональный \ ряд */
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(102, 104)) == 1 && checkInGridKek(new Point(297, 312)) == 1 && checkInGridKek(new Point(496, 525)) == 1 && checkInGridKek(new Point(695, 735)) == 1 && checkInGridKek(new Point(886, 946)) == 1) {
            arrWin[0] = 7;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу ноликов, диагональный / ряд */
        if (checkInGrid(new Point(886, 104)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(102, 946)) && checkInGridKek(new Point(886, 104)) == 1 && checkInGridKek(new Point(695, 312)) == 1 && checkInGridKek(new Point(496, 525)) == 1 && checkInGridKek(new Point(297, 735)) == 1 && checkInGridKek(new Point(102, 946)) == 1) {
            arrWin[0] = 8;
            flagTeamWin = 2;
            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, горизонтальный ряд*/
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(297, 104)) && checkInGrid(new Point(496, 104)) && checkInGrid(new Point(695, 104)) && checkInGrid(new Point(886, 104)) && checkInGridKek(new Point(102, 104)) == 0 && checkInGridKek(new Point(297, 104)) == 0 && checkInGridKek(new Point(496, 104)) == 0 && checkInGridKek(new Point(695, 104)) == 0 && checkInGridKek(new Point(886, 104)) == 0) {
            arrWin[0] = 11;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(102, 312)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(496, 312)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(886, 312)) && checkInGridKek(new Point(102, 312)) == 0 && checkInGridKek(new Point(297, 312)) == 0 && checkInGridKek(new Point(496, 312)) == 0 && checkInGridKek(new Point(695, 312)) == 0 && checkInGridKek(new Point(886, 312)) == 0) {
            arrWin[0] = 12;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(102, 525)) && checkInGrid(new Point(297, 525)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(695, 525)) && checkInGrid(new Point(886, 525)) && checkInGridKek(new Point(102, 525)) == 0 && checkInGridKek(new Point(297, 525)) == 0 && checkInGridKek(new Point(496, 525)) == 0 && checkInGridKek(new Point(695, 525)) == 0 && checkInGridKek(new Point(886, 525)) == 0) {
            arrWin[0] = 13;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(102, 735)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(496, 735)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(886, 735)) && checkInGridKek(new Point(102, 735)) == 0 && checkInGridKek(new Point(297, 735)) == 0 && checkInGridKek(new Point(496, 735)) == 0 && checkInGridKek(new Point(695, 735)) == 0 && checkInGridKek(new Point(886, 735)) == 0) {
            arrWin[0] = 131;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(102, 946)) && checkInGrid(new Point(297, 946)) && checkInGrid(new Point(496, 946)) && checkInGrid(new Point(695, 946)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(102, 946)) == 0 && checkInGridKek(new Point(297, 946)) == 0 && checkInGridKek(new Point(496, 946)) == 0 && checkInGridKek(new Point(695, 946)) == 0 && checkInGridKek(new Point(886, 946)) == 0) {
            arrWin[0] = 132;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу ноликов, вертикальный ряд*/
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(102, 312)) && checkInGrid(new Point(102, 525)) && checkInGrid(new Point(102, 735)) && checkInGrid(new Point(102, 946)) && checkInGridKek(new Point(102, 104)) == 0 && checkInGridKek(new Point(102, 312)) == 0 && checkInGridKek(new Point(102, 525)) == 0 && checkInGridKek(new Point(102, 735)) == 0 && checkInGridKek(new Point(102, 946)) == 0) {
            arrWin[0] = 14;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(297, 104)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(297, 525)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(297, 946)) && checkInGridKek(new Point(297, 104)) == 0 && checkInGridKek(new Point(297, 312)) == 0 && checkInGridKek(new Point(297, 525)) == 0 && checkInGridKek(new Point(297, 735)) == 0 && checkInGridKek(new Point(297, 946)) == 0) {
            arrWin[0] = 15;
            flagTeamWin = 1;
            return true;
        }


        if (checkInGrid(new Point(496, 104)) && checkInGrid(new Point(496, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(496, 735)) && checkInGrid(new Point(496, 946)) && checkInGridKek(new Point(496, 104)) == 0 && checkInGridKek(new Point(496, 312)) == 0 && checkInGridKek(new Point(496, 525)) == 0 && checkInGridKek(new Point(496, 735)) == 0 && checkInGridKek(new Point(496, 946)) == 0) {
            arrWin[0] = 16;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(695, 104)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(695, 525)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(695, 946)) && checkInGridKek(new Point(695, 104)) == 0 && checkInGridKek(new Point(695, 312)) == 0 && checkInGridKek(new Point(695, 525)) == 0 && checkInGridKek(new Point(695, 735)) == 0 && checkInGridKek(new Point(695, 946)) == 0) {
            arrWin[0] = 161;
            flagTeamWin = 1;
            return true;
        }

        if (checkInGrid(new Point(886, 104)) && checkInGrid(new Point(886, 312)) && checkInGrid(new Point(886, 525)) && checkInGrid(new Point(886, 735)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(886, 104)) == 0 && checkInGridKek(new Point(886, 312)) == 0 && checkInGridKek(new Point(886, 525)) == 0 && checkInGridKek(new Point(886, 735)) == 0 && checkInGridKek(new Point(886, 946)) == 0) {
            arrWin[0] = 162;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу ноликов, диагональный \ ряд */
        if (checkInGrid(new Point(102, 104)) && checkInGrid(new Point(297, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(695, 735)) && checkInGrid(new Point(886, 946)) && checkInGridKek(new Point(102, 104)) == 0 && checkInGridKek(new Point(297, 312)) == 0 && checkInGridKek(new Point(496, 525)) == 0 && checkInGridKek(new Point(695, 735)) == 0 && checkInGridKek(new Point(886, 946)) == 0) {
            arrWin[0] = 17;
            flagTeamWin = 1;
            return true;
        }

        /* Проверка на победу ноликов, диагональный / ряд */
        if (checkInGrid(new Point(886, 104)) && checkInGrid(new Point(695, 312)) && checkInGrid(new Point(496, 525)) && checkInGrid(new Point(297, 735)) && checkInGrid(new Point(102, 946)) && checkInGridKek(new Point(886, 104)) == 0 && checkInGridKek(new Point(695, 312)) == 0 && checkInGridKek(new Point(496, 525)) == 0 && checkInGridKek(new Point(297, 735)) == 0 && checkInGridKek(new Point(102, 946)) == 0) {
            arrWin[0] = 18;
            flagTeamWin = 1;
            return true;
        }
        arrWin[0] = 0;
        return false;
    }

    boolean checkInGrid(Point point) {
        for (int i = 0; i != cells.size(); i++) {
            if (cells.get(i) != null)
                if (cells.get(i).getPoint().equals(point)) return true;
        }
        return false;
    }

    private int checkInGridKek(Point point) {
        for (int i = 0; i != cells.size(); i++) {
            if (cells != null)
                if (cells.get(i).getPoint().equals(point))
                    return cells.get(i).getKek();
        }
        return -1;
    }

    void setFieldCell(Point point) {
        if (Logic.countStep % 2 == 0)
            cells.add(new Cell(point, 1));

        else
            cells.add(new Cell(point, 0));

    }


}