package com.shameer.etree.categoriesClass;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shameer.etree.ConfirmOrdActivity;
import com.shameer.etree.R;
import com.shameer.etree.UpdateSelectedItems;

import java.util.ArrayList;

import projects.DynamicRVAdapter;
import projects.DynamicRVModel;

public class Flower extends AppCompatActivity {
    ImageView backBtn;
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Activity context;
    UpdateSelectedItems updateSelectedItems;
    ImageView cart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Flower.super.onBackPressed();

            }
        });
        cart = findViewById(R.id.cartt);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Flower.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_3);
        recyclerView();

    }

    private void recyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<DynamicRVModel> dynamicLocations = new ArrayList<>();


        dynamicLocations.add(new DynamicRVModel("Red Sensation", R.drawable.redsensation,"RS 1400"));
        dynamicLocations.add(new DynamicRVModel("Flamingo Hydrangea", R.drawable.flamingohydrangea,"RS 2000"));
        dynamicLocations.add(new DynamicRVModel("Peach Drift Rose", R.drawable.peachrose,"RS 2300"));
        dynamicLocations.add(new DynamicRVModel("White Rose", R.drawable.whiterose,"RS 4000"));
        dynamicLocations.add(new DynamicRVModel("Pink Rsoe", R.drawable.pinkrose,"RS 3000"));
        dynamicLocations.add(new DynamicRVModel("Sunny Rose", R.drawable.sunnyrose,"RS 2500"));
        dynamicLocations.add(new DynamicRVModel("August Beauty", R.drawable.augustbeauty,"RS 1400"));
        dynamicLocations.add(new DynamicRVModel("Petite Red Rose", R.drawable.petiteredrose,"RS 2400"));
        dynamicLocations.add(new DynamicRVModel("Daisy Flower", R.drawable.daisy,"RS 1800"));
        dynamicLocations.add(new DynamicRVModel("Sunflower", R.drawable.sunflower,"RS 1700"));


        adapter = new DynamicRVAdapter(dynamicLocations,context,updateSelectedItems);
        recyclerView.setAdapter(adapter);
    }
    }
