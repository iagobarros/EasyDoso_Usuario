package com.example.easydoso_usuario;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"DIARISTA", "TAXI", "MECÂNICO", "DIARISTA1", "DIARISTA2", "DIARISTA3", "DIARISTA4", "DIARISTA5", "DIARISTA6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        */
        this.getSupportActionBar().hide();
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Profissional.class);
                intent.putExtra("MAIN_SERVICO", mTitle[position]);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        MyAdapter(Context c, String title[]) {
            super(c, R.layout.row, R.id.textView, title);
            this.context = c;
            this.rTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            //MaterialButton button = (MaterialButton) convertView.findViewById(R.id.materialButton);
            //button.setText(rTitle[position]);
            TextView myTitle = row.findViewById(R.id.textView);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }

}