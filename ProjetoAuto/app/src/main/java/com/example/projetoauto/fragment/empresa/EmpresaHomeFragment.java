package com.example.projetoauto.fragment.empresa;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projetoauto.R;
import com.example.projetoauto.activity.empresa.EmpresaFormAutoActivity;


public class EmpresaHomeFragment extends Fragment {

    private Button btn_inserir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empresa_home, container, false);

        iniciarComponentes(view);

        configCliques();

        return view;
    }

    private void configCliques(){
        btn_inserir.setOnClickListener(v -> startActivity(new Intent(requireActivity(), EmpresaFormAutoActivity.class)));
    }

    private void iniciarComponentes(View view){
        btn_inserir = view.findViewById(R.id.btn_inserir);
        //view.findViewById(R.id.ib_voltar).setOnClickListener(v -> requireActivity().finish());


    }

}