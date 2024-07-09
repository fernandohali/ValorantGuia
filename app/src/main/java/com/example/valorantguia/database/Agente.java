package com.example.valorantguia.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "agente")
public class Agente {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nomeAgente")
    public String nomeAgente;
}
