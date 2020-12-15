package com.example.easydoso_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class Profissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);
        this.getSupportActionBar().hide();
        int sessionId = getIntent().getIntExtra("EXTRA", 0);
        Toast.makeText(this, Integer.toString(sessionId), Toast.LENGTH_SHORT).show();
    }
}