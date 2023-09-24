package com.example.projetoauto.activity.empresa;

import androidx.annotation.NonNull;
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
import com.example.projetoauto.helper.FirebaseHelper;
import com.example.projetoauto.model.Endereco;
import com.example.projetoauto.model.Tipo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class EmpresaFormAutoActivity extends AppCompatActivity {

    private Endereco endereco;

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
    private TextView txt_endereco;

    private TextView text_toolbar;

    private final int REQUEST_TIPO = 100;
    private final int REQUEST_ENDERECO = 200;

    private String tipoSelecionado = "";
    private String enderecoSelecionado = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_form_auto);

        iniciaComponentes();

        configCliques();

        recuperaEndereco();
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

    public void selecionarEndereco(View view){
        Intent intent = new Intent(this, EmpresaSelecionaEnderecoActivity.class);
        startActivityForResult(intent, REQUEST_ENDERECO);

    }

    private void recuperaEndereco(){
        if(FirebaseHelper.getAutenticado()){
            DatabaseReference enderecoRef = FirebaseHelper.getDatabaseReference()
                    .child("enderecos")
                    .child(FirebaseHelper.getIdFirebase());

            enderecoRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        for(DataSnapshot ds : snapshot.getChildren()){
                            endereco = ds.getValue(Endereco.class);
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            if(requestCode == REQUEST_TIPO){

                Tipo tipo = (Tipo) data.getSerializableExtra("tipoSelecionado");
                tipoSelecionado = tipo.getNome();
                btn_tipo.setText(tipoSelecionado);


            }else if(requestCode == REQUEST_ENDERECO){
                endereco = (Endereco) data.getSerializableExtra("enderecoSelecionado");
                enderecoSelecionado = endereco.getLogradouro();
                txt_endereco.setText(endereco.getBairro() + " " + endereco.getUf());
                btn_endereco.setText(enderecoSelecionado);

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
        txt_endereco = findViewById(R.id.txt_endereco);

        edt_valor_vendido = findViewById(R.id.edt_valor_vendido);
        edt_valor_vendido.setLocale(new Locale("PT", "br"));
        edt_valor_comprado = findViewById(R.id.edt_valor_comprado);
        edt_valor_comprado.setLocale(new Locale("PT", "br"));

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

    }

}