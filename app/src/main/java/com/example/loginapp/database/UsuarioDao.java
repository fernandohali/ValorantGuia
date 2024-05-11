package com.example.loginapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * from usuario WHERE login=:login AND senha=:senha")
    public Usuario getUserLogin(String login, String senha);

    @Query("SELECT * from usuario")
    public List<Usuario> getAll();

    @Insert
    public void insereUsuario(Usuario usuario);

}
