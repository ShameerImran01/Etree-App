package com.shameer.etree;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class ConfirmOrderAddress extends AppCompatActivity {
    ImageView backBtn;
    Button  regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.confirm_orderr);


        regbtn = findViewById(R.id.con);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thank();
            }
        });

        backBtn = findViewById(R.id.COA_back_button);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ConfirmOrderAddress.super.onBackPressed();

            }
        });
    }

    private void thank() {
        Intent intent = new Intent(this, Thanks.class);
        startActivity(intent);

    }

}