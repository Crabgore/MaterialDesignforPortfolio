package com.geekbrains.materialdesignportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class EnterActivity extends BaseActivity {
    private EditText enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        initUI();
    }

    private void initUI() {
        enter = findViewById(R.id.enter);

        findViewById(R.id.login).setOnClickListener(v -> {
            if (enter.getText().toString().equals("")) makeSnack(v);
            else {
                Intent intent = new Intent(EnterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.close).setOnClickListener(v -> finish());
    }

    private void makeSnack(final View view) {
        Snackbar snackbar = Snackbar.make(view, "Введите имя", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
