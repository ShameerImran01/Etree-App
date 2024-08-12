package com.shameer.etree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class StartupScreen extends AppCompatActivity {

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);

        button = (Button) findViewById(R.id.buttonnn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartupScreen.super.onBackPressed();
            }
        });
    }
}