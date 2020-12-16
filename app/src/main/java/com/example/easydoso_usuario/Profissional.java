package com.example.easydoso_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);
        this.getSupportActionBar().hide();
        String sessionId = getIntent().getStringExtra("MAIN_SERVICO");
        TextView servicoTitulo = (TextView) findViewById(R.id.servicoTitulo);
        servicoTitulo.setText(sessionId);
        Button buttonLigar = (Button) findViewById(R.id.buttonLigar);
        buttonLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+5581997992574"));
                startActivity(callIntent);
            }
        });
    }
}