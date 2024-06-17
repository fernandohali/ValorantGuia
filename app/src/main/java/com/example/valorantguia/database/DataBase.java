package com.example.valorantguia.database;


import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class,Produto.class},version = 0)
public abstract class DataBase extends RoomDatabase {
    public abstract UsuarioDao getUserDao();
    public abstract ProdutoDao getProdutoDao();
}
