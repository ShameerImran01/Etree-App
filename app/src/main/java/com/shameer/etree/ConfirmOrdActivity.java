package com.shameer.etree;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ConfirmOrdActivity extends AppCompatActivity {
    public Button button;
     RecyclerView orderRv;
     ConfirmOrdActivityAdapter confirmOrdActivityAdapter;
     Activity context;
     UpdateSelectedItems updateSelectedItems;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_ord);

        Toolbar toolbar=findViewById(R.id.toolbar2);
        toolbar.setTitle("Confirm Order");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmOrdActivity.this, ConfirmOrderAddress.class);
                startActivity(intent);
            }
        });
        orderRv = findViewById(R.id.order_rv);
        confirmOrdActivityAdapter = new ConfirmOrdActivityAdapter(context);
        orderRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        orderRv.setAdapter(confirmOrdActivityAdapter);

    }
}