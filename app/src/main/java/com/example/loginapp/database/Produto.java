package com.example.loginapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "produto")
public class Produto {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String nome;
    @ColumnInfo
    public double preco;
    @ColumnInfo
    public String descricao;
    @ColumnInfo
    public String categoria;

    public static List<Produto> getProdutosFicticios(int qtd){
        List<Produto> listaProdutos = new ArrayList<Produto>();
        for(int i=1; i<=qtd; i++){
            Produto produto = new Produto();
            produto.id = i;
            produto.nome = "produto "+i;
            produto.preco = i;
            produto.descricao = "descrição "+i+": Este produto é um produto de extrema qwualidade e é muito barato. Não foi afetado pela inflação.";
            produto.categoria = "categoria "+i;
            listaProdutos.add(produto);
        }
        return listaProdutos;
    }
}
