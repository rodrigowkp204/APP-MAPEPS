package com.example.eps_ma;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MunicipiosBacabalAdapter extends RecyclerView.Adapter<MunicipiosBacabalAdapter.ViewHolder> {

    private final List<String> municipios;
    private final Context context1;

    public MunicipiosBacabalAdapter(List<String> municipios, Context context1) {
        this.municipios = municipios;
        this.context1 = context1;
    }

    @NonNull
    @Override
    public MunicipiosBacabalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_municipios, parent, false);
        return new MunicipiosBacabalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MunicipiosBacabalAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewMunicipios.setText(municipios.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Adicione o código do Intent para abrir atividades diferentes com base na posição
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context1, MunicipioBacabal.class);
                        break;
                    case 1:
                        intent = new Intent(context1, MunicipioBrejoAreia.class);
                        break;
                    case 2:
                        intent = new Intent(context1, MunicipioConceicaoLaguAcu.class);
                        break;
                    default:
                        intent = new Intent(context1, MunicipioSaoLuisGonzaga.class);
                        break;
                }
                context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return municipios.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMunicipios;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMunicipios = itemView.findViewById(R.id.textMunicipios);
        }
    }
}
