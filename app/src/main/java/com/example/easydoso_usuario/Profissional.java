package com.example.easydoso_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Profissional extends AppCompatActivity {

    ArrayList<DadosProfissional> dadosProfissional = new ArrayList<DadosProfissional>();
    static int posicao=0;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fStore = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_profissional);
        this.getSupportActionBar().hide();
        Intent intent = getIntent();
        //
        DadosProfissional temp = new DadosProfissional();
        temp.setPhone("+55 81 99881 0630");
        temp.setFullName("Iago Barros");
        temp.setServices("Eletricista");
        dadosProfissional.add(temp);
        DadosProfissional temp1 = new DadosProfissional();
        temp1.setPhone("+5581997992574");
        temp1.setFullName("Bill Gates");
        temp1.setServices("Taxi");
        dadosProfissional.add(temp1);
        DadosProfissional temp2 = new DadosProfissional();
        temp2.setPhone("+5581997992574");
        temp2.setFullName("Mark Zuckerberg");
        temp2.setServices("Diarista");
        dadosProfissional.add(temp2);
        DadosProfissional temp3 = new DadosProfissional();
        temp3.setPhone("+5581997992574");
        temp3.setFullName("Marília Mendonça");
        temp3.setServices("Diarista");
        dadosProfissional.add(temp3);
        DadosProfissional temp4 = new DadosProfissional();
        temp4.setPhone("+5581997992574");
        temp4.setFullName("Gusttavo Lima");
        temp4.setServices("Diarista");
        dadosProfissional.add(temp4);
        //
        Log.d("KEBAB1", dadosProfissional.get(0).getFullName());
        Log.d("KEBAB1", dadosProfissional.get(1).getFullName());
        Log.d("KEBAB1", dadosProfissional.get(2).getFullName());
        //
        String titulo = intent.getStringExtra("TITULO");
        //Bundle args = intent.getBundleExtra("BUNDLE");
        //ArrayList<DadosProfissional> dadosProfissional = (ArrayList<DadosProfissional>) args.getSerializable("ARRAYLIST");
        //dadosProfissional = (ArrayList<DadosProfissional>) getIntent().getSerializableExtra("ARRAYLIST");

        Log.d("FUNCIONAARRAY", dadosProfissional.get(0).getFullName());
        Log.d("FUNCIONAARRAY", dadosProfissional.get(1).getFullName());

        TextView servicoTitulo = (TextView) findViewById(R.id.servicoTitulo);
        servicoTitulo.setText(titulo);
        TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        textViewDescricao.setText(dadosProfissional.get(posicao).getFullName());
        ImageView perfil = (ImageView) findViewById(R.id.imageViewPerfil);

        switch (posicao) {
            case 0: perfil.setImageResource(R.drawable.stevejobs); break;
            case 1: perfil.setImageResource(R.drawable.billgates); break;
            case 2: perfil.setImageResource(R.drawable.markzuckerberg); break;
            case 3: perfil.setImageResource(R.drawable.mariliamendonca); break;
            case 4: perfil.setImageResource(R.drawable.gusttavolima); break;
            default: break;
        }

        Button buttonLigar = (Button) findViewById(R.id.buttonLigar);
        buttonLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+5581997992574"));
                startActivity(callIntent);
            }
        });
        Button buttonProfissional = (Button) findViewById(R.id.buttonProfissional);
        buttonProfissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dadosProfissional.size()-1==posicao) posicao=0;
                else posicao++;
                //if(dadosProfissional.get(posicao).getServices()!=titulo) posicao++;
                Log.d("POSICAO", Integer.toString(posicao));
                finish();
                startActivity(getIntent());
            }
        });
        Button buttonServico = (Button) findViewById(R.id.buttonServico);
        buttonServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}