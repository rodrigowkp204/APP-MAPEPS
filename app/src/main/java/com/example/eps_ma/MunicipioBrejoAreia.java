package com.example.eps_ma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MunicipioBrejoAreia extends AppCompatActivity {

    private InfoAdapter infoAdapter;
    private List<InformacoesBD> listaInformacoesBD;
    RecyclerView recyclerView;
    ImageView bt_voltar_municipio_brejo_areia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_brejo_areia);

        IniciarComponentes();
        // Recuperar dados do Firestore
        obterDadosDoFirestore();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaInformacoesBD = new ArrayList<>();

        infoAdapter = new InfoAdapter(listaInformacoesBD);
        recyclerView.setAdapter(infoAdapter);

        bt_voltar_municipio_brejo_areia = findViewById(R.id.bt_voltar_municipio_brejo_areia);
        bt_voltar_municipio_brejo_areia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar_regioes_saude = new Intent(MunicipioBrejoAreia.this, Bacabal.class);
                startActivity(voltar_regioes_saude);
                finish();
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void obterDadosDoFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Exemplo de especificação de um documento
        String nomeDocumento = "tec_acs_brejo_areia"; // Substitua pelo nome do seu documento
        DocumentReference documento = db.collection("info_cursos").document(nomeDocumento);

        documento.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    // O documento existe, você pode obter os dados
                    InformacoesBD informacoesBD = document.toObject(InformacoesBD.class);
                    listaInformacoesBD.add(informacoesBD);

                    // Notificar o adaptador após a obtenção dos dados
                    infoAdapter.notifyDataSetChanged();
                } else {
                    // O documento não existe
                }
            } else {
                // Lidar com falha na obtenção dos dados
            }
        });
    }

    private void IniciarComponentes(){
        recyclerView = findViewById(R.id.info_cursos_brejo_areia);
    }
}