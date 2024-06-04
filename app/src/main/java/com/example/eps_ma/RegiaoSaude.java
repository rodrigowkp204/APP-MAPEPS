package com.example.eps_ma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class RegiaoSaude extends AppCompatActivity {

    ImageView bt_voltar_regiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiao_saude);

        bt_voltar_regiao = findViewById(R.id.bt_voltar_regiao);
        bt_voltar_regiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bt_voltar_regiao = new Intent(RegiaoSaude.this, MainActivity.class);
                startActivity(bt_voltar_regiao);
                finish();
            }
        });
        RecyclerView regiaoRecyclerView = findViewById(R.id.regiaoitens);
        regiaoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> regioes = Arrays.asList(
                "Açailândia", "Bacabal", "Balsas", "Barra do Corda", "Caxias",
                "Chapadinha", "Codó", "Imperatriz", "Itapecuru", "Pedreiras",
                "Pinheiro", "Presidente Dutra", "Rosário", "Santa Inês", "São João dos Patos", "Timon", "Viana", "Zé Doca"
        );

        RegiaoAdapter adapter = new RegiaoAdapter(regioes, this);
        regiaoRecyclerView.setAdapter(adapter);

    }

}