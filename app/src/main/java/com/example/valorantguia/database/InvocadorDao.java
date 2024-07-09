package com.example.valorantguia.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InvocadorDao {
    @Insert
    void insert(Invocador invocador);

    @Query("SELECT * FROM invocador")
    List<Invocador> getAllInvocadores();
}
