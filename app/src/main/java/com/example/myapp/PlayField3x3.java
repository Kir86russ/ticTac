package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

// https://online-fotoshop.ru/ubrat-fon-online/
import java.util.ArrayList;

public class PlayField3x3 extends View {
    TextView cX;
    TextView cO;

    Drawable imageKrestik = getResources().getDrawable(R.drawable.xxx);
    Drawable imageNolik = getResources().getDrawable(R.drawable.nullik);


    public static ArrayList<Cell> cells = new ArrayList<>();
    Logic logic = new Logic();


    Context context;
    Paint paint = new Paint();

    public PlayField3x3(Context context) {
        super(context);
        this.context = context;

        cX = ((Main2Activity) context).findViewById(R.id.countWinX);
        cO = ((Main2Activity) context).findViewById(R.id.countWinO);

        this.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));

        this.setClickable(true);

        this.setOnTouchListener(new PlayFieldListener(this));

        startGame();
    }


    public void startGame() {
        invalidate();
    }

    public void restartGame() {
        cells.clear();
        invalidate();
    }

    public void exitGame(){
        cells.clear();
        Logic.winX = 0;
        Logic.winO = 0;
        PlayFieldListener.countStep = 0;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        /* build grid */
        paint.setColor(Color.WHITE);
                                            // canvas.drawRect(50, 200, 430, 580, paint);
        paint.setColor(Color.rgb(255, 162, 0));
        paint.setStrokeWidth(20);
//        canvas.drawLine(126, 0, 126, 378, paint);
//        canvas.drawLine(252, 0, 252, 378, paint);

//        canvas.drawLine(0, 126, 378, 126, paint);
//        canvas.drawLine(0, 252, 378, 252, paint);


        /* build x|o */
        for (int i = 0; i != cells.size(); i++) {

            if (cells.get(i).kek == 0) {

                imageKrestik.setBounds(cells.get(i).point.x - 85, cells.get(i).point.y - 85, cells.get(i).point.x + 85, cells.get(i).point.y + 85);
                imageKrestik.draw(canvas);

            } else {

                imageNolik.setBounds(cells.get(i).point.x - 85, cells.get(i).point.y - 85, cells.get(i).point.x + 85, cells.get(i).point.y + 85);
                imageNolik.draw(canvas);

            }

        }

        PlayFieldListener.countStep++;


        if (logic.checkWin()) {


            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);

            switch (logic.arrWin[0]) {
                case 1:
                    canvas.drawLine(163, 163, 817, 163, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 2:
                    canvas.drawLine(163, 523, 817, 523, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 3:
                    canvas.drawLine(163, 861, 817, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 4:
                    canvas.drawLine(163, 163, 163, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 5:
                    canvas.drawLine(490, 163, 490, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 6:
                    canvas.drawLine(817, 163, 817, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 7:
                    canvas.drawLine(163, 163, 817, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 8:
                    canvas.drawLine(817, 163, 163, 861, paint);
                    Logic.winO++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;


                case 11:
                    canvas.drawLine(163, 163, 817, 163, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 12:
                    canvas.drawLine(163, 523, 817, 523, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 13:
                    canvas.drawLine(163, 861, 817, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 14:
                    canvas.drawLine(163, 163, 163, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 15:
                    canvas.drawLine(490, 163, 490, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 16:
                    canvas.drawLine(817, 163, 817, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 17:
                    canvas.drawLine(163, 163, 817, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
                case 18:
                    canvas.drawLine(817, 163, 163, 861, paint);
                    Logic.winX++;
                    cO.setText(String.valueOf(Logic.winO));
                    break;
            }

        }

    }


}

