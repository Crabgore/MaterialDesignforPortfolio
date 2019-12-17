package com.geekbrains.materialdesignportfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class BaseActivity extends AppCompatActivity {
    SharedPreferences preferences;
    final static String THEME_ID = "THEME_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        checkTheme();
    }

    private void checkTheme() {
        int id = preferences.getInt(THEME_ID, 0);

        if (id == 0) setTheme(R.style.DefaultAppTheme);
        else if (id == 1) setTheme(R.style.blueAppTheme);
        else if (id == 2) setTheme(R.style.redAppTheme);
    }
}
