package com.example.notes.Model.Database;


import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.notes.Model.DAO.MensagemDao;
import com.example.notes.Model.Models.Mensagem;

@Database(entities = Mensagem.class, version = 1)
public abstract class MensagemDatabase extends RoomDatabase {
    private static MensagemDatabase instance;

    public abstract MensagemDao mensagemDao();

    public static synchronized MensagemDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MensagemDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
    return instance;

    }
}
