package com.example.myapp;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class PlayFieldListener implements View.OnTouchListener {

    static int countStep = 0;
    static float startX = 0;
    static float startY = 0;

    private PlayField3x3 playField;
    Logic logic = new Logic();

    PlayFieldListener(PlayField3x3 playField) {
        this.playField = playField;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Point checkPoint = reCoordinate(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));

        if(Logic.countChangeOrientation % 2 == 0) {
            if (!checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        System.out.println(startX + " " + startY);
                        break;

                    case ACTION_UP:
                        Point point = reCoordinate(new Point((int) PlayFieldListener.startX, (int) PlayFieldListener.startY));
                        if (point != null) {
                            setFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin()) playField.setClickable(false);
                        }
                        break;
                }
            }

        }
        return false;
    }



    static boolean checkInGrid(Point point) {
        for (int i = 0; i != PlayField3x3.cells.size(); i++) {
            if (PlayField3x3.cells != null)
                if (PlayField3x3.cells.get(i).point.equals(point)) return true;
        }
        return false;
    }

    static int checkInGridKek(Point point) {
        for (int i = 0; i != PlayField3x3.cells.size(); i++) {
            if (PlayField3x3.cells != null)
                if (PlayField3x3.cells.get(i).point.equals(point)) return PlayField3x3.cells.get(i).kek;
        }
        return -1;
    }

    private void setFieldCell(Point point) {
        if (countStep % 2 == 0)
            PlayField3x3.cells.add(new Cell(point, 1));

        else
            PlayField3x3.cells.add(new Cell(point, 0));

    }

    private Point reCoordinate(Point point) {

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
        }
        else return null;

    }

//    private Point reCoordinate(Point point) {
//
//        if (point.x > 50 && point.x < 172 && point.y > 200 && point.y < 322) {
//            point.x = 113;
//            point.y = 263;
//            return point;
//        }
//        if (point.x > 180 && point.x < 298 && point.y > 200 && point.y < 322) {
//            point.x = 239;
//            point.y = 263;
//            return point;
//        }
//        if (point.x > 308 && point.x < 436 && point.y > 200 && point.y < 322) {
//            point.x = 372;
//            point.y = 263;
//            return point;
//        }
//        if (point.x > 50 && point.x < 173 && point.y > 328 && point.y < 450) {
//            point.x = 113;
//            point.y = 389;
//            return point;
//        }
//        if (point.x > 180 && point.x < 298 && point.y > 328 && point.y < 450) {
//            point.x = 239;
//            point.y = 389;
//            return point;
//        }
//        if (point.x > 308 && point.x < 436 && point.y > 328 && point.y < 450) {
//            point.x = 372;
//            point.y = 389;
//            return point;
//        }
//        if (point.x > 50 && point.x < 173 && point.y > 454 && point.y < 580) {
//            point.x = 113;
//            point.y = 515;
//            return point;
//        }
//        if (point.x > 180 && point.x < 298 && point.y > 454 && point.y < 580) {
//            point.x = 239;
//            point.y = 515;
//            return point;
//        }
//        if (point.x > 308 && point.x < 436 && point.y > 454 && point.y < 580) {
//            point.x = 372;
//            point.y = 515;
//            return point;
//        } else return null;
//
//    }


}
