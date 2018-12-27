package com.example.myapp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class Activity3x3 extends AppCompatActivity {
    private PlayField playField;
    private ConstraintLayout layout;
    private FrameLayout frame;

    private Button button;

    private TextView cX;
    private TextView cO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        cX = findViewById(R.id.countWinX);
        cO = findViewById(R.id.countWinO);
        playField = new PlayField(this, PlayField.InfoAboutGrid._3x3, cX, cO);


        layout = findViewById(R.id.q);
        frame = findViewById(R.id.frameLayout);

        frame.setBackgroundResource(R.drawable.grido);

        frame.addView(playField);

        layout.setBackgroundResource(R.drawable.back_notebook2);
        addListenerOnButton();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            playField.exitGame();

        }
        return super.onKeyDown(keyCode, event);
    }


    private void addListenerOnButton() {
        button = findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playField.setClickable(true);
                        Logic.countStep = 0;
                        playField.restartGame();
                    }
                }
        );
    }
    private int[] arrX = new int[9];
    private int[] arrY = new int[9];
    private int[] arrTicOrTac = new int[9];
    private Cell.State ticOrTac;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int index = 0;
        for (int i = 0; i != Logic.cells.size(); i++) {
            if (Logic.cells.get(i).getX() != 0 && Logic.cells.get(i).getY() != 0) {
                arrX[index] = Logic.cells.get(i).getX();
                arrY[index] = Logic.cells.get(i).getY();
                if (Logic.cells.get(i).state == Cell.State.TIC) arrTicOrTac[index] = 1;
                else if (Logic.cells.get(i).state == Cell.State.TIC) arrTicOrTac[index] = 0;
                index++;
            }
        }
        outState.putInt("winX", Logic.winX);
        outState.putInt("winO", Logic.winO);
        outState.putInt("countStep", Logic.countStep);
        outState.putIntArray("coordinates_x", arrX);
        outState.putIntArray("coordinates_y", arrY);
        outState.putIntArray("tic_or_tac", arrTicOrTac);


        if (Logic.infoTeamWin == Logic.InfoTeamWin.WIN_TIC) Logic.winX--;
        if (Logic.infoTeamWin == Logic.InfoTeamWin.WIN_TAC) Logic.winO--;

        Logic.countStep--;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logic.cells.clear();
        for (int i = 0; i != arrTicOrTac.length; i++) {
            System.out.println(arrTicOrTac.length);
            if (savedInstanceState.getIntArray("tic_or_tac")[i] == 1) ticOrTac = Cell.State.TIC;
            else ticOrTac = Cell.State.TAC;

            Logic.cells.add(new Cell(savedInstanceState.getIntArray("coordinates_x")[i], savedInstanceState.getIntArray("coordinates_y")[i], ticOrTac));
        }



        cX = findViewById(R.id.countWinX);
        cO = findViewById(R.id.countWinO);

        cX.setText(String.valueOf(Logic.winX));
        cO.setText(String.valueOf(Logic.winO));
    }
}