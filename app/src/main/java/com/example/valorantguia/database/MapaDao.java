package com.example.valorantguia.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MapaDao {

    @Insert
    long insert(Mapa mapa);

    @Query("SELECT * FROM mapa")
    List<Mapa> getAllMapas();

    @Query("SELECT * FROM mapa WHERE usuarioId = :usuarioId")
    List<Mapa> getMapasByUsuarioId(int usuarioId);

    @Query("SELECT * FROM mapa WHERE agenteId = :agenteId")
    List<Mapa> getMapasByAgenteId(int agenteId);
}
