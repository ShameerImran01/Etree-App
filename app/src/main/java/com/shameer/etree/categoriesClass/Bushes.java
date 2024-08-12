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

public class Bushes extends AppCompatActivity {
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
        setContentView(R.layout.activity_bushes);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Bushes.super.onBackPressed();

            }
        });
        cart = findViewById(R.id.carttt);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bushes.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_b);
        recyclerView();
    }

    private void recyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<DynamicRVModel> dynamicLocations = new ArrayList<>();

        dynamicLocations.add(new DynamicRVModel("Burning Bush", R.drawable.burning1,"RS 2300"));
        dynamicLocations.add(new DynamicRVModel("Perennial ", R.drawable.perennial1,"RS 1400"));
        dynamicLocations.add(new DynamicRVModel("Daffodil", R.drawable.daffodils1,"RS 1200"));
        dynamicLocations.add(new DynamicRVModel("Bridal Wreath Spiraea", R.drawable.bridal1,"RS 4000"));
        dynamicLocations.add(new DynamicRVModel("Perennial Foam", R.drawable.perennial2,"RS 1800"));
        dynamicLocations.add(new DynamicRVModel("Shasta Daisy", R.drawable.daisy1, "RS 800"));
        dynamicLocations.add(new DynamicRVModel("Periwinkle Plants", R.drawable.periwinkle1, "RS 2000"));
        dynamicLocations.add(new DynamicRVModel("Arrowhead plant", R.drawable.arrowhead1, "RS 2700"));
        dynamicLocations.add(new DynamicRVModel("Hay Scented Fern", R.drawable.hay2,"RS 1200"));
        dynamicLocations.add(new DynamicRVModel("Golden Bell Forsythia1", R.drawable.golden1, "RS 1600"));

        adapter = new DynamicRVAdapter(dynamicLocations,context,updateSelectedItems);
        recyclerView.setAdapter(adapter);
    }
}