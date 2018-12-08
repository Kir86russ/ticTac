package com.example.myapp;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {
    ConstraintLayout layout;
    Button button; // restart

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        layout = (ConstraintLayout) findViewById(R.id.p);

     //   addListenerOnButton();
    }

//    public void addListenerOnButton() {
//        button = findViewById(R.id.b);
//
//        button.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        playField.setClickable(true);
//                        PlayFieldListener.countStep = 0;
//                        playField.restartGame();
//                    }
//                }
//        );
//    }
}
