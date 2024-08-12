package com.shameer.etree;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Privacy extends AppCompatActivity {
    ImageView backBtn;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

    backBtn = findViewById(R.id.privacy_back_button);
        backBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Privacy.super.onBackPressed();

        }
    });

}}
