package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // *******************************************************************
    // ATRIBUTOS
    // *******************************************************************
    EditText editLogin, editSenha;
    Button btnLogin, btnSair;
    TextView txtCadastrar;

    // *******************************************************************
    // MÉTODOS DO CICLO DE VIDA
    // *******************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        insereDadosUsuario();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        // Captura dos componentes
        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnSair = findViewById(R.id.btnSair);
        txtCadastrar = findViewById(R.id.txtCadastrar);

        // Adicionar os eventos
        txtCadastrar.setOnClickListener((View view)->{ // FORMA MODERNA - LAMBDA FUNCTION
                Toast.makeText(MainActivity.this,"Cadastrar Usuário",Toast.LENGTH_SHORT).show();
        });
        btnLogin.setOnClickListener((View view)->{ // FORMA MODERNA - LAMBDA FUNCTION
            logar();
        });
        btnSair.setOnClickListener((View view)->{ // FORMA MODERNA - LAMBDA FUNCTION
            finishAndRemoveTask(); // encerra a aplicação
        });
    }

    // *******************************************************************
    // MÉTODOS
    // *******************************************************************
    private void logar(){
        // verifica se os campos foram preenchidos
        if(validarCampos()==false){
            //Toast.makeText(this,"FALHOU",Toast.LENGTH_SHORT).show();
            return;
        }
        // capturar os textos dos componentnes
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        if(validarLogin(login,senha)==false){
            Toast.makeText(this,"Dados de login incorretos",Toast.LENGTH_LONG).show();
            return;
        }
        // mudança de tela
        Intent intent = new Intent(this,TelaPrincipalAdmin.class);
        startActivity(intent);
    }
    private boolean validarCampos(){
        if(editLogin.getText().toString().trim().equals("")){
            editLogin.setError("Login obrigatório!");
            return false;
        }
        if(editSenha.getText().toString().trim().equals("")){
            editSenha.setError("Senha obrigatória!");
            return false;
        }
        return true;
    }
    private boolean validarLogin(String login, String senha){
        DataBase db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"Base de Dados").allowMainThreadQueries().build();
        Usuario usuario = db.getUserDao().getUserLogin(login,senha);
        if (usuario==null) return false;
        return true;
    }
    private void insereDadosUsuario(){
        DataBase db = Room.databaseBuilder(getApplicationContext(),DataBase.class,"Base de Dados").allowMainThreadQueries().build();
        List<Usuario> listaUsuarios = db.getUserDao().getAll();
        if (!listaUsuarios.isEmpty()) return; // abandona

        // insere os dados
        for(int i=1;i<=10;i++){
            Usuario usuario = new Usuario();
            usuario.id=i;
            usuario.login="user"+i;
            usuario.senha="master"+i;
            db.getUserDao().insereUsuario(usuario);
        }

    }
}