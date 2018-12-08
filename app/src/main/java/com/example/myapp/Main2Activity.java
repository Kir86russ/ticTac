package com.example.myapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class Main2Activity extends AppCompatActivity {
    PlayField3x3 playField;
    ConstraintLayout layout;
    FrameLayout frame;


    Logic logic = new Logic();
    Button button; // restart


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        playField = new PlayField3x3(this);

        layout = (ConstraintLayout) findViewById(R.id.q);


        frame = (FrameLayout) findViewById(R.id.frameLayout);
        frame.setBackgroundResource(R.drawable.grido);

        frame.addView(playField);

        layout.setBackgroundResource(R.drawable.back_notebook2);
        addListenerOnButton();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            playField.exitGame();
        return super.onKeyDown(keyCode, event);
    }


    public void addListenerOnButton() {
        button = findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playField.setClickable(true);
                        PlayFieldListener.countStep = 0;
                        playField.restartGame();
                    }
                }
        );
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) { // смена ориентации


        super.onSaveInstanceState(outState);

        Logic.countChangeOrientation++;

        if (logic.checkWin()) {
            if (Logic.arrWin[0] >= 1 && Logic.arrWin[0] <= 8)
                Logic.winO--;
            else if (Logic.arrWin[0] >= 11 && Logic.arrWin[0] <= 18)
                Logic.winX--;
        }


        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1");
    }


    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        frame = (FrameLayout) findViewById(R.id.frameLayout);

        ConstraintLayout.LayoutParams params_lay = (ConstraintLayout.LayoutParams) frame.getLayoutParams();
        params_lay.width = 450;
        params_lay.height = 450;
        frame.setLayoutParams(params_lay);


        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2" + " " + Logic.countChangeOrientation);
    }
}