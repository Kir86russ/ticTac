package com.example.myapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private Switch aSwitch;
    private boolean flagOnSwitch;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Notification", "AAAAAAAAAAAAAAAAAAAAAAAAASSSSASSSSSSSSSSSSSSSSSSSSSSSSSS");

        intent = new Intent(this, NotificationService.class);//

        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerOnSwitch();
        stopService(intent);//
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(intent);
    }

    public void addListenerOnSwitch() {
        aSwitch = findViewById(R.id.switch2);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) flagOnSwitch = true;
                else flagOnSwitch = false;
            }
        });
    }

    public void addListenerOnButton() {
        button = findViewById(R.id.play);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flagOnSwitch) {
                            Intent intent6x6 = new Intent(getApplicationContext(), Main3Activity.class);
                            startActivity(intent6x6);
                        } else {
                            Intent intent3x3 = new Intent(getApplicationContext(), Main2Activity.class);
                            startActivity(intent3x3);
                        }
                    }
                }
        );
    }
}

