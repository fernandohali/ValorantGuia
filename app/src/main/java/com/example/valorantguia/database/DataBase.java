package com.example.valorantguia.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class, Invocador.class, Mapa.class, Agente.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract UsuarioDao getUserDao();

    public abstract InvocadorDao invocadorDao();

    public abstract MapaDao getMapaDao();

    public abstract AgenteDao getAgenteDao();
}
