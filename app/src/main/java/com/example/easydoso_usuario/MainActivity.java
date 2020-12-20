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

    // {phone=7654768, location_latitude=37.421998333333335, cpf=56546645, fullName=khalil, services=Taxi, location_longitude=-122.084,
    // birthDate=12/10/2020, email=khalil@gmail.com}

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    MyAdapter adapter;

    ListView listView;
    //String mTitle[] = {"DIARISTA", "TAXI", "MECÂNICO", "DIARISTA1", "DIARISTA2", "DIARISTA3", "DIARISTA4", "DIARISTA5", "DIARISTA6"};
    final String[] mTitle = new String[8];


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

                //ArrayList<Object> object = new ArrayList<Object>();
                //Intent intent = new Intent(Current.class, Transfer.class);
                //Bundle args = new Bundle();
                //args.putSerializable("ARRAYLIST",(Serializable)dadosProfissional);
                //intent.putExtra("BUNDLE",args);
                //intent.putExtra("ARRAYLIST",dadosProfissional);
                MainActivity.this.startActivity(intent);
            }
        });

        //FIREBASE
        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        String email = "khalil@gmail.com";
        String password = "111111";

        final String[] categoriasArray = new String[8];
        //Authenticate user

        fAuth.signInWithEmailAndPassword(email, password);
        //retrieve data from firebase data store
        DocumentReference docRef = fStore.collection("appdata").document("categorias");
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                    Map<String, Object> categoriasMap = new HashMap<>();
                    categoriasMap = document.getData();

                    Iterator it = categoriasMap.entrySet().iterator();

                    int iterateNum = 0;

                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        mTitle[iterateNum++] = pair.getValue().toString();
                    }
                    adapter.setData(mTitle);

                } else {
                    Log.d("TAG", "No such document");
                }
            } else {
                Log.d("TAG", "get failed with ", task.getException());
            }
        });

        /*
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        */

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

        public void setData(String title[]) {
            this.rTitle = title;
            notifyDataSetChanged();
        }

    }

}