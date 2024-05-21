package com.example.loginapp.TelaPrincipal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.R;
import com.example.loginapp.database.Produto;

import java.util.List;

/* Classe que representa o adapter do recyrcleview
 * Nesta classe especificamos o comportamento do ciclo de vida dos dados do recyrcleview,
 * bem como o comportamento geral dos viewholders*/
public class ListAdapter extends RecyclerView.Adapter<LineViewHolder> {
    // lista global de entidade
    private final List<Produto> listaProdutos;
    private Context activityContext;
    // contrutor que recebe a lista de entidades
    public ListAdapter(List<Produto> listaProdutos, Context activityContext){
        this.listaProdutos = listaProdutos;
        this.activityContext=activityContext;
    }

    @Override // especifica como cada viewholder será criado (especifica o xml do layout a ser usado)
    public LineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LineViewHolder viewHolder = new LineViewHolder(inflater.inflate(R.layout.activity_tela_principal_admin_viewholder,parent,false));
        return viewHolder;
    }

    @Override // especifica como os dados serão associados aos elementos do viewholder
    public void onBindViewHolder(@NonNull LineViewHolder holder, int position) {
        holder.txtNomeViewHolder.setText(listaProdutos.get(position).nome);
        holder.txtPrecoViewHolder.setText(String.valueOf(listaProdutos.get(position).preco));
        holder.btnDetalhesViewHolder.setOnClickListener((View view)->{
            Toast.makeText(activityContext, "Clicou!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override // retorna a quantidade de elementos na lista de dados
    public int getItemCount() {
        if(listaProdutos==null) return 0;
        return listaProdutos.size();
    }
}
