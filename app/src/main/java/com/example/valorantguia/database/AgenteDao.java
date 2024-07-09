package com.example.valorantguia.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AgenteDao {

    @Insert
    void insert(Agente agente);

    @Query("SELECT * FROM agente")
    List<Agente> getAllAgentes();
}
