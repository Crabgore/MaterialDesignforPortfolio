package com.geekbrains.materialdesignportfolio.activities;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.geekbrains.materialdesignportfolio.R;
import com.geekbrains.materialdesignportfolio.adapters.MyTabsAdapter;
import com.geekbrains.materialdesignportfolio.fragments.FruitFragment;
import com.geekbrains.materialdesignportfolio.fragments.ItemFragment;
import com.geekbrains.materialdesignportfolio.fragments.NatureFragment;
import com.geekbrains.materialdesignportfolio.fragments.VegetableFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initFab();
        initDrawer();

        checkFrag();

        getSupportActionBar().setTitle("Material Design");
    }

    private void checkFrag() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("nature");

        if (fragment != null) {
            replaceFragment(new NatureFragment(), "nature");
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "fab clicked", Toast.LENGTH_SHORT).show());
    }

    private void initDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.nav_fruits:
                replaceFragment(new FruitFragment(), "fruit");
                break;
            case R.id.nav_vegetables:
                replaceFragment(new VegetableFragment(), "vegetable");
                break;
            case R.id.nav_nature:
                replaceFragment(new NatureFragment(), "nature");
//                initTab();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment, tag)
                .commit();
    }

    private void initTab() {
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        List<Drawable> drawables = new ArrayList<>();

        drawables.add(getResources().getDrawable(R.drawable.yosemite));
        drawables.add(getResources().getDrawable(R.drawable.zhangye));
        drawables.add(getResources().getDrawable(R.drawable.sagano));
        drawables.add(getResources().getDrawable(R.drawable.meteora));
        drawables.add(getResources().getDrawable(R.drawable.salar));

        descriptions.add(getResources().getString(R.string.yosemite));
        descriptions.add(getResources().getString(R.string.zhangye));
        descriptions.add(getResources().getString(R.string.sagano));
        descriptions.add(getResources().getString(R.string.meteora));
        descriptions.add(getResources().getString(R.string.salar));

        titles.add("Y");
        titles.add("Z");
        titles.add("B");
        titles.add("M");
        titles.add("S");

        for (int i = 0; i < drawables.size(); i++) {
            fragments.add(new ItemFragment(drawables.get(i), descriptions.get(i)));
        }

        MyTabsAdapter myTabAdapter = new MyTabsAdapter(getSupportFragmentManager(), fragments, titles);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(myTabAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        FrameLayout frameLayout = findViewById(R.id.nav_host_fragment);
        frameLayout.setVisibility(View.GONE);
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        SharedPreferences.Editor editor = preferences.edit();

        switch (id) {
            case R.id.def:
                editor.putInt(THEME_ID, 0);
                break;
            case R.id.blue:
                editor.putInt(THEME_ID, 1);
                break;
            case R.id.red:
                editor.putInt(THEME_ID, 2);
                break;

        }

        editor.apply();

        recreate();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
