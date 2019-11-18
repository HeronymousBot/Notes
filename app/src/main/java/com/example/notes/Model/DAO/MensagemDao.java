package com.example.notes.Model.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notes.Model.Models.Mensagem;

import java.util.List;

@Dao
public interface MensagemDao {
    @Insert
    void insert(Mensagem mensagem);

    @Update
    void update(Mensagem mensagem);

    @Delete
    void delete(Mensagem mensagem);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Mensagem>> getAllNotes();

}
