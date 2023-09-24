package com.example.projetoauto.activity.empresa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcat.currencyedittext.CurrencyEditText;
import com.example.projetoauto.R;
import com.example.projetoauto.model.Tipo;

import java.util.Locale;

public class EmpresaFormAutoActivity extends AppCompatActivity {

    private ImageView img0;
    private ImageView img1;
    private ImageView img2;

    private EditText edt_titulo;
    private EditText edt_descricao;
    private Button btn_tipo;
    private EditText edt_placa;
    private EditText edt_modelo;
    private EditText edt_ano;

    private CurrencyEditText edt_valor_vendido;
    private CurrencyEditText edt_valor_comprado;

    private Button btn_endereco;

    private TextView text_toolbar;

    private final int REQUEST_TIPO = 100;

    private String tipoSelecionado = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_form_auto);

        configCliques();

        iniciaComponentes();
    }


    private void configCliques(){
        findViewById(R.id.ib_voltar).setOnClickListener(v -> finish());
    }

    public void validaDados(View view){

    }

    public void selecionarTipo(View view){
        Intent intent= new Intent(this, EmpresaTipoAutomovelActivity.class);
        startActivityForResult(intent, REQUEST_TIPO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_TIPO){

                Tipo tipo = (Tipo) data.getSerializableExtra("tipoSelecionado");
                tipoSelecionado = tipo.getNome();
                btn_tipo.setText(tipoSelecionado);


            }else if(true){ //Camera

            }else{ //Galeria

            }
        }
    }

    private void iniciaComponentes(){
        text_toolbar = findViewById(R.id.text_toolbar);
        text_toolbar.setText("Novo Automovel");

        edt_titulo = findViewById(R.id.edt_titulo);
        edt_descricao = findViewById(R.id.edt_descricao);
        btn_tipo = findViewById(R.id.btn_tipo);
        edt_placa = findViewById(R.id.edt_placa);
        edt_modelo = findViewById(R.id.edt_modelo);
        edt_ano = findViewById(R.id.edt_ano);
        btn_endereco = findViewById(R.id.btn_endereco);

        edt_valor_vendido = findViewById(R.id.edt_valor_vendido);
        edt_valor_vendido.setLocale(new Locale("PT", "br"));
        edt_valor_comprado = findViewById(R.id.edt_valor_comprado);
        edt_valor_comprado.setLocale(new Locale("PT", "br"));

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

    }

}