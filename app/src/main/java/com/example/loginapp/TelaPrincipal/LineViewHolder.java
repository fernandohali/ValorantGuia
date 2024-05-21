package com.example.loginapp.TelaPrincipal;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.R;

/* Classe que representa os itens da lista de um recyrcleviews */
public class LineViewHolder extends RecyclerView.ViewHolder {
    // atributos
    TextView txtNomeViewHolder, txtPrecoViewHolder;
    Button btnDetalhesViewHolder;

    // construtor
    public LineViewHolder(View itemView){
        super(itemView);

        // captura dos componentes
        txtNomeViewHolder = itemView.findViewById(R.id.txtNomeViewHolder);
        txtPrecoViewHolder = itemView.findViewById(R.id.txtPrecoViewHolder);
        btnDetalhesViewHolder = itemView.findViewById(R.id.btnDetalhesViewHolder);
    }
}
