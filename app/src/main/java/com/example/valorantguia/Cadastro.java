package com.example.valorantguia;

// Importações necessárias para o funcionamento da Activity
import android.annotation.SuppressLint;
import android.graphics.Color; // Para manipulação de cores
import android.os.Bundle; // Para manipulação de pacotes de dados entre atividades
import android.view.MotionEvent; // Para manipulação de eventos de toque
import android.view.View; // Para manipulação de views
import android.widget.Button; // Para utilização de botões
import android.widget.EditText; // Para utilização de campos de texto
import android.widget.Toast; // Para exibição de mensagens toast

import androidx.activity.EdgeToEdge; // Para permitir o modo Edge-to-Edge
import androidx.appcompat.app.AppCompatActivity; // Para compatibilidade com atividades antigas
import androidx.room.Room; // Para construção de banco de dados usando Room


import com.example.valorantguia.database.DataBase;
import com.example.valorantguia.database.Usuario;
import com.example.valorantguia.database.UsuarioDao;

public class Cadastro extends AppCompatActivity {
    // Declaração de botões e campos de texto
    Button btn_voltar_cadastro, btn_salvar_cadastro;
    EditText edit_nome_cadastro, edit_senha_cadastro, edit_idade_cadastro;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilita o modo Edge-to-Edge para esta atividade
        EdgeToEdge.enable(this);
        // Define o layout da atividade
        setContentView(R.layout.activity_cadastro);

        // Comentário de código desativado para configuração de inserções de janela
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        // Captura dos componentes do layout
        btn_voltar_cadastro = findViewById(R.id.btn_voltar_cadastro);
        btn_salvar_cadastro = findViewById(R.id.btn_salvar_cadastro);
        edit_nome_cadastro = findViewById(R.id.edit_nome_cadastro);
        edit_idade_cadastro = findViewById(R.id.edit_idade_cadastro);
        edit_senha_cadastro = findViewById(R.id.edit_senha_cadastro);

        // Define um OnClickListener para o botão de voltar
        btn_voltar_cadastro.setOnClickListener((View view) -> {
            finish(); // Encerra a activity
        });

        // Define um OnTouchListener para o botão de salvar
        btn_salvar_cadastro.setOnTouchListener((View view, MotionEvent event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                cadastrar(); // Chama o método de cadastro
                btn_salvar_cadastro.setTextColor(Color.BLACK); // Altera a cor do texto do botão
                btn_salvar_cadastro.setBackgroundColor(Color.argb(255, 200, 0, 255)); // Altera a cor de fundo do botão
            } else {
                btn_salvar_cadastro.setTextColor(Color.WHITE); // Restaura a cor do texto do botão
                btn_salvar_cadastro.setBackgroundColor(Color.argb(255, 25, 0, 80)); // Restaura a cor de fundo do botão
            }
            return true; // Retorna verdadeiro para indicar que o evento foi consumido
        });
    }

    // Método para cadastrar um novo usuário
    private void cadastrar() {
        // Valida os campos de entrada
        if (validarCampos() == false) return;

        // Captura os textos dos campos
        String nome = edit_nome_cadastro.getText().toString();
        int idade = Integer.parseInt(edit_idade_cadastro.getText().toString());
        String senha = edit_senha_cadastro.getText().toString();

        // Prepara a entidade Usuario para inserção
        Usuario usuario = new Usuario();
        usuario.login = nome;
        usuario.idade = idade;
        usuario.senha = senha;

        // Conecta ao banco de dados e obtém o DAO do Usuario
        DataBase db = Room.databaseBuilder(getApplicationContext(), DataBase.class, "Base de Dados")
                .allowMainThreadQueries().build();
        UsuarioDao dao = db.getUserDao();

        // Verifica se o usuário já existe no banco de dados
        Usuario repetido = dao.checkDuplicated(usuario.login);
        if (repetido != null) {
            Toast.makeText(this, "Já existe um usuário com este nome no banco de dados!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Salva o novo usuário no banco de dados
        dao.insereUsuario(usuario);
        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish(); // Encerra a activity após o cadastro
    }

    // Método para validar os campos de entrada
    private boolean validarCampos() {
        if (edit_nome_cadastro.getText().toString().isEmpty()) {
            edit_nome_cadastro.setError("Nome obrigatório");
            return false;
        }
        if (edit_idade_cadastro.getText().toString().isEmpty()) {
            edit_idade_cadastro.setError("Idade obrigatória");
            return false;
        }
        if (edit_senha_cadastro.getText().toString().isEmpty()) {
            edit_senha_cadastro.setError("Senha obrigatória");
            return false;
        }
        return true; // Retorna verdadeiro se todos os campos estiverem preenchidos corretamente
    }
}
