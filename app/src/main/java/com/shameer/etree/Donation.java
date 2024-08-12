package com.shameer.etree;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import projects.DynamicRVAdapter;
import projects.DynamicRVModel;

public class Donation extends AppCompatActivity {
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
        setContentView(R.layout.activity_donation);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Donation.super.onBackPressed();

            }
        });
        cart = findViewById(R.id.carttttt);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Donation.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_d);
        recyclerView();
    }

    private void recyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<DynamicRVModel> dynamicLocations = new ArrayList<>();

        dynamicLocations.add(new DynamicRVModel("Sycamore Tree", R.drawable.sycamoretree1, "RS 4000"));
        dynamicLocations.add(new DynamicRVModel("Oak Tree", R.drawable.oaktrees1, "RS 5500"));
        dynamicLocations.add(new DynamicRVModel("Silver Maple Tree", R.drawable.silvermaple_1, "RS 7000"));
        dynamicLocations.add(new DynamicRVModel("Tulip Poplar Tree", R.drawable.tulippoplartree, "RS 6000"));
        dynamicLocations.add(new DynamicRVModel("Willow Oak Tree", R.drawable.willo1, "RS 8000"));
        dynamicLocations.add(new DynamicRVModel("Blue Angel Hosta", R.drawable.bluengel, "RS 2400"));
        dynamicLocations.add(new DynamicRVModel("Burning Bush", R.drawable.burning1, "RS 2300"));
        dynamicLocations.add(new DynamicRVModel("Perennial ", R.drawable.perennial1, "RS 1400"));
        dynamicLocations.add(new DynamicRVModel("Sugar Maple Tree", R.drawable.sugarmaple1, "RS 7000"));
        dynamicLocations.add(new DynamicRVModel("Sassafras Tree", R.drawable.sassafrastree, "RS 12000"));
        dynamicLocations.add(new DynamicRVModel("Crepe Myrtle Tree", R.drawable.crepe1, "RS 9000"));
        dynamicLocations.add(new DynamicRVModel("White Princess", R.drawable.whiteprincess1, "RS 14000"));
        dynamicLocations.add(new DynamicRVModel("Silver-maple", R.drawable.silvermaple2, "RS 7000"));
        dynamicLocations.add(new DynamicRVModel("xanaduwinterbourn", R.drawable.xanadu, "RS 2800"));
        dynamicLocations.add(new DynamicRVModel("Pink Rsoe", R.drawable.pinkrose, "RS 3000"));
        dynamicLocations.add(new DynamicRVModel("Perennial Foam", R.drawable.perennial2, "RS 1800"));
        dynamicLocations.add(new DynamicRVModel("Shasta Daisy", R.drawable.daisy1, "RS 800"));
        dynamicLocations.add(new DynamicRVModel("Periwinkle Plants", R.drawable.periwinkle1, "RS 2000"));
        dynamicLocations.add(new DynamicRVModel("Hay Scented Fern", R.drawable.hay2, "RS 1200"));
        adapter = new DynamicRVAdapter(dynamicLocations,context,updateSelectedItems);
        recyclerView.setAdapter(adapter);
    }
}