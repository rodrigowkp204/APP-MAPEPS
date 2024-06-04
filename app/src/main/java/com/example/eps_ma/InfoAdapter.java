package com.example.eps_ma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private List<InformacoesBD> listaInformacoesBD;
    private Context context;

    public InfoAdapter(List<InformacoesBD> listaInformacoesBD) {
        this.listaInformacoesBD = listaInformacoesBD;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        View itemLista = LayoutInflater.from(context).inflate(R.layout.informacoes_municipios,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        InformacoesBD informacoesBD = listaInformacoesBD.get(position);

        holder.curso.setText(informacoesBD.getcurso());
        holder.inicio.setText(informacoesBD.getInicio());
        holder.termino.setText(informacoesBD.getTermino());
        holder.ch.setText(informacoesBD.getCh());
        holder.alunosFormados.setText(informacoesBD.getAlunos_formados());

    }

    @Override
    public int getItemCount() {
        return listaInformacoesBD.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMunicipios;
        private final TextView curso;
        private final TextView inicio;
        private final TextView termino;
        private final TextView ch;
        private final TextView alunosFormados;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMunicipios = itemView.findViewById(R.id.textMunicipios);
            curso = itemView.findViewById(R.id.txtCurso1);
            inicio = itemView.findViewById(R.id.txtInicio1);
            termino = itemView.findViewById(R.id.txtTermino1);
            ch = itemView.findViewById(R.id.txtCargaHoraria1);
            alunosFormados = itemView.findViewById(R.id.txtAlunosFormados1);
        }
    }
}
