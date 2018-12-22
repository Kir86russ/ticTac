package com.example.myapp;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class PlayFieldListener implements View.OnTouchListener {

    private float startX = 0;
    private float startY = 0;

    private PlayField playField;
    private Logic logic = new Logic();
    private bot bot = new bot();

    PlayFieldListener(PlayField playField) {
        this.playField = playField;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        if (playField.getFlagAboutGrid() == 3) {

            Point checkPoint = reCoordinate3x3(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));


            if (!logic.checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinate3x3(new Point((int) startX, (int) startY));

                        if (point != null) {
                            logic.setFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getFlagAboutGrid() == 4) { // bot (3x3)

            Point checkPoint = reCoordinate3x3(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));


            if (!logic.checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinate3x3(new Point((int) startX, (int) startY));

                        if (point != null) {
                            logic.setFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                            else bot.goBy3x3();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getFlagAboutGrid() == 5) {

            Point checkPoint = reCoordinate5x5(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));


            if (!logic.checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinate5x5(new Point((int) startX, (int) startY));

                        if (point != null) {
                            logic.setFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin5x5()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getFlagAboutGrid() == 6) {

            Point checkPoint = reCoordinate5x5(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));


            if (!logic.checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinate5x5(new Point((int) startX, (int) startY));

                        if (point != null) {
                            logic.setFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin5x5()) playField.setClickable(false);
                            else bot.goBy5x5();
                            if (logic.checkWin5x5()) playField.setClickable(false);
                        }
                        break;
                }
            }
        }
        return false;
    }


    private Point reCoordinate3x3(Point point) {
        if (point.x > 0 && point.x < 327 && point.y > 0 && point.y < 349) {
            point.x = 163;
            point.y = 163;
            return point;
        }
        if (point.x > 328 && point.x < 654 && point.y > 0 && point.y < 349) {
            point.x = 490;
            point.y = 163;
            return point;
        }
        if (point.x > 655 && point.x < 982 && point.y > 0 && point.y < 349) {
            point.x = 817;
            point.y = 163;
            return point;
        }
        if (point.x > 0 && point.x < 327 && point.y > 350 && point.y < 700) {
            point.x = 163;
            point.y = 523;
            return point;
        }
        if (point.x > 328 && point.x < 654 && point.y > 350 && point.y < 700) {
            point.x = 490;
            point.y = 523;
            return point;
        }
        if (point.x > 655 && point.x < 982 && point.y > 350 && point.y < 700) {
            point.x = 817;
            point.y = 523;
            return point;
        }
        if (point.x > 0 && point.x < 327 && point.y > 701 && point.y < 1048) {
            point.x = 163;
            point.y = 861;
            return point;
        }
        if (point.x > 328 && point.x < 654 && point.y > 701 && point.y < 1048) {
            point.x = 490;
            point.y = 861;
            return point;
        }
        if (point.x > 655 && point.x < 982 && point.y > 701 && point.y < 1048) {
            point.x = 817;
            point.y = 861;
            return point;
        } else return null;
    }


    private Point reCoordinate5x5(Point point) {
        if (point.x > 13 && point.x < 186 && point.y > 12 && point.y < 196) {
            point.x = 102;
            point.y = 104;
            return point;
        }
        if (point.x > 209 && point.x < 382 && point.y > 12 && point.y < 196) {
            point.x = 297;
            point.y = 104;
            return point;
        }
        if (point.x > 406 && point.x < 582 && point.y > 12 && point.y < 196) {
            point.x = 496;
            point.y = 104;
            return point;
        }
        if (point.x > 603 && point.x < 783 && point.y > 12 && point.y < 196) {
            point.x = 695;
            point.y = 104;
            return point;
        }
        if (point.x > 802 && point.x < 966 && point.y > 12 && point.y < 196) {
            point.x = 886;
            point.y = 104;
            return point;
        }

        if (point.x > 13 && point.x < 186 && point.y > 220 && point.y < 411) {
            point.x = 102;
            point.y = 312;
            return point;
        }
        if (point.x > 209 && point.x < 382 && point.y > 220 && point.y < 411) {
            point.x = 297;
            point.y = 312;
            return point;
        }
        if (point.x > 406 && point.x < 582 && point.y > 220 && point.y < 411) {
            point.x = 496;
            point.y = 312;
            return point;
        }
        if (point.x > 603 && point.x < 783 && point.y > 220 && point.y < 411) {
            point.x = 695;
            point.y = 312;
            return point;
        }
        if (point.x > 802 && point.x < 966 && point.y > 220 && point.y < 411) {
            point.x = 886;
            point.y = 312;
            return point;
        }

        if (point.x > 13 && point.x < 186 && point.y > 434 && point.y < 622) {
            point.x = 102;
            point.y = 525;
            return point;
        }
        if (point.x > 209 && point.x < 382 && point.y > 434 && point.y < 622) {
            point.x = 297;
            point.y = 525;
            return point;
        }
        if (point.x > 406 && point.x < 582 && point.y > 434 && point.y < 622) {
            point.x = 496;
            point.y = 525;
            return point;
        }
        if (point.x > 603 && point.x < 783 && point.y > 434 && point.y < 622) {
            point.x = 695;
            point.y = 525;
            return point;
        }
        if (point.x > 802 && point.x < 966 && point.y > 434 && point.y < 622) {
            point.x = 886;
            point.y = 525;
            return point;
        }

        if (point.x > 13 && point.x < 186 && point.y > 645 && point.y < 833) {
            point.x = 102;
            point.y = 735;
            return point;
        }
        if (point.x > 209 && point.x < 382 && point.y > 645 && point.y < 833) {
            point.x = 297;
            point.y = 735;
            return point;
        }
        if (point.x > 406 && point.x < 582 && point.y > 645 && point.y < 833) {
            point.x = 496;
            point.y = 735;
            return point;
        }
        if (point.x > 603 && point.x < 783 && point.y > 645 && point.y < 833) {
            point.x = 695;
            point.y = 735;
            return point;
        }
        if (point.x > 802 && point.x < 966 && point.y > 645 && point.y < 833) {
            point.x = 886;
            point.y = 735;
            return point;
        }

        if (point.x > 13 && point.x < 186 && point.y > 856 && point.y < 1041) {
            point.x = 102;
            point.y = 946;
            return point;
        }
        if (point.x > 209 && point.x < 382 && point.y > 856 && point.y < 1041) {
            point.x = 297;
            point.y = 946;
            return point;
        }
        if (point.x > 406 && point.x < 582 && point.y > 856 && point.y < 1041) {
            point.x = 496;
            point.y = 946;
            return point;
        }
        if (point.x > 603 && point.x < 783 && point.y > 856 && point.y < 1041) {
            point.x = 695;
            point.y = 946;
            return point;
        }
        if (point.x > 802 && point.x < 966 && point.y > 856 && point.y < 1041) {
            point.x = 886;
            point.y = 946;
            return point;
        } else return null;
    }

}
