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

        if (Logic.countChangeOrientation % 2 == 0) { // PORTRAIT
            Point checkPoint = reCoordinateForPortrait(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));


            if (!checkInGrid(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinateForPortrait(new Point((int) PlayFieldListener.startX, (int) PlayFieldListener.startY));
                        Point point_= fromCellstoCells_(point);

                        if (point != null && point_ != null) {
                            setFieldCell(point);
                            setFieldCell_(point_);//
                            playField.invalidate();
                            if (logic.checkWin()) playField.setClickable(false);
                        }
                        break;
                }
            }

        } else if (Logic.countChangeOrientation % 2 != 0) { // LANDSCAPE
            Point checkPoint = reCoordinateForLandscape(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));

            if (!checkInGrid_(checkPoint)) {

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Point point = reCoordinateForLandscape(new Point((int) PlayFieldListener.startX, (int) PlayFieldListener.startY));
                        Point point_= fromCells_toCells(point);

                        if (point != null && point_ != null) {
                            setFieldCell(point_);
                            setFieldCell_(point);//
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
                if (PlayField3x3.cells.get(i).point.equals(point))
                    return PlayField3x3.cells.get(i).kek;
        }
        return -1;
    }

    static boolean checkInGrid_(Point point) {
        for (int i = 0; i != PlayField3x3.cells_.size(); i++) {
            if (PlayField3x3.cells_ != null && PlayField3x3.cells_.get(i).point != null)
                if (PlayField3x3.cells_.get(i).point.equals(point)) return true;
        }
        return false;
    }

    static int checkInGridKek_(Point point) {
        for (int i = 0; i != PlayField3x3.cells_.size(); i++) {
            if (PlayField3x3.cells_ != null && PlayField3x3.cells_.get(i).point != null)
                if (PlayField3x3.cells_.get(i).point.equals(point))
                    return PlayField3x3.cells_.get(i).kek;
        }
        return -1;
    }

    private void setFieldCell(Point point) {    // ИЗ PORTRAIT
        if (countStep % 2 == 0)
            PlayField3x3.cells.add(new Cell(point, 1));

        else
            PlayField3x3.cells.add(new Cell(point, 0));

    }

    private void setFieldCell_(Point point) {   // ИЗ LANDSPACE
        if (countStep % 2 == 0)
            PlayField3x3.cells_.add(new Cell(point, 1));

        else
            PlayField3x3.cells_.add(new Cell(point, 0));

    }

    private Point reCoordinateForLandscape(Point point) {

        if (point.x > 0 && point.x < 145 && point.y > 0 && point.y < 135) {
            point.x = 72;
            point.y = 67;
            return point;
        }
        if (point.x > 146 && point.x < 288 && point.y > 0 && point.y < 135) {
            point.x = 227;
            point.y = 67;
            return point;
        }
        if (point.x > 289 && point.x < 444 && point.y > 0 && point.y < 135) {
            point.x = 362;
            point.y = 67;
            return point;
        }
        if (point.x > 0 && point.x < 145 && point.y > 135 && point.y < 305) {
            point.x = 72;
            point.y = 222;
            return point;
        }
        if (point.x > 146 && point.x < 288 && point.y > 135 && point.y < 305) {
            point.x = 227;
            point.y = 222;
            return point;
        }
        if (point.x > 289 && point.x < 444 && point.y > 135 && point.y < 305) {
            point.x = 362;
            point.y = 222;
            return point;
        }
        if (point.x > 0 && point.x < 145 && point.y > 305 && point.y < 440) {
            point.x = 72;
            point.y = 377;
            return point;
        }
        if (point.x > 146 && point.x < 288 && point.y > 305 && point.y < 440) {
            point.x = 227;
            point.y = 377;
            return point;
        }
        if (point.x > 289 && point.x < 444 && point.y > 305 && point.y < 440) {
            point.x = 362;
            point.y = 377;
            return point;
        } else return null;

    }

    private Point reCoordinateForPortrait(Point point) {
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

    private Point fromCellstoCells_(Point point){
        Point p = new Point();
        if (point.x == 163 && point.y == 163){
            p.x = 72;
            p.y = 67;
            return p;
        }
        if (point.x == 490 && point.y == 163){
            p.x = 227;
            p.y = 67;
            return p;
        }
        if (point.x == 817 && point.y == 163){
            p.x = 362;
            p.y = 67;
            return p;
        }
        if (point.x == 163 && point.y == 523){
            p.x = 72;
            p.y = 222;
            return p;
        }
        if (point.x == 490 && point.y == 523){
            p.x = 227;
            p.y = 222;
            return p;
        }
        if (point.x == 817 && point.y == 523){
            p.x = 362;
            p.y = 222;
            return p;
        }
        if (point.x == 163 && point.y == 861){
            p.x = 72;
            p.y = 377;
            return p;
        }
        if (point.x == 490 && point.y == 861){
            p.x = 227;
            p.y = 377;
            return p;
        }
        if (point.x == 817 && point.y == 861){
            p.x = 362;
            p.y = 377;
            return p;
        }

        return null;
    }

    private Point fromCells_toCells(Point point){
        Point p = new Point();
        if (point.x == 72 && point.y == 67){
            p.x = 163;
            p.y = 163;
            return p;
        }
        if (point.x == 227 && point.y == 67){
            p.x = 490;
            p.y = 163;
            return p;
        }
        if (point.x == 362 && point.y == 67){
            p.x = 817;
            p.y = 163;
            return p;
        }
        if (point.x == 72 && point.y == 222){
            p.x = 163;
            p.y = 253;
            return p;
        }
        if (point.x == 227 && point.y == 222){
            p.x = 490;
            p.y = 523;
            return p;
        }
        if (point.x == 362 && point.y == 222){
            p.x = 817;
            p.y = 523;
            return p;
        }
        if (point.x == 72 && point.y == 377){
            p.x = 163;
            p.y = 861;
            return p;
        }
        if (point.x == 227 && point.y == 377){
            p.x = 490;
            p.y = 861;
            return p;
        }
        if (point.x == 362 && point.y == 377){
            p.x = 817;
            p.y = 861;
            return p;
        }

        return null;
    }

}
