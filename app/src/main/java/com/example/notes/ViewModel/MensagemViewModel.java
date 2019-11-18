package com.example.notes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notes.Model.Models.Mensagem;
import com.example.notes.Model.Repository.MensagemRepository;

import java.util.List;

public class MensagemViewModel extends AndroidViewModel {
    private MensagemRepository mensagemRepository;
    private LiveData<List<Mensagem>> allMensagens;
    public MensagemViewModel(@NonNull Application application) {
        super(application);
        mensagemRepository = new MensagemRepository(application);
        allMensagens = mensagemRepository.getAllMensagens();
    }

    public void insert(Mensagem mensagem){
        mensagemRepository.insert(mensagem);
    }

    public void update(Mensagem mensagem){
        mensagemRepository.update(mensagem);
    }

    public void delete(Mensagem mensagem){
        mensagemRepository.delete(mensagem);
    }

    public void deleteAllMensagens(){
        mensagemRepository.deleteAllMensagens();
    }

    public LiveData<List<Mensagem>> getAllMensagens(){
        return allMensagens;
    }
}
