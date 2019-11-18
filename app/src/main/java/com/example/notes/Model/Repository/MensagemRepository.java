package com.example.notes.Model.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.notes.Model.DAO.MensagemDao;
import com.example.notes.Model.Database.MensagemDatabase;
import com.example.notes.Model.Models.Mensagem;

import java.util.List;

public class MensagemRepository {
    private MensagemDao mensagemDao;
    private LiveData<List<Mensagem>> mensagens;

    public MensagemRepository(Application application){
        MensagemDatabase mensagemDatabase = MensagemDatabase.getInstance(application);
        mensagemDao = mensagemDatabase.mensagemDao();
        mensagens = mensagemDao.getAllNotes();
    }

    public void update(Mensagem mensagem){
        new UpdateMensagememAsyncTask(mensagemDao).execute(mensagem);
    }
    public void insert(Mensagem mensagem){
        new InsertMensagemAsyncTask(mensagemDao).execute(mensagem);
    }
    public void delete(Mensagem mensagem){
        new DeleteMensagemAsyncTask(mensagemDao).execute(mensagem);
    }
    public void deleteAllMensagens(){
        new DeleteAllMensagensAsyncTask(mensagemDao).execute();
    }

    public LiveData<List<Mensagem>> getAllMensagens(){
        return mensagens;
    }

    private static class InsertMensagemAsyncTask extends AsyncTask<Mensagem, Void, Void>{
        private MensagemDao mensagemDao;

        private InsertMensagemAsyncTask(MensagemDao mensagemDao){
            this.mensagemDao = mensagemDao;
        }
        @Override
        protected Void doInBackground(Mensagem... mensagens) {
            mensagemDao.insert(mensagens[0]);
            return null;
        }
    }

    private static class UpdateMensagememAsyncTask extends AsyncTask<Mensagem, Void, Void>{
        private MensagemDao mensagemDao;

        private UpdateMensagememAsyncTask(MensagemDao mensagemDao){
            this.mensagemDao = mensagemDao;
        }
        @Override
        protected Void doInBackground(Mensagem... mensagens) {
            mensagemDao.update(mensagens[0]);
            return null;
        }
    }

    private static class DeleteMensagemAsyncTask extends AsyncTask<Mensagem, Void, Void>{
        private MensagemDao mensagemDao;

        private DeleteMensagemAsyncTask(MensagemDao mensagemDao){
            this.mensagemDao = mensagemDao;
        }
        @Override
        protected Void doInBackground(Mensagem... mensagens) {
            mensagemDao.delete(mensagens[0]);
            return null;
        }
    }

    private static class DeleteAllMensagensAsyncTask extends AsyncTask<Void, Void, Void>{
        private MensagemDao mensagemDao;

        private DeleteAllMensagensAsyncTask(MensagemDao mensagemDao){
            this.mensagemDao = mensagemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mensagemDao.deleteAllNotes();
            return null;
        }
    }
}
