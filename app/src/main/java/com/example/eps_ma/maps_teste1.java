package com.example.eps_ma;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.example.eps_ma.databinding.ActivityMapsTeste1Binding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class maps_teste1 extends FragmentActivity implements OnMapReadyCallback {

    ImageView btVoltar1;
    private GoogleMap mMap;
    private ActivityMapsTeste1Binding binding;
    private TileOverlay mOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsTeste1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        IniciarComponentes();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Objects.requireNonNull(mapFragment).getMapAsync(this);

        btVoltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarpgprincipal = new Intent(maps_teste1.this, MainActivity.class);
                startActivity(voltarpgprincipal);
                finish();
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng maranhao = new LatLng(-4.663056, -45.425664);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(maranhao,5.7f));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Criar uma lista de WeightedLatLng (dados do mapa de calor)
        List<LatLng> heatmapData = generateHeatmapData();

        // Criar um HeatmapTileProvider com os dados
        HeatmapTileProvider.Builder builder = new HeatmapTileProvider.Builder()
                .data(heatmapData)
                .radius(50); // Ajuste o raio do mapa de calor conforme necessário

        HeatmapTileProvider heatmapTileProvider = builder.build();

        // Adicione o mapa de calor ao mapa do Google
        mOverlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(heatmapTileProvider));

        /**
        LatLng legendLocation = new LatLng(-2.5604581, -44.3405241);
        MarkerOptions legendMarkerOptions = new MarkerOptions()
                .position(legendLocation)
                .title("Legenda")
                .snippet("Mais intensidade");

        mMap.addMarker(legendMarkerOptions);
         **/

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                @SuppressLint("InflateParams")
                View infoView = getLayoutInflater().inflate(R.layout.custom_info_window, null);

                @SuppressLint({"MissingInflatedId", "LocalSuppress"})
                TextView title = infoView.findViewById(R.id.title);
                @SuppressLint({"MissingInflatedId", "LocalSuppress"})
                TextView snippet = infoView.findViewById(R.id.snippet);

                title.setText(marker.getTitle());
                snippet.setText(marker.getSnippet());

                return infoView;
            }
        });
    }

    private List<LatLng> generateHeatmapData() {
        List<LatLng> heatmapData = new ArrayList<>();
        heatmapData.add(new LatLng(-2.5604581, -44.3405241)); // São Luís
        heatmapData.add(new LatLng(-4.9386215, -47.6244172)); // Açailândia
        heatmapData.add(new LatLng(-4.224444, -44.790556)); // Bacabal
        heatmapData.add(new LatLng(-4.865833, -43.361111)); // Caxias
        heatmapData.add(new LatLng(-5.496944, -45.248333)); // Barra do Corda
        heatmapData.add(new LatLng(-7.530278, -46.038611)); // Balsas
        heatmapData.add(new LatLng(-3.738611, -43.360000)); // Chapadinha
        heatmapData.add(new LatLng(-4.451667, -43.889722)); // Codó
        heatmapData.add(new LatLng(-5.518056, -47.475000)); // Imperatriz
        heatmapData.add(new LatLng(-3.394722, -44.358611)); // Itapecuru-Mirim
        heatmapData.add(new LatLng(-4.575833, -44.607778)); // Pedreiras
        heatmapData.add(new LatLng(-2.519167, -45.094722)); // Pinheiro
        heatmapData.add(new LatLng(-5.299722, -44.493056)); // Presidente Dutra
        heatmapData.add(new LatLng(-2.940000, -44.253889)); // Rosário
        heatmapData.add(new LatLng(-3.666111, -45.383333)); // Santa Inês
        heatmapData.add(new LatLng(-3.209722, -44.986944)); // Viana
        heatmapData.add(new LatLng(-5.100833, -42.819444)); // Timon
        heatmapData.add(new LatLng(-6.500833, -43.689167)); // São João dos Patos
        heatmapData.add(new LatLng(-3.270833, -45.655833)); // Zé Doca

        return heatmapData;
    }

    public void IniciarComponentes(){
        btVoltar1 = findViewById(R.id.bt_voltar_mapas);
    }
}