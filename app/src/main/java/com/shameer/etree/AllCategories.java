package com.shameer.etree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.shameer.etree.categoriesClass.Bushes;
import com.shameer.etree.categoriesClass.Flower;
import com.shameer.etree.categoriesClass.Plants;
import com.shameer.etree.categoriesClass.Tree;

public class AllCategories extends AppCompatActivity {
    ImageView backBtn, cart;
    Button first,second,third,forth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);

        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AllCategories.super.onBackPressed();

            }
        });
        cart = findViewById(R.id.cartttttt);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllCategories.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });

        first = (Button) findViewById(R.id.tree2);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trees();
            }
        });


        second = (Button) findViewById(R.id.plants2);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plant();
            }
        });


        third = (Button) findViewById(R.id.bushe2);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bushe();
            }
        });


        forth = (Button) findViewById(R.id.flower2);
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flower();
            }
        });


    }

    private void flower() {
        Intent intent = new Intent(this, Flower.class);
        startActivity(intent);
    }

    private void bushe() {
        Intent intent = new Intent(this, Bushes.class);
        startActivity(intent);

    }

    private void plant() {
        Intent intent = new Intent(this, Plants.class);
        startActivity(intent);
    }

    private void trees() {
        Intent intent = new Intent(this, Tree.class);
        startActivity(intent);
    }
}