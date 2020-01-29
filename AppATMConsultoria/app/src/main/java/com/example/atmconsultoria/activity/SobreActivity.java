package com.example.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_sobre);
        String descricao = "A ATM Consultoria tem como missão apoair as organizações que desejam alcançar o sucesso através da excelência  em gestão e da busca de qualidade. \n\n"+
                "Nosso trabalho  é dar suporte as empresas que desejam se certificar em padrões de qualidade ou investir no desenvolvimento e evolução de sua gestão, por meio de otimização "+
                "dos processos e da diseminação dos Fundamentos e Critérios de Excelência.";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("atmconsultoria@gmail.com", "Envie um email")
                .addWebsite("https://www.google.com/", "Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("google", "Facebook")
                .addInstagram("google", "Instagram")
                .addTwitter("google", "Twitter")
                .addYoutube("google", "Youtube")
                .addGitHub("CaiqueVidal", "GitHub")
                .create();
        setContentView( sobre );
    }
}
