package com.example.eps_ma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BarraDoCorda extends AppCompatActivity {

    ImageView bt_voltar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_do_corda);

        bt_voltar = findViewById(R.id.bt_voltar_barra_do_corda);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar_regioes_saude = new Intent(BarraDoCorda.this, RegiaoSaude.class);
                startActivity(voltar_regioes_saude);
                finish();
            }
        });
        recyclerView = findViewById(R.id.municipiositensBarradoCorda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> municipios = Arrays.asList(
                "Arame",
                "Barra do Corda",
                "Fernando Falcão",
                "Grajaú",
                "Itaipava do Grajaú",
                "Jenipapo dos Vieiras"
        );

        MunicipiosBarraDoCordaAdapter adapter = new MunicipiosBarraDoCordaAdapter(municipios, this);
        recyclerView.setAdapter(adapter);
    }
}