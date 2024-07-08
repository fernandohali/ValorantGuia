package com.example.valorantguia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.valorantguia.TelaPrincipal.AgentsFragment;
import com.example.valorantguia.TelaPrincipal.HomeFragment;
import com.example.valorantguia.database.DataBase;
import com.example.valorantguia.database.Usuario;
import com.example.valorantguia.databinding.ActivityTelaPrincipalBinding;

public class MainActivity extends AppCompatActivity {

    ActivityTelaPrincipalBinding binding;

    EditText editLogin, editSenha;

    Button btnLogin;
    TextView txtCadastrar; // Texto para navegação para a tela de cadastro


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

//        binding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);
        txtCadastrar = findViewById(R.id.txtCadastrar);

        btnLogin.setOnClickListener(v -> {
            logar();

        });

        // Adicionar eventos aos componentes
        txtCadastrar.setOnClickListener((View view) -> { // Usando Lambda Function
            Intent intent = new Intent(MainActivity.this, Cadastro.class);
            startActivity(intent); // Navega para a tela de cadastro
        });
    }

    private void logar() {
        // Verifica se os campos foram preenchidos
        if (validarCampos() == false) {
            //Toast.makeText(this,"FALHOU",Toast.LENGTH_SHORT).show();
            return;
        }
        // Captura os textos dos componentes
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        // Valida as credenciais de login
        if (validarLogin(login, senha) == false) {
            Toast.makeText(this, "Dados de login incorretos", Toast.LENGTH_LONG).show();
            return;
        }
        // Se a validação for bem-sucedida, muda para a tela principal do administrador
        Intent intent = new Intent(this, TelaPrincipalActivity.class);
        startActivity(intent);
    }

    // Método para validar se os campos de login e senha estão preenchidos
    private boolean validarCampos() {
        if (editLogin.getText().toString().trim().equals("")) {
            editLogin.setError("Login obrigatório!");
            return false;
        }
        if (editSenha.getText().toString().trim().equals("")) {
            editSenha.setError("Senha obrigatória!");
            return false;
        }
        return true;
    }

    // Método para validar o login do usuário
    private boolean validarLogin(String login, String senha) {
        // Cria ou obtém uma instância do banco de dados usando Room
        DataBase db = Room.databaseBuilder(getApplicationContext(), DataBase.class, "Base de Dados")
                .allowMainThreadQueries() // Permite consultas na thread principal
                .build();
        // Obtém o usuário com as credenciais fornecidas
        Usuario usuario = db.getUserDao().getUserLogin(login, senha);
        // Retorna verdadeiro se o usuário for encontrado, caso contrário, falso
        return usuario != null;
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            replaceFragment(new HomeFragment());
            return true;
        } else if (item.getItemId() == R.id.agents) {
            replaceFragment(new AgentsFragment());
            return true;
        }
        return false;
    }
}
