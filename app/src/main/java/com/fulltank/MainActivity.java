package com.fulltank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Menu lateral
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation da activity principal
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // TabLayout dos combustíveis
        AdapterAbasCombustivel mAdapterAbasCombustivel = new AdapterAbasCombustivel(getSupportFragmentManager());
        mAdapterAbasCombustivel.adicionaFragment(new PGasolinaFragment(), "Gasolina");
        mAdapterAbasCombustivel.adicionaFragment(new PEtanolFragment(), "Etanol");
        mAdapterAbasCombustivel.adicionaFragment(new PDieselFragment(), "Diesel");

        ViewPager mViewPager = findViewById(R.id.id_vwAbasCombustivel);
        mViewPager.setAdapter(mAdapterAbasCombustivel);

        TabLayout mTabLayout = findViewById(R.id.id_abasCombustivel);
        mTabLayout.setupWithViewPager(mViewPager);

        // FAB - Inserir novo preço
        FloatingActionButton mFloatingActionButton = findViewById(R.id.fab);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click FAB
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_veiculo) {
            // Handle the camera action
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_info) {

        } else if (id == R.id.nav_sair) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
