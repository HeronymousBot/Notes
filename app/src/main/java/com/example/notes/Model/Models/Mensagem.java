package com.example.notes.Model.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Mensagem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int priority;
    private String titulo;
    private String conteudo;
    private String autor;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mensagem(int priority, String titulo, String conteudo, String autor) {
        this.priority = priority;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
    }
}
