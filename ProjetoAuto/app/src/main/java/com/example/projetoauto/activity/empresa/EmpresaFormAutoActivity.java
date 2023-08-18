package com.example.projetoauto.activity.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projetoauto.R;

public class EmpresaFormAutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_form_auto);

        configCliques();
    }


    private void configCliques(){
        findViewById(R.id.ib_voltar).setOnClickListener(v -> finish());
    }
}