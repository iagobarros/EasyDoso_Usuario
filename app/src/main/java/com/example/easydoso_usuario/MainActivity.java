package com.example.easydoso_usuario;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"DIARISTA", "TAXI", "MECÂNICO", "DIARISTA1", "DIARISTA2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle);
        listView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        MyAdapter(Context c, String title[]) {
            super(c, R.layout.row, R.id.materialButton, title);
            this.context = c;
            this.rTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.materialButton);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }

}