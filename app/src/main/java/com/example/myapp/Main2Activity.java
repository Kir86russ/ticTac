package com.example.myapp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class Main2Activity extends AppCompatActivity {
    PlayField3x3 playField;
    ConstraintLayout layout;
    FrameLayout frame;
    Button button; // restart


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        playField = new PlayField3x3(this);

        layout = (ConstraintLayout) findViewById(R.id.q);
//        layout.addView(playField);

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
}