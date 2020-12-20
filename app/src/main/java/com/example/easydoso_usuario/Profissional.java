package com.example.easydoso_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Profissional extends AppCompatActivity {

    ArrayList<DadosProfissional> dadosProfissional = new ArrayList<DadosProfissional>();
    static int posicao=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissional);
        this.getSupportActionBar().hide();
        Intent intent = getIntent();
        //
        DadosProfissional temp = new DadosProfissional();
        temp.setPhone("+5581997992574");
        temp.setFullName("Iago barros");
        temp.setServices("Taxi");
        dadosProfissional.add(temp);
        DadosProfissional temp1 = new DadosProfissional();
        temp1.setPhone("+5581997992574");
        temp1.setFullName("Pedro barros");
        temp1.setServices("Taxi");
        dadosProfissional.add(temp1);
        DadosProfissional temp2 = new DadosProfissional();
        temp2.setPhone("+5581997992574");
        temp2.setFullName("Khalil barros");
        temp2.setServices("Diarista");
        dadosProfissional.add(temp2);
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