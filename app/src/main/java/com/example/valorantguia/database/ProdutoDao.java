package com.example.valorantguia.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProdutoDao {
    @Query("SELECT * from produto")
    public List<Produto> getAll();
}
