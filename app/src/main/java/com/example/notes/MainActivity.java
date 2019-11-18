package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.notes.Model.Models.Mensagem;
import com.example.notes.ViewModel.MensagemViewModel;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    private MensagemViewModel mensagemViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagemViewModel = ViewModelProviders.of(this).get(MensagemViewModel.class);
        mensagemViewModel.getAllMensagens().observe(this, new Observer<List<Mensagem>>() {
            @Override
            public void onChanged(List<Mensagem> mensagens) {
               //update recyclerView;
            }
        });
    }
}
