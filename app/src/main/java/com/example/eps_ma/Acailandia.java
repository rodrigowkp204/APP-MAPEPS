package com.example.eps_ma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Acailandia extends AppCompatActivity {

    ImageView bt_voltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acailandia);

        bt_voltar = findViewById(R.id.bt_voltar_acailandia);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar_regioes_saude = new Intent(Acailandia.this, RegiaoSaude.class);
                startActivity(voltar_regioes_saude);
                finish();
            }
        });

        RecyclerView regiaoRecyclerView = findViewById(R.id.municipiositens);
        regiaoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> municipios = Collections.singletonList(
                "Açailândia"
        );

        MunicipiosAdapter adapter = new MunicipiosAdapter(municipios, this);
        regiaoRecyclerView.setAdapter(adapter);
    }
}