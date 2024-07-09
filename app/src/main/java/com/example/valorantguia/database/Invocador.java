package com.example.valorantguia.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "invocador")
public class Invocador {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name_invocador")
    public String nameInvocador;

    @ColumnInfo(name = "tag")
    public String tag;
}
