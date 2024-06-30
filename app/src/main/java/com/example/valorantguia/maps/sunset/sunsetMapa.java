package com.example.valorantguia.maps.sunset;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.valorantguia.R;
import com.example.valorantguia.maps.AgentsMapas.AgentsBrimstone;
import com.example.valorantguia.maps.AgentsMapas.AgentsPhoenix;
import com.example.valorantguia.maps.AgentsMapas.AgentsSage;

public class sunsetMapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_sunset);

        // Configuração da borda da tela
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontre todos os ImageButtons no layout e configure os listeners
        setupAgentButton(R.id.btnBrimstoneSunset, AgentsBrimstone.class);
        setupAgentButton(R.id.btnphoenixSunset, AgentsPhoenix.class);
        setupAgentButton(R.id.btnSageSunset, AgentsSage.class);
//        setupAgentButton(R.id.btnSovaSunset, AgentsSova.class);
//        setupAgentButton(R.id.btnViperSunset, AgentsViper.class);
//        setupAgentButton(R.id.btnCypherSunset, AgentsCypher.class);
//        setupAgentButton(R.id.btnReynaSunset, AgentsReyna.class);
//        setupAgentButton(R.id.btnKilljoySunset, AgentsKilljoy.class);
//        setupAgentButton(R.id.btnOmenSunset, AgentsOmen.class);
//        setupAgentButton(R.id.btnJettSunset, AgentsJett.class);
//        setupAgentButton(R.id.btnBreachSunset, BreachAgents.class);
//        setupAgentButton(R.id.btnSkyeSunset, AgentsSkye.class);
//        setupAgentButton(R.id.btnYoruSunset, AgentsYoru.class);
//        setupAgentButton(R.id.btnAstraSunset, AgentsAstra.class);
//        setupAgentButton(R.id.btnKayoSunset, AgentsKayo.class);
//        setupAgentButton(R.id.btnChamberSunset, ChamberAgents.class);
//        setupAgentButton(R.id.btnNeonSunset, NeonAgents.class);
//        setupAgentButton(R.id.btnFadeSunset, FadeAgents.class);
//        setupAgentButton(R.id.btnHardorSunset, HardorAgents.class);
//        setupAgentButton(R.id.btnGekkoSunset, GekkoAgents.class);
//        setupAgentButton(R.id.btnDeadlockSunset, DeadlockAgents.class);
    }

    private void setupAgentButton(int buttonId, final Class<?> agentClass) {
        ImageButton button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAgentActivity(agentClass);
            }
        });
    }

    private void openAgentActivity(Class<?> agentClass) {
        Intent intent = new Intent(this, agentClass);
        startActivity(intent);
    }
}
