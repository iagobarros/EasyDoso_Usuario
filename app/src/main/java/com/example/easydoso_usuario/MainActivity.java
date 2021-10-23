package com.example.easydoso_usuario;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;

    ListView listView;
    String mTitle[] = {"Diarista", "Taxi", "Eletricista", "Mecanico", "Barbeiro", "Manicure/Pedicure", "Tecnico ar Condicionado", "Jardineiro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        adapter = new MyAdapter(this, mTitle);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("KEBAB2", mTitle[position]);
                Intent intent = new Intent(MainActivity.this, Profissional.class);
                intent.putExtra("TITULO", mTitle[position]);

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

            TextView myTitle = row.findViewById(R.id.textView);
            myTitle.setText(rTitle[position]);
            if((position%2)==0) myTitle.setBackgroundColor(getResources().getColor(R.color.purple_500));
            return row;
        }

        public void setData(String title[]) {
            this.rTitle = title;
            notifyDataSetChanged();
        }

    }

}