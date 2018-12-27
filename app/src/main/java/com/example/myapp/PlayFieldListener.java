package com.example.myapp;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

class PlayFieldListener implements View.OnTouchListener {

    private float startX = 0;
    private float startY = 0;

    private final PlayField playField;
    private final Logic logic = new Logic();
    private final AIbot bot = new AIbot();

    PlayFieldListener(PlayField playField) {
        this.playField = playField;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        System.out.println(playField.getInfoAboutGrid() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        if (playField.getInfoAboutGrid() == PlayField.InfoAboutGrid._3x3) {

            Cell checkPoint = reCoordinate3x3(new Cell((int) motionEvent.getX(), (int) motionEvent.getY(), null));


            if (checkPoint != null && logic.isEmptyOnCell(checkPoint)) { // null - нажатие на ребро

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:

                        Cell point;
                        if (Logic.countStep % 2 == 0)
                            point = reCoordinate3x3(new Cell((int) startX, (int) startY, Cell.State.TAC));
                        else point = reCoordinate3x3(new Cell((int) startX, (int) startY, Cell.State.TIC));

                        if (point != null) {
                            logic.addFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getInfoAboutGrid() == PlayField.InfoAboutGrid._3x3_bot) { // bot (3x3)

            Cell checkPoint = reCoordinate3x3(new Cell((int) motionEvent.getX(), (int) motionEvent.getY(), null)); // -1 not usable


            if (checkPoint != null && logic.isEmptyOnCell(checkPoint)) {// null - нажатие на ребро

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:

                        Cell point;
                        if (Logic.countStep % 2 == 0)
                            point = reCoordinate3x3(new Cell((int) startX, (int) startY, Cell.State.TAC));
                        else point = reCoordinate3x3(new Cell((int) startX, (int) startY, Cell.State.TIC));

                        if (point != null) {
                            logic.addFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                            else bot.goBy3x3();
                            if (logic.checkWin3x3()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getInfoAboutGrid() == PlayField.InfoAboutGrid._5x5) {

            Cell checkPoint = reCoordinate5x5(new Cell((int) motionEvent.getX(), (int) motionEvent.getY(), null));    // last parameter not usable


            if (checkPoint != null && logic.isEmptyOnCell(checkPoint)) {// null - нажатие на ребро

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:
                        Cell point;
                        if (Logic.countStep % 2 == 0)
                            point = reCoordinate5x5(new Cell((int) startX, (int) startY, Cell.State.TAC));
                        else point = reCoordinate5x5(new Cell((int) startX, (int) startY, Cell.State.TIC));

                        if (point != null) {
                            logic.addFieldCell(point);
                            playField.invalidate();
                            if (logic.checkWin5x5()) playField.setClickable(false);
                        }
                        break;
                }
            }
        } else if (playField.getInfoAboutGrid() == PlayField.InfoAboutGrid._5x5_bot) {

            Cell checkPoint = reCoordinate5x5(new Cell((int) motionEvent.getX(), (int) motionEvent.getY(), null)); // last param no use


            if (checkPoint != null && logic.isEmptyOnCell(checkPoint)) {// null - нажатие на ребро

                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:

                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;

                    case ACTION_UP:

                        Cell point;
                        if (Logic.countStep % 2 == 0)
                            point = reCoordinate5x5(new Cell((int) startX, (int) startY, Cell.State.TAC));
                        else point = reCoordinate5x5(new Cell((int) startX, (int) startY, Cell.State.TIC));

                        if (point != null) {
                            logic.addFieldCell(point);
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


    private Cell reCoordinate3x3(Cell point) {

        if (point.getX() > 0 && point.getX() < playField.getWidth() / 3 && point.getY() > 0 && point.getY() < playField.getHeight() / 3){
            point.setX(1);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() / 3 && point.getX() < playField.getWidth() * 2 / 3 && point.getY() > 0 && point.getY() < playField.getHeight() / 3) {
            point.setX(2);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 3 && point.getX() < playField.getWidth() && point.getY() > 0 && point.getY() < playField.getHeight() / 3) {
            point.setX(3);
            point.setY(1);
            return point;
        }
        if (point.getX() > 0 && point.getX() < playField.getWidth() / 3 && point.getY() > playField.getHeight() / 3 && point.getY() < playField.getHeight() * 2 / 3) {
            point.setX(1);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() / 3 && point.getX() < playField.getWidth() * 2 / 3 && point.getY() > playField.getHeight() / 3 && point.getY() < playField.getHeight() * 2 / 3) {
            point.setX(2);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 3 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() / 3 && point.getY() < playField.getHeight() * 2 / 3) {
            point.setX(3);
            point.setY(2);
            return point;
        }
        if (point.getX() > 0 && point.getX() < playField.getWidth() / 3 && point.getY() > playField.getHeight() * 2 / 3 && point.getY() < playField.getHeight()) {
            point.setX(1);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() / 3 && point.getX() < playField.getWidth() * 2 / 3 && point.getY() > playField.getHeight() * 2 / 3 && point.getY() < playField.getHeight()) {
            point.setX(2);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 3 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() * 2 / 3 && point.getY() < playField.getHeight()) {
            point.setX(3);
            point.setY(3);
            return point;
        } else return null;
    }


    private Cell reCoordinate5x5(Cell point) {
        if (point.getX() > 0 && point.getX() < playField.getWidth() / 5 && point.getY() > 0 && point.getY() < playField.getHeight() / 5) {
            point.setX(1);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() / 5 && point.getX() < playField.getWidth() * 2 / 5 && point.getY() > 0 && point.getY() < playField.getHeight() / 5) {
            point.setX(2);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 5 && point.getX() < playField.getWidth() * 3 / 5 && point.getY() > 0 && point.getY() < playField.getHeight() / 5) {
            point.setX(3);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() * 3 / 5 && point.getX() < playField.getWidth() * 4 / 5 && point.getY() > 0 && point.getY() < playField.getHeight() / 5) {
            point.setX(4);
            point.setY(1);
            return point;
        }
        if (point.getX() > playField.getWidth() * 4 / 5 && point.getX() < playField.getWidth() && point.getY() > 0 && point.getY() < playField.getHeight() / 5) {
            point.setX(5);
            point.setY(1);
            return point;
        }

        if (point.getX() > 0 && point.getX() < playField.getWidth() / 5 && point.getY() > playField.getHeight() / 5 && point.getY() < playField.getHeight() * 2 / 5) {
            point.setX(1);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() / 5 && point.getX() < playField.getWidth() * 2 / 5 && point.getY() > playField.getHeight() / 5 && point.getY() < playField.getHeight() * 2 / 5) {
            point.setX(2);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 5 && point.getX() < playField.getWidth() * 3 / 5 && point.getY() > playField.getHeight() / 5 && point.getY() < playField.getHeight() * 2 / 5) {
            point.setX(3);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() * 3 / 5 && point.getX() < playField.getWidth() * 4 / 5 && point.getY() > playField.getHeight() / 5 && point.getY() < playField.getHeight() * 2 / 5) {
            point.setX(4);
            point.setY(2);
            return point;
        }
        if (point.getX() > playField.getWidth() * 4 / 5 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() / 5 && point.getY() < playField.getHeight() * 2 / 5) {
            point.setX(5);
            point.setY(2);
            return point;
        }

        if (point.getX() > 0 && point.getX() < playField.getWidth() / 5 && point.getY() > playField.getHeight() * 2 / 5 && point.getY() < playField.getHeight() * 3 / 5) {
            point.setX(1);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() / 5 && point.getX() < playField.getWidth() * 2 / 5 && point.getY() > playField.getHeight() * 2 / 5 && point.getY() < playField.getHeight() * 3 / 5) {
            point.setX(2);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 5 && point.getX() < playField.getWidth() * 3 / 5 && point.getY() > playField.getHeight() * 2 / 5 && point.getY() < playField.getHeight() * 3 / 5) {
            point.setX(3);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() * 3 / 5 && point.getX() < playField.getWidth() * 4 / 5 && point.getY() > playField.getHeight() * 2 / 5 && point.getY() < playField.getHeight() * 3 / 5) {
            point.setX(4);
            point.setY(3);
            return point;
        }
        if (point.getX() > playField.getWidth() * 4 / 5 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() * 2 / 5 && point.getY() < playField.getHeight() * 3 / 5) {
            point.setX(5);
            point.setY(3);
            return point;
        }

        if (point.getX() > 0 && point.getX() < playField.getWidth() / 5 && point.getY() > playField.getHeight() * 3 / 5 && point.getY() < playField.getHeight() * 4 / 5) {
            point.setX(1);
            point.setY(4);
            return point;
        }
        if (point.getX() > playField.getWidth() / 5 && point.getX() < playField.getWidth() * 2 / 5 && point.getY() > playField.getHeight() * 3 / 5 && point.getY() < playField.getHeight() * 4 / 5) {
            point.setX(2);
            point.setY(4);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 5 && point.getX() < playField.getWidth() * 3 / 5 && point.getY() > playField.getHeight() * 3 / 5 && point.getY() < playField.getHeight() * 4 / 5) {
            point.setX(3);
            point.setY(4);
            return point;
        }
        if (point.getX() > playField.getWidth() * 3 / 5 && point.getX() < playField.getWidth() * 4 / 5 && point.getY() > playField.getHeight() * 3 / 5 && point.getY() < playField.getHeight() * 4 / 5) {
            point.setX(4);
            point.setY(4);
            return point;
        }
        if (point.getX() > playField.getWidth() * 4 / 5 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() * 3 / 5 && point.getY() < playField.getHeight() * 4 / 5) {
            point.setX(5);
            point.setY(4);
            return point;
        }

        if (point.getX() > 0 && point.getX() < playField.getWidth() / 5 && point.getY() > playField.getHeight() * 4 / 5 && point.getY() < playField.getHeight()) {
            point.setX(1);
            point.setY(5);
            return point;
        }
        if (point.getX() > playField.getWidth() / 5 && point.getX() < playField.getWidth() * 2 / 5 && point.getY() > playField.getHeight() * 4 / 5 && point.getY() < playField.getHeight()) {
            point.setX(2);
            point.setY(5);
            return point;
        }
        if (point.getX() > playField.getWidth() * 2 / 5 && point.getX() < playField.getWidth() * 3 / 5 && point.getY() > playField.getHeight() * 4 / 5 && point.getY() < playField.getHeight()) {
            point.setX(3);
            point.setY(5);
            return point;
        }
        if (point.getX() > playField.getWidth() * 3 / 5 && point.getX() < playField.getWidth() * 4 / 5 && point.getY() > playField.getHeight() * 4 / 5 && point.getY() < playField.getHeight()) {
            point.setX(4);
            point.setY(5);
            return point;
        }
        if (point.getX() > playField.getWidth() * 4 / 5 && point.getX() < playField.getWidth() && point.getY() > playField.getHeight() * 4 / 5 && point.getY() < playField.getHeight()) {
            point.setX(5);
            point.setY(5);
            return point;
        } else return null;
    }

}
