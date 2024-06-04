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

public class RegiaoAdapter extends RecyclerView.Adapter<RegiaoAdapter.ViewHolder> {
    private final List<String> regioes;
    private final Context context;
    public RegiaoAdapter(List<String> regioes, Context context) {
        this.regioes = regioes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_regiao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewRegiao.setText(regioes.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Adicione o código do Intent para abrir atividades diferentes com base na posição
                    Intent intent;
                    switch (position) {
                        case 0:
                            intent = new Intent(context, Acailandia.class);
                            break;
                        case 1:
                            intent = new Intent(context, Bacabal.class);
                            break;
                        case 2:
                            intent = new Intent(context, Balsas.class);
                            break;
                        case 3:
                            intent = new Intent(context, BarraDoCorda.class);
                            break;
                        // Adicione casos para outros itens conforme necessário
                        default:
                            intent = new Intent(context, TecAcailandia.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return regioes.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRegiao;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRegiao = itemView.findViewById(R.id.textRegiao);
        }
    }
}
