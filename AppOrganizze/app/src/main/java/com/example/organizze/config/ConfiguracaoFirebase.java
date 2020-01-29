package com.example.organizze.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    private static FirebaseAuth autenticacao;
    private static DatabaseReference referencia;

    public static DatabaseReference getFirebaseDatabase(){
        if (referencia == null){
            referencia = FirebaseDatabase.getInstance().getReference();
        }
        return referencia;
    }

    public static FirebaseAuth getFirebaseAutenticacao() {
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

}