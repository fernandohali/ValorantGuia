package com.example.valorantguia.database;

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

}
