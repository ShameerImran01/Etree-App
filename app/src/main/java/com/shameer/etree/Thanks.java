package com.shameer.etree;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class Thanks extends AppCompatActivity {
    ImageView backBtn;
    Button  cButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.thanks);


        cButton = findViewById(R.id.ContinueB);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue();
            }
        });

        backBtn = findViewById(R.id.backbutton);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Thanks.super.onBackPressed();

            }
        });
    }

    private void Continue() {
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);

    }

}