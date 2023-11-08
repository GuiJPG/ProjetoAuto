package com.example.projetoauto.fragment.usuario;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.projetoauto.R;
import com.example.projetoauto.activity.usuario.UsuarioDetalheAutomovelActivity;
import com.example.projetoauto.adapter.AdapterListaAutomovel;
import com.example.projetoauto.helper.FirebaseHelper;
import com.example.projetoauto.model.Automovel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UsuarioHomeFragment extends Fragment implements AdapterListaAutomovel.OnclickListener {

    private AdapterListaAutomovel adapterListaAutomovel;

    private final List<Automovel> automovelList = new ArrayList<>();

    private TextView text_info;

    private ProgressBar progressBar;

    private RecyclerView rv_automoveis;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuario_home, container, false);

        iniciarComponentes(view);

        configRV();

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

        recuperaAutomoveis();
    }

    private void recuperaAutomoveis() {
        DatabaseReference automoveisRef = FirebaseHelper.getDatabaseReference()
                .child("automoveis_publicos");

        automoveisRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    automovelList.clear();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        Automovel automovel = ds.getValue(Automovel.class);
                        automovelList.add(automovel);

                    }
                    text_info.setText("");
                    Collections.reverse(automovelList);
                    adapterListaAutomovel.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                } else {
                    text_info.setText("Nenhum Automovel Cadastrado");
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void configRV() {
        rv_automoveis.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_automoveis.setHasFixedSize(true);
        adapterListaAutomovel = new AdapterListaAutomovel(automovelList, this);
        rv_automoveis.setAdapter(adapterListaAutomovel);
    }

    private void iniciarComponentes(View view) {
        rv_automoveis = view.findViewById(R.id.rv_automoveis);

        progressBar = view.findViewById(R.id.progressBar);
        text_info = view.findViewById(R.id.text_info);


    }

    @Override
    public void OnClick(Automovel automovel) {
        Intent intent = new Intent(requireContext(), UsuarioDetalheAutomovelActivity.class);
        intent.putExtra("automovelSelecionado", automovel);
        startActivity(intent);
    }
}