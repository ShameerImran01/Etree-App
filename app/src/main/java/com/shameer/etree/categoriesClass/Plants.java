package com.shameer.etree.categoriesClass;

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

public class Plants extends AppCompatActivity {
    ImageView backBtn;
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Activity context;
    int pos;
    UpdateSelectedItems updateSelectedItems;

    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
        backBtn = findViewById(R.id.back_pressed);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Plants.super.onBackPressed();

            }
        });
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Plants.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_2);
        recyclerView();

    }

    private void recyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<DynamicRVModel> dynamicLocations = new ArrayList<>();

        dynamicLocations.add(new DynamicRVModel("Aloe Plant", R.drawable.aloeplant, "RS 1100"));
        dynamicLocations.add(new DynamicRVModel("Arabica Coffee Plant", R.drawable.arabiccoffeelantx, "RS 1300"));

        dynamicLocations.add(new DynamicRVModel("Devils trumpet", R.drawable.devilstrumpet, "RS 800"));
        dynamicLocations.add(new DynamicRVModel("Raspberry", R.drawable.raspberry, "RS 3600"));
        dynamicLocations.add(new DynamicRVModel("Peace Lily", R.drawable.peacily, "RS 2800"));
        dynamicLocations.add(new DynamicRVModel("Snake Plant", R.drawable.snakelant, "RS 2000"));
        dynamicLocations.add(new DynamicRVModel("phenomenaL", R.drawable.phenomenal, "RS 4500"));
        dynamicLocations.add(new DynamicRVModel("Spider Plant", R.drawable.spiderplan, "RS 2300"));
        dynamicLocations.add(new DynamicRVModel("Blue Angel Hosta", R.drawable.bluengel, "RS 2400"));

        dynamicLocations.add(new DynamicRVModel("White Jade", R.drawable.whiterose, "RS 1600"));
        dynamicLocations.add(new DynamicRVModel("xanaduwinterbourn", R.drawable.xanadu, "RS 2800"));

        adapter = new DynamicRVAdapter(dynamicLocations,context,updateSelectedItems);
        recyclerView.setAdapter(adapter);
    }


}