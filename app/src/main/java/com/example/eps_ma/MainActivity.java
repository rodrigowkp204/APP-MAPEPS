package com.example.eps_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_mapa_calor, bt_regiao_saude, bt_formacao_tecnica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        bt_mapa_calor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, maps_teste1.class);
                startActivity(intent1);
                finish();
            }
        });

        bt_regiao_saude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, RegiaoSaude.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    public void IniciarComponentes(){
        bt_mapa_calor = findViewById(R.id.bt_maps_calor);
        bt_regiao_saude = findViewById(R.id.bt_regioes_saude);
        bt_formacao_tecnica = findViewById(R.id.bt_formacoes_tecnica);
    }
}