package com.example.valorantguia.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class, Invocador.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract UsuarioDao getUserDao();
    public abstract InvocadorDao invocadorDao();
}
