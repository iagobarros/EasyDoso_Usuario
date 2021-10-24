package com.example.easydoso_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Profissional extends AppCompatActivity {

    ArrayList<DadosProfissional> dadosProfissional = new ArrayList<DadosProfissional>();
    ArrayList<DadosProfissional> filteredProfissionais = new ArrayList<DadosProfissional>();

    static int posicao=0;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fStore = FirebaseFirestore.getInstance();

        Intent intent = getIntent();



        setContentView(R.layout.activity_profissional);
        this.getSupportActionBar().hide();

        //=========Eletricista================
        DadosProfissional temp = new DadosProfissional();
        temp.setPhone("+55 81 99881 0630");
        temp.setFullName("Iago Barros");
        temp.setServices("Eletricista");
        temp.setImageName("stevejobs");
        dadosProfissional.add(temp);

        DadosProfissional temp5 = new DadosProfissional();
        temp5.setPhone("+55 81 99881 0630");
        temp5.setFullName("Khalil Panahi");
        temp5.setServices("Eletricista");
        temp5.setImageName("profileone");
        dadosProfissional.add(temp5);

        DadosProfissional temp6 = new DadosProfissional();
        temp6.setPhone("+55 81 99881 0630");
        temp6.setFullName("Thales");
        temp6.setServices("Eletricista");
        temp6.setImageName("profiletwo");
        dadosProfissional.add(temp6);
        //==========Diarista===============
        DadosProfissional temp1 = new DadosProfissional();
        temp1.setPhone("+5581997992574");
        temp1.setFullName("Diego roberto");
        temp1.setServices("Diarista");
        temp1.setImageName("profilethree");
        dadosProfissional.add(temp1);

        DadosProfissional temp7 = new DadosProfissional();
        temp7.setPhone("+5581997992574");
        temp7.setFullName("Bill Gates");
        temp7.setServices("Diarista");
        temp7.setImageName("billgates");
        dadosProfissional.add(temp7);

        DadosProfissional temp8 = new DadosProfissional();
        temp8.setPhone("+5581997992574");
        temp8.setFullName("Tatiana gruger");
        temp8.setServices("Diarista");
        temp8.setImageName("profilefour");
        dadosProfissional.add(temp8);
//==========Taxi===============
        DadosProfissional temp2 = new DadosProfissional();
        temp2.setPhone("+5581997992574");
        temp2.setFullName("Mark Zuckerberg");
        temp2.setServices("Taxi");
        temp2.setImageName("markzuckerberg");
        dadosProfissional.add(temp2);

        DadosProfissional temp9 = new DadosProfissional();
        temp9.setPhone("+5581997992574");
        temp9.setFullName("Isabella andrade");
        temp9.setServices("Taxi");
        temp9.setImageName("profilefive");
        dadosProfissional.add(temp9);

        DadosProfissional temp10 = new DadosProfissional();
        temp10.setPhone("+5581997992574");
        temp10.setFullName("Rita Zeze");
        temp10.setServices("Taxi");
        temp10.setImageName("profilesix");
        dadosProfissional.add(temp10);
//============Mecanico=============
        DadosProfissional temp3 = new DadosProfissional();
        temp3.setPhone("+5581997992574");
        temp3.setFullName("Marília Mendonça");
        temp3.setServices("Mecanico");
        temp3.setImageName("mariliamendonca");
        dadosProfissional.add(temp3);

        DadosProfissional temp11 = new DadosProfissional();
        temp11.setPhone("+5581997992574");
        temp11.setFullName("Alexsandra ze robero");
        temp11.setServices("Mecanico");
        temp11.setImageName("profileseven");
        dadosProfissional.add(temp11);

        DadosProfissional temp12 = new DadosProfissional();
        temp12.setPhone("+5581997992574");
        temp12.setFullName("rafael Mbarros");
        temp12.setServices("Mecanico");
        temp12.setImageName("profileeight");
        dadosProfissional.add(temp12);
//============Barbeiro=============
        DadosProfissional temp4 = new DadosProfissional();
        temp4.setPhone("+5581997992574");
        temp4.setFullName("Gusttavo Lima");
        temp4.setServices("Barbeiro");
        temp4.setImageName("gusttavolima");
        dadosProfissional.add(temp4);

        DadosProfissional temp13 = new DadosProfissional();
        temp13.setPhone("+5581997992574");
        temp13.setFullName("Pedro santos");
        temp13.setServices("Barbeiro");
        temp13.setImageName("profilenine");
        dadosProfissional.add(temp13);

        DadosProfissional temp14 = new DadosProfissional();
        temp14.setPhone("+5581997992574");
        temp14.setFullName("batista gabriel");
        temp14.setServices("Barbeiro");
        temp14.setImageName("profileten");
        dadosProfissional.add(temp14);
//==========Manicure/Pedicure===============
        DadosProfissional temp15 = new DadosProfissional();
        temp15.setPhone("+5581997992574");
        temp15.setFullName("Jandira Vitala");
        temp15.setServices("Manicure/Pedicure");
        temp15.setImageName("profileeleven");
        dadosProfissional.add(temp15);

        DadosProfissional temp16 = new DadosProfissional();
        temp16.setPhone("+5581997992574");
        temp16.setFullName("Sancho Taveira");
        temp16.setServices("Manicure/Pedicure");
        temp16.setImageName("profiletwelve");
        dadosProfissional.add(temp16);

        DadosProfissional temp17 = new DadosProfissional();
        temp17.setPhone("+5581997992574");
        temp17.setFullName("Nour Valadim");
        temp17.setServices("Manicure/Pedicure");
        temp17.setImageName("profilefifty");
        dadosProfissional.add(temp17);
        //==========Tecnico ar Condicionado===============
        DadosProfissional temp18 = new DadosProfissional();
        temp18.setPhone("+5581997992574");
        temp18.setFullName("Timur Resende");
        temp18.setServices("Tecnico ar Condicionado");
        temp18.setImageName("profilehge");
        dadosProfissional.add(temp18);

        DadosProfissional temp19 = new DadosProfissional();
        temp19.setPhone("+5581997992574");
        temp19.setFullName("Eveline Grilo");
        temp19.setServices("Tecnico ar Condicionado");
        temp19.setImageName("imageshsgdwd");
        dadosProfissional.add(temp19);

        DadosProfissional temp20 = new DadosProfissional();
        temp20.setPhone("+5581997992574");
        temp20.setFullName("Estela Valgueiro");
        temp20.setServices("Tecnico ar Condicionado");
        temp20.setImageName("imagesksdflsdh");
        dadosProfissional.add(temp20);
        //==========Jardineiro===============
        DadosProfissional temp21 = new DadosProfissional();
        temp21.setPhone("+5581997992574");
        temp21.setFullName("Raj Domingues");
        temp21.setServices("Jardineiro");
        temp21.setImageName("imageslygkuyg");
        dadosProfissional.add(temp21);

        DadosProfissional temp22 = new DadosProfissional();
        temp22.setPhone("+5581997992574");
        temp22.setFullName("Anastacia Assis");
        temp22.setServices("Jardineiro");
        temp22.setImageName("imagesliuywg");
        dadosProfissional.add(temp22);

        DadosProfissional temp23 = new DadosProfissional();
        temp23.setPhone("+5581997992574");
        temp23.setFullName("Mathias Carreiro");
        temp23.setServices("Jardineiro");
        temp23.setImageName("imagesklhfle");
        dadosProfissional.add(temp23);
        //=========================

        String titulo = intent.getStringExtra("TITULO");

        //to filter profissionais
        for (DadosProfissional item : dadosProfissional) {
            if(item.getServices().contains(intent.getStringExtra("TITULO"))){
                filteredProfissionais.add(item);
            }
        }

        TextView servicoTitulo = (TextView) findViewById(R.id.servicoTitulo);
        servicoTitulo.setText(titulo);
        TextView textViewDescricao = (TextView) findViewById(R.id.textViewDescricao);
        textViewDescricao.setText(filteredProfissionais.get(posicao).getFullName());
        ImageView perfil = (ImageView) findViewById(R.id.imageViewPerfil);

        //to set profile picture dinamically
        String uri = "@drawable/"+filteredProfissionais.get(posicao).getImageName();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        perfil.setImageDrawable(res);


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
                if(filteredProfissionais.size()-1==posicao) posicao=0;
                else posicao++;

                servicoTitulo.setText(titulo);
                textViewDescricao.setText(filteredProfissionais.get(posicao).getFullName());


                //to set profile picture dinamically
                String uri = "@drawable/"+filteredProfissionais.get(posicao).getImageName();
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                perfil.setImageDrawable(res);
//                finish();
//                startActivity(getIntent());
            }
        });
        Button buttonServico = (Button) findViewById(R.id.buttonServico);
        buttonServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Outro servico"," clicked.");



                finish();
            }
        });
    }
}