package com.example.myapp;


import android.content.Context;
import android.graphics.Point;

class Logic {

    static int winX = 0;
    static int winO = 0;
    static int[] arrWin = new int[1];

    static int countChangeOrientation = 0;



    /*              documentation:
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


    boolean checkWin() {
        /* Проверка на победу ноликов, горизонтальный ряд*/
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 163)) && PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 1) {
            arrWin[0] = 1;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(163, 523)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 523)) && PlayFieldListener.checkInGridKek(new
                Point(163, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(817, 523)) == 1) {
            arrWin[0] = 2;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGrid(new
                Point(490, 861)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 861)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(817, 861)) == 1) {
            arrWin[0] = 3;

            return true;
        }

        /* Проверка на победу ноликов, вертикальный ряд*/
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(163, 523)) && PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(163, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 1) {
            arrWin[0] = 4;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(490, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(490, 861)) && PlayFieldListener.checkInGridKek(new
                Point(490, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 861)) == 1) {
            arrWin[0] = 5;

            return true;
        }


        if (PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGrid(new
                Point(817, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(817, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(817, 861)) == 1) {
            arrWin[0] = 6;

            return true;
        }

        /* Проверка на победу ноликов, диагональный \ ряд */
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 1 && PlayFieldListener.checkInGridKek(new


                Point(817, 861)) == 1) {
            arrWin[0] = 7;

            return true;
        }

        /* Проверка на победу ноликов, диагональный / ряд */
        if (PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 1 && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 1) {
            arrWin[0] = 8;

            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, горизонтальный ряд*/
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 163)) && PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 0) {
            arrWin[0] = 11;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(163, 523)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 523)) && PlayFieldListener.checkInGridKek(new
                Point(163, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 523)) == 0) {
            arrWin[0] = 12;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGrid(new
                Point(490, 861)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 861)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 13;

            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, вертикальный ряд*/
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(163, 523)) && PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(163, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 0) {
            arrWin[0] = 14;

            return true;
        }

        if (PlayFieldListener.checkInGrid(new
                Point(490, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(490, 861)) && PlayFieldListener.checkInGridKek(new
                Point(490, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 861)) == 0) {
            arrWin[0] = 15;

            return true;
        }


        if (PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGrid(new
                Point(817, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 16;

            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, диагональный \ ряд */
        if (PlayFieldListener.checkInGrid(new
                Point(163, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(817, 861)) && PlayFieldListener.checkInGridKek(new
                Point(163, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(817, 861)) == 0) {
            arrWin[0] = 17;

            return true;
        }

        /* Проверка на победу КРЕСТИКОВ, диагональный / ряд */
        if (PlayFieldListener.checkInGrid(new
                Point(817, 163)) && PlayFieldListener.checkInGrid(new
                Point(490, 523)) && PlayFieldListener.checkInGrid(new
                Point(163, 861)) && PlayFieldListener.checkInGridKek(new
                Point(817, 163)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(490, 523)) == 0 && PlayFieldListener.checkInGridKek(new
                Point(163, 861)) == 0) {
            arrWin[0] = 18;

            return true;
        } else {
            arrWin[0] = 0;
            return false;
        }
    }
}


