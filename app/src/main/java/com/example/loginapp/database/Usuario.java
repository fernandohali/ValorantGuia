package com.example.loginapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String login;
    @ColumnInfo
    public int idade;
    @ColumnInfo
    public String senha;
}
