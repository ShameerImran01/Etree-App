package com.shameer.etree;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.shameer.etree.categoriesClass.Bushes;
import com.shameer.etree.categoriesClass.Flower;
import com.shameer.etree.categoriesClass.Plants;
import com.shameer.etree.categoriesClass.Tree;
import com.shameer.etree.helperClass.CategoriesAdapter;
import com.shameer.etree.helperClass.CategoriesHelperClass;
import com.shameer.etree.helperClass.Contact;
import com.shameer.etree.helperClass.FeaturedAdapter;
import com.shameer.etree.helperClass.FeaturedHelperClass;
import com.shameer.etree.helperClass.MostViewAdapter;
import com.shameer.etree.helperClass.MostViewHelperClass;

import java.util.ArrayList;

import login.Login;
import login.SignUp;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, mostViewedRecycler, mostViewedRecyclerr, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private Button button;

    ImageButton tree, plant, bushe, flower;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView view1, view2,view3;
    ImageView menuIcon, cart;
    LinearLayout contentView;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        mostViewedRecyclerr = findViewById(R.id.most_viewed_recyclerr);
        categoriesRecycler = findViewById(R.id.categories_recycler);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
       // bottomnavigation=findViewById(R.id.bottomnavigation);
        navigationView = findViewById(R.id.navigation_view);


        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        cart = findViewById(R.id.cartttttt);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDashboard.this, ConfirmOrdActivity.class);
                startActivity(intent);
            }
        });
        //Donation_button
        button = (Button) findViewById(R.id.donation_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donation();
            }
        });

        // buttons
        view1 = findViewById(R.id.view);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1();
            }


        });
        view3 = findViewById(R.id.view1);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view3();
            }


        });

        view2 = findViewById(R.id.categories);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view2();
            }
        });
        plant = (ImageButton) findViewById(R.id.plants);
        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plant();
            }
        });

        tree = (ImageButton) findViewById(R.id.tree);
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tree();
            }
        });

        bushe = (ImageButton) findViewById(R.id.bushe);
        bushe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bush();
            }
        });

        flower = (ImageButton) findViewById(R.id.flower);
        flower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flower();
            }
        });



        nevigationDrawer();
        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
        mostViewedRecyclerr();
    }



    private void view2() {
        Intent intent = new Intent(this, AllCategories.class);
        startActivity(intent);
    }

    private void view1() {
        Intent intent = new Intent(this, AllCategories.class);
        startActivity(intent);
    }
    private void view3() {
        Intent intent = new Intent(this, Flower.class);
        startActivity(intent);
    }

    private void flower() {
        Intent intent = new Intent(this, Flower.class);
        startActivity(intent);
    }

    private void bush() {
        Intent intent = new Intent(this, Bushes.class);
        startActivity(intent);
    }

    private void tree() {
        Intent intent = new Intent(this, Tree.class);
        startActivity(intent);
    }

    private void plant() {
        Intent intent = new Intent(this, Plants.class);
        startActivity(intent);
    }

    private void donation() {
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);

    }

    private void nevigationDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    public void onCreat (@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.bottom_nav_home:
                startActivity(new Intent(getApplicationContext(), StartupScreen.class));
                break;
            case R.id.bottom_nav_profile:
                startActivity(new Intent(getApplicationContext(), StartupScreen.class));
                break;


        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
            case R.id.nav_donation:
                startActivity(new Intent(getApplicationContext(), Donation.class));
                break;
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;
            case R.id.nav_contact:
                startActivity(new Intent(getApplicationContext(), Contact.class));
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;
            case R.id.nav_signin:
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                break;
            case R.id.nav_tree:
                startActivity(new Intent(getApplicationContext(), Tree.class));
                break;
            case R.id.nav_plant:
                startActivity(new Intent(getApplicationContext(), Plants.class));
                break;
            case R.id.nav_bush:
                startActivity(new Intent(getApplicationContext(), Bushes.class));
                break;
            case R.id.nav_flowers:
                startActivity(new Intent(getApplicationContext(), Flower.class));
                break;
            case R.id.nav_dash:
                startActivity(new Intent(getApplicationContext(), RetailerDashboard.class));
                break;
            case R.id.nav_sample:
                startActivity(new Intent(getApplicationContext(), StartupScreen.class));
                break;
            case R.id.policy:
                startActivity(new Intent(getApplicationContext(), Privacy.class));
                break;


        }
        return true;
    }


    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewHelperClass(R.drawable.oaktrees1, "Oak Tree", "RS 5500"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.aloeplant, "Aloe Plant", "RS 1100"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.sycamoretree1, "Sycamore Tree", "Rs 4000"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.crepe1, "Crepe Mytle Tree", "Rs 90000"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.peacily, "Peace Lily", "Rs 2800"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.redsensation, "Red Sensation", "Rs 1400"));


        adapter = new MostViewAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void mostViewedRecyclerr() {

        mostViewedRecyclerr.setHasFixedSize(true);
        mostViewedRecyclerr.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewHelperClass(R.drawable.oaktrees1, "Oak Tree", "RS 5500"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.aloeplant, "Aloe Plant", "RS 1100"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.sycamoretree1, "Sycamore Tree", "Rs 4000"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.crepe1, "Crepe Mytle Tree", "Rs 90000"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.peacily, "Peace Lily", "Rs 2800"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.redsensation, "Red Sensation", "Rs 1400"));


        adapter = new MostViewAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.oaktrees1, "Oak Tree", "RS 5500"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.willo1, "Willow Oak Tree", "RS 8000"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.silvermaple2, "Silver maple", "RS 7000"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sycamoretree1, "Sycamore Tree", "RS 4000"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.whiteprincess1, " White PrincesS", "RS 14000"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.tulippoplartree, "Tulip Tree", "RS 6000"));
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

    private void categoriesRecycler() {


        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesLocation = new ArrayList<>();
        categoriesLocation.add(new CategoriesHelperClass(R.drawable.tree21, "20% Discount"));
        categoriesLocation.add(new CategoriesHelperClass(R.drawable.plant21, "Buy now"));
        categoriesLocation.add(new CategoriesHelperClass(R.drawable.rose1, "Send Gifts"));
        categoriesLocation.add(new CategoriesHelperClass(R.drawable.rose1, "Unique Flowers"));


        adapter = new CategoriesAdapter(categoriesLocation);

        categoriesRecycler.setAdapter(adapter);

    }

}