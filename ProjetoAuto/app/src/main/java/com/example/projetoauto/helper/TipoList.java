package com.example.projetoauto.helper;


import com.example.projetoauto.R;
import com.example.projetoauto.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class TipoList {

    public static List<Tipo> getList(boolean todas) {

        List<Tipo> categoriaList = new ArrayList<>();
        if (todas) categoriaList.add(new Tipo(R.drawable.ic_todos_tipos, "Todos os Tipos"));
        categoriaList.add(new Tipo(R.drawable.ic_moto, "A - Motos e Triciclos"));
        categoriaList.add(new Tipo(R.drawable.ic_carro, "B - Carros de Passeios"));
        categoriaList.add(new Tipo(R.drawable.ic_caminhao, "C - Veiculos de Carga + 3,5 ton."));
        categoriaList.add(new Tipo(R.drawable.ic_van, "D Veiculos com + 8 pessoas."));
        categoriaList.add(new Tipo(R.drawable.ic_caminhao_grande, "E Veiculos de Carga + 6 ton."));


        return categoriaList;

    }

}
