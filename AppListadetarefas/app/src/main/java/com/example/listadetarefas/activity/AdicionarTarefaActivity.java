package com.example.listadetarefas.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listadetarefas.R;
import com.example.listadetarefas.helper.TarefaDAO;
import com.example.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelicionada");

        if(tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSalvar :
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if(tarefaAtual != null){

                    String nomeTarefa = editTarefa.getText().toString();
                    if( !nomeTarefa.isEmpty() ) {

                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        if(tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Tarefa atualizada com sucesso!",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao atualizar a tarefa",
                                    Toast.LENGTH_SHORT).show();
                            }
                        }


                } else {
                    String nomeTarefa = editTarefa.getText().toString();
                    if( !nomeTarefa.isEmpty() ){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if (tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Texto salvo com sucesso!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar a tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                }



                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
