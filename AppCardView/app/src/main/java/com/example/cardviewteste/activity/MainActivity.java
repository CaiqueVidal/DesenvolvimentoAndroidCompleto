package com.example.cardviewteste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cardviewteste.R;
import com.example.cardviewteste.adapter.PostagemAdapter;
import com.example.cardviewteste.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);


        //Define adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens(){

        Postagem post = new Postagem("Maria Luiza", "#tbt Viagem legal!", R.drawable.imagem4);
        this.postagens.add( post );

        post = new Postagem("Hotel JM", "Viage, aproveite nossos descontos", R.drawable.imagem1);
        this.postagens.add( post );

        post = new Postagem("Caique Freitas", "#Paris", R.drawable.imagem3);
        this.postagens.add( post );

        post = new Postagem("Marcos Paulo", "Que foto linda", R.drawable.imagem2);
        this.postagens.add( post );

        post = new Postagem("Teste", "teste", R.drawable.imagem4);
        this.postagens.add(post);

    }

}
