package com.example.loginapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.loginapp.database.DataBase;
import com.example.loginapp.database.Usuario;
import com.example.loginapp.database.UsuarioDao;

public class Cadastro extends AppCompatActivity {
    Button btn_voltar_cadastro, btn_salvar_cadastro;
    EditText edit_nome_cadastro,edit_senha_cadastro,edit_idade_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        // captura de componentes
        btn_voltar_cadastro = findViewById(R.id.btn_voltar_cadastro);
        btn_salvar_cadastro = findViewById(R.id.btn_salvar_cadastro);
        edit_nome_cadastro = findViewById(R.id.edit_nome_cadastro);
        edit_idade_cadastro = findViewById(R.id.edit_idade_cadastro);
        edit_senha_cadastro = findViewById(R.id.edit_senha_cadastro);
        btn_voltar_cadastro.setOnClickListener((View view)->{
            finish(); // encerra a activity
        });
        btn_salvar_cadastro.setOnTouchListener((View view, MotionEvent event)->{
            if(event.getAction()==MotionEvent.ACTION_DOWN) {
                cadastrar();
                btn_salvar_cadastro.setTextColor(Color.BLACK);
                btn_salvar_cadastro.setBackgroundColor(Color.argb(255, 200, 0, 255));
            }else{
                btn_salvar_cadastro.setTextColor(Color.WHITE);
                btn_salvar_cadastro.setBackgroundColor(Color.argb(255, 25, 0, 80));
            }
            return true;
        });

    }

    private void cadastrar() {
        // validar campos
        if(validarCampos()==false)return;

        // capturas os textos dos campos
        String nome = edit_nome_cadastro.getText().toString();
        int idade = Integer.parseInt(edit_idade_cadastro.getText().toString());
        String senha = edit_senha_cadastro.getText().toString();

        // prepara o Entidade para a inserção
        Usuario usuario = new Usuario();
        usuario.login=nome;
        usuario.idade=idade;
        usuario.senha=senha;

        DataBase db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"Base de Dados").allowMainThreadQueries().build();
        UsuarioDao dao = db.getUserDao();

        // verifica usuário já existente
        Usuario repetido = dao.checkDuplicated(usuario.login);
        if(repetido!=null){
            Toast.makeText(this, "Já existe um usuário com este nome no banco de dados!", Toast.LENGTH_SHORT).show();
            return;
        }

        // salva o suuário
        dao.insereUsuario(usuario);
        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private boolean validarCampos(){
        if(edit_nome_cadastro.getText().toString().isEmpty()){
            edit_nome_cadastro.setError("Nome obrigatório");
            return false;
        }
        if(edit_idade_cadastro.getText().toString().isEmpty()){
            edit_idade_cadastro.setError("Idade obrigatória");
            return false;
        }
        if(edit_senha_cadastro.getText().toString().isEmpty()){
            edit_senha_cadastro.setError("Senha obrigatória");
            return false;
        }
        return true;
    }
}