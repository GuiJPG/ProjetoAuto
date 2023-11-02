package com.example.projetoauto.activity.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.projetoauto.R;
import com.example.projetoauto.activity.empresa.EmpresaFormEnderecoActivity;

public class UsuarioCalendarioActivity extends AppCompatActivity {

    private CalendarView CalendarView_calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_calendario);

        iniciaComponentes();

        configCliques();

    }



    private void iniciaComponentes(){
        TextView text_toolbar = findViewById(R.id.text_toolbar);
        text_toolbar.setText("Agendamento");

        CalendarView_calendario = findViewById(R.id.CalendarView_calendario);
    }

    private void configCliques() {
        findViewById(R.id.ib_voltar).setOnClickListener(v -> finish());

    }
}