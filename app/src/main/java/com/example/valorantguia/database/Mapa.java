package com.example.valorantguia.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Usuario.class, parentColumns = "id", childColumns = "usuarioId"),
        // Adicionar chave estrangeira para o agente, se aplicável
})
public class Mapa {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nameMapa;

    public int usuarioId;

    // Se precisar de chave estrangeira para o agente
    public int agenteId;

    public Mapa(String nameMapa, int usuarioId, int agenteId) {
        this.nameMapa = nameMapa;
        this.usuarioId = usuarioId;
        this.agenteId = agenteId;
    }
}
