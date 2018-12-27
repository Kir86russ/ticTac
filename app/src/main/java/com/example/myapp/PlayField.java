package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

// https://online-fotoshop.ru/ubrat-fon-online/

@SuppressLint("ViewConstructor")
public class PlayField extends View {

    enum InfoAboutGrid {_3x3, _5x5, _3x3_bot, _5x5_bot}

    public InfoAboutGrid getInfoAboutGrid() {
        return infoAboutGrid;
    }

    private InfoAboutGrid infoAboutGrid;

    private TextView cX;
    private TextView cO;

    private final Drawable imageTic = getResources().getDrawable(R.drawable.xxx);
    private final Drawable imageTac = getResources().getDrawable(R.drawable.nullik);

    private final Logic logic = new Logic();


    private final Context context;
    private final Paint paint = new Paint();

    public PlayField(Context context, InfoAboutGrid infoAboutGrid, TextView countWinX, TextView countWinO) {
        super(context);

        this.context = context;
        this.infoAboutGrid = infoAboutGrid;
        this.cX = countWinX;
        this.cO = countWinO;

        this.setClickable(true);
        this.setOnTouchListener(new PlayFieldListener(this));

        startGame();
    }


    private void startGame() {
        invalidate();
    }

    public void restartGame() {
        Logic.cells.clear();
        Logic.infoTeamWin = null;
        invalidate();
    }

    public void exitGame() {
        Logic.cells.clear();
        Logic.winX = 0;
        Logic.winO = 0;
        Logic.infoTeamWin = null;
        Logic.countStep = 0;

    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int dx;
        int dy;

        super.onDraw(canvas);

        if (Logic.infoTeamWin != null) {
            this.setClickable(false); // если победа на доске нарисована
        }

        /* build x|o */
        if (this.infoAboutGrid == InfoAboutGrid._3x3 || this.infoAboutGrid == InfoAboutGrid._3x3_bot) {

            final int shift = this.getWidth() / 12;

            for (int i = 0; i != Logic.cells.size(); i++) {

                dx = Logic.cells.get(i).getX();
                dy = Logic.cells.get(i).getY();

                if (Logic.cells.get(i).state == Cell.State.TIC) {

                    imageTic.setBounds(this.getWidth() / 6 * (2 * dx - 1) - shift, this.getHeight() / 6 * (2 * dy - 1) - shift, this.getWidth() / 6 * (2 * dx - 1) + shift, this.getHeight() / 6 * (2 * dy - 1) + shift);
                    imageTic.draw(canvas);

                } else if (Logic.cells.get(i).state == Cell.State.TAC) {

                    imageTac.setBounds(this.getWidth() / 6 * (2 * dx - 1) - shift, this.getHeight() / 6 * (2 * dy - 1) - shift, this.getWidth() / 6 * (2 * dx - 1) + shift, this.getHeight() / 6 * (2 * dy - 1) + shift);
                    imageTac.draw(canvas);

                }
            }
        }

        if (this.infoAboutGrid == InfoAboutGrid._5x5 || this.infoAboutGrid == InfoAboutGrid._5x5_bot) {

            final int shift = this.getWidth() / 20;

            for (int i = 0; i != Logic.cells.size(); i++) {

                dx = Logic.cells.get(i).getX();
                dy = Logic.cells.get(i).getY();

                if (Logic.cells.get(i).state == Cell.State.TIC) {

                    imageTic.setBounds(this.getWidth() / 10 * (2 * dx - 1) - shift, this.getHeight() / 10 * (2 * dy - 1) - shift, this.getWidth() / 10 * (2 * dx - 1) + shift, this.getHeight() / 10 * (2 * dy - 1) + shift);
                    imageTic.draw(canvas);

                } else if (Logic.cells.get(i).state == Cell.State.TAC) {

                    imageTac.setBounds(this.getWidth() / 10 * (2 * dx - 1) - shift, this.getHeight() / 10 * (2 * dy - 1) - shift, this.getWidth() / 10 * (2 * dx - 1) + shift, this.getHeight() / 10 * (2 * dy - 1) + shift);
                    imageTac.draw(canvas);

                }

            }
        }


        Logic.countStep++;


        if ((this.infoAboutGrid == InfoAboutGrid._3x3 || this.infoAboutGrid == InfoAboutGrid._3x3_bot) && logic.checkWin3x3()) {

            paint.setColor(getResources().getColor(R.color.blue));
            paint.setStrokeWidth(20);

            switch (logic.infoWin) {
                case 1:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() / 6, paint);
                    Logic.winO++;
                    break;
                case 2:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() * 3 / 6, this.getWidth() * 5 / 6, this.getHeight() * 3 / 6, paint);
                    Logic.winO++;
                    break;
                case 3:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() * 5 / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;
                case 4:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;
                case 5:
                    canvas.drawLine(this.getWidth() * 3 / 6, this.getHeight() / 6, this.getWidth() * 3 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;
                case 6:
                    canvas.drawLine(this.getWidth() * 5 / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;
                case 7:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;
                case 8:
                    canvas.drawLine(this.getWidth() * 5 / 6, this.getHeight() / 6, this.getWidth() / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winO++;
                    break;


                case 11:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() / 6, paint);
                    Logic.winX++;
                    break;
                case 12:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() * 3 / 6, this.getWidth() * 5 / 6, this.getHeight() * 3 / 6, paint);
                    Logic.winX++;
                    break;
                case 13:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() * 5 / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
                case 14:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
                case 15:
                    canvas.drawLine(this.getWidth() * 3 / 6, this.getHeight() / 6, this.getWidth() * 3 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
                case 16:
                    canvas.drawLine(this.getWidth() * 5 / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
                case 17:
                    canvas.drawLine(this.getWidth() / 6, this.getHeight() / 6, this.getWidth() * 5 / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
                case 18:
                    canvas.drawLine(this.getWidth() * 5 / 6, this.getHeight() / 6, this.getWidth() / 6, this.getHeight() * 5 / 6, paint);
                    Logic.winX++;
                    break;
            }
            cO.setText(String.valueOf(Logic.winO));
            cX.setText(String.valueOf(Logic.winX));
        }


        if ((this.infoAboutGrid == InfoAboutGrid._5x5 || this.infoAboutGrid == InfoAboutGrid._5x5_bot) && logic.checkWin5x5()) {

            paint.setColor(getResources().getColor(R.color.blue));
            paint.setStrokeWidth(15);

            switch (logic.infoWin) {
                case 1:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 2:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 3 / 10, this.getWidth() * 9 / 10, this.getHeight() * 3 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 3:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 5 / 10, this.getWidth() * 9 / 10, this.getHeight() * 5 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 31:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 7 / 10, this.getWidth() * 9 / 10, this.getHeight() * 7 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 32:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 9 / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 4:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 5:
                    canvas.drawLine(this.getWidth() * 3 / 10, this.getHeight() / 10, this.getWidth() * 3 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 6:
                    canvas.drawLine(this.getWidth() * 5 / 10, this.getHeight() / 10, this.getWidth() * 5 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 61:
                    canvas.drawLine(this.getWidth() * 7 / 10, this.getHeight() / 10, this.getWidth() * 7 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 62:
                    canvas.drawLine(this.getWidth() * 9 / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 7:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 8:
                    canvas.drawLine(this.getWidth() * 9 / 10, this.getHeight() / 10, this.getWidth() / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;


                case 11:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() / 10, paint);
                    Logic.winX++;
                    break;
                case 12:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 3 / 10, this.getWidth() * 9 / 10, this.getHeight() * 3 / 10, paint);
                    Logic.winX++;
                    break;
                case 13:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 5 / 10, this.getWidth() * 9 / 10, this.getHeight() * 5 / 10, paint);
                    Logic.winX++;
                    break;
                case 131:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 7 / 10, this.getWidth() * 9 / 10, this.getHeight() * 7 / 10, paint);
                    Logic.winX++;
                    break;
                case 132:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() * 9 / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 14:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 15:
                    canvas.drawLine(this.getWidth() * 3 / 10, this.getHeight() / 10, this.getWidth() * 3 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 16:
                    canvas.drawLine(this.getWidth() * 5 / 10, this.getHeight() / 10, this.getWidth() * 5 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 161:
                    canvas.drawLine(this.getWidth() * 7 / 10, this.getHeight() / 10, this.getWidth() * 7 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 162:
                    canvas.drawLine(this.getWidth() * 9 / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 17:
                    canvas.drawLine(this.getWidth() / 10, this.getHeight() / 10, this.getWidth() * 9 / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
                case 18:
                    canvas.drawLine(this.getWidth() * 9 / 10, this.getHeight() / 10, this.getWidth() / 10, this.getHeight() * 9 / 10, paint);
                    Logic.winX++;
                    break;
            }
            cO.setText(String.valueOf(Logic.winO));
            cX.setText(String.valueOf(Logic.winX));
        }

    }


}

