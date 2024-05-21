package com.example.loginapp.TelaPrincipal;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.R;
import com.example.loginapp.database.Produto;

import java.util.List;

public class TelaPrincipalAdmin extends AppCompatActivity {

    SearchView searchPrincipal;
    RecyclerView listViewPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_principal_admin);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        // captura dos componentes
        searchPrincipal = findViewById(R.id.searchPrincipal);
        listViewPrincipal = findViewById(R.id.listViewPrincipal);

        ListAdapter adapter = new ListAdapter(Produto.getProdutosFicticios(20),this);
        listViewPrincipal.setAdapter(adapter);
        listViewPrincipal.setLayoutManager(new LinearLayoutManager(this));

    }
}