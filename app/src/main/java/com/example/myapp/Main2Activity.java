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
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    PlayField3x3 playField;
    ConstraintLayout layout;
    FrameLayout frame;


    Logic logic = new Logic();
    Button button; // restart


    TextView cX;
    TextView cO;

    static int strcX;
    static int strcO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        playField = new PlayField3x3(this);

        layout = (ConstraintLayout) findViewById(R.id.q);


        frame = (FrameLayout) findViewById(R.id.frameLayout);
        ConstraintLayout.LayoutParams params_lay = (ConstraintLayout.LayoutParams) frame.getLayoutParams();

        if (Logic.countChangeOrientation % 2 != 0){
            params_lay.width = 450;
            params_lay.height = 450;
            frame.setLayoutParams(params_lay);
        }

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

        PlayFieldListener.countStep--;

        cX = findViewById(R.id.countWinX);
        cO = findViewById(R.id.countWinO);

        strcX = Integer.parseInt((String) cX.getText());
        strcO = Integer.parseInt((String) cO.getText());


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        cX = findViewById(R.id.countWinX);
        cO = findViewById(R.id.countWinO);


        cX.setText(String.valueOf(strcX));
        cO.setText(String.valueOf(strcO));


        frame = (FrameLayout) findViewById(R.id.frameLayout);
        ConstraintLayout.LayoutParams params_lay = (ConstraintLayout.LayoutParams) frame.getLayoutParams();

        if (Logic.countChangeOrientation % 2 == 0) {
            params_lay.width = 450;
            params_lay.height = 450;

        } else if (Logic.countChangeOrientation % 2 != 0) {
            frame.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }

        frame.setLayoutParams(params_lay);
        Logic.countChangeOrientation++;


    }
}