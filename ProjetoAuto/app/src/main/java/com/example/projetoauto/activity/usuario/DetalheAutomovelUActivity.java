package com.example.projetoauto.activity.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.projetoauto.R;
import com.example.projetoauto.adapter.SliderAdapter;
import com.example.projetoauto.helper.Mascara;
import com.example.projetoauto.model.Automovel;
import com.example.projetoauto.model.Empresa;
import com.example.projetoauto.model.Endereco;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class DetalheAutomovelUActivity extends AppCompatActivity {

    private TextView txt_nome_empresa;
    private SliderView sliderView;
    private TextView txt_titulo_auto;
    private TextView txt_valor_venda;
    private TextView txt_data_publicado;
    private TextView txt_descricao;
    private TextView txt_modelo;
    private TextView txt_tipo;
    private TextView txt_ano;
    private TextView txt_quilometragem;
    private TextView txt_cep;
    private TextView txt_logradouro;
    private TextView txt_bairro;


    private Automovel automovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_automovel_uactivity);

        iniciaComponentes();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            automovel = (Automovel) bundle.getSerializable("automovelSelecionado");

            configDados();

        }
        configCliques();
    }

    private void configCliques(){
        findViewById(R.id.ib_voltar).setOnClickListener(v -> finish());
    }

    private void configDados(){

        sliderView.setSliderAdapter(new SliderAdapter(automovel.getUrlImagens()));
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(4);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        //txt_nome_empresa.setText(automovel.getEmpresa().getNome());
        txt_titulo_auto.setText(automovel.getTitulo());
        txt_valor_venda.setText(getString(R.string.valor_automovel, Mascara.getValor(automovel.getValorDeVenda())));
        txt_data_publicado.setText(getString(R.string.data_publicacao, Mascara.getData(automovel.getDataPublicacao(), 3)));
        txt_descricao.setText(automovel.getDescricao());
        txt_modelo.setText("Modelo: " + automovel.getModelo());
        txt_tipo.setText("Tipo: " + automovel.getIdTipo());
        txt_ano.setText("Ano" + automovel.getAno());
        txt_quilometragem.setText("KM: " + automovel.getQuilometragem());
        txt_cep.setText(automovel.getEndereco().getCep());
        txt_logradouro.setText(automovel.getEndereco().getLogradouro());
        txt_bairro.setText(automovel.getEndereco().getBairro());

    }


    private void iniciaComponentes(){
        txt_nome_empresa = findViewById(R.id.txt_nome_empresa);
        sliderView = findViewById(R.id.sliderView);
        txt_titulo_auto = findViewById(R.id.txt_titulo_auto);
        txt_valor_venda = findViewById(R.id.txt_valor_venda);
        txt_data_publicado = findViewById(R.id.txt_data_publicado);
        txt_descricao = findViewById(R.id.txt_descricao);
        txt_modelo = findViewById(R.id.txt_modelo);
        txt_tipo = findViewById(R.id.txt_tipo);
        txt_ano = findViewById(R.id.txt_ano);
        txt_quilometragem = findViewById(R.id.txt_quilometragem);
        txt_cep = findViewById(R.id.txt_cep);
        txt_logradouro = findViewById(R.id.txt_logradouro);
        txt_bairro = findViewById(R.id.txt_bairro);
    }


}

