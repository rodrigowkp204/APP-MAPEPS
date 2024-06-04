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

public class Balsas extends AppCompatActivity {

    ImageView bt_voltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balsas);

        bt_voltar = findViewById(R.id.bt_voltar_balsas);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar_regioes_saude = new Intent(Balsas.this, RegiaoSaude.class);
                startActivity(voltar_regioes_saude);
                finish();
            }
        });

        RecyclerView regiaoRecyclerView = findViewById(R.id.municipiositensBalsas);
        regiaoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> municipios = Collections.singletonList(
                "Balsas"
        );

        MunicipiosBalsasAdapter adapter = new MunicipiosBalsasAdapter(municipios, this);
        regiaoRecyclerView.setAdapter(adapter);
    }
}