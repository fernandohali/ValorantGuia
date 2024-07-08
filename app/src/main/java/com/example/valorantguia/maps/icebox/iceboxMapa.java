package com.example.valorantguia.maps.icebox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.valorantguia.R;
import com.example.valorantguia.maps.AgentsMapas.AgentsAstra;
import com.example.valorantguia.maps.AgentsMapas.AgentsBreach;
import com.example.valorantguia.maps.AgentsMapas.AgentsBrimstone;
import com.example.valorantguia.maps.AgentsMapas.AgentsChamber;
import com.example.valorantguia.maps.AgentsMapas.AgentsCypher;
import com.example.valorantguia.maps.AgentsMapas.AgentsDeadlock;
import com.example.valorantguia.maps.AgentsMapas.AgentsFade;
import com.example.valorantguia.maps.AgentsMapas.AgentsGekko;
import com.example.valorantguia.maps.AgentsMapas.AgentsHardor;
import com.example.valorantguia.maps.AgentsMapas.AgentsJett;
import com.example.valorantguia.maps.AgentsMapas.AgentsKayo;
import com.example.valorantguia.maps.AgentsMapas.AgentsKilljoy;
import com.example.valorantguia.maps.AgentsMapas.AgentsNeon;
import com.example.valorantguia.maps.AgentsMapas.AgentsOmen;
import com.example.valorantguia.maps.AgentsMapas.AgentsPhoenix;
import com.example.valorantguia.maps.AgentsMapas.AgentsReyna;
import com.example.valorantguia.maps.AgentsMapas.AgentsSage;
import com.example.valorantguia.maps.AgentsMapas.AgentsSkye;
import com.example.valorantguia.maps.AgentsMapas.AgentsSova;
import com.example.valorantguia.maps.AgentsMapas.AgentsViper;
import com.example.valorantguia.maps.AgentsMapas.AgentsYoru;

public class iceboxMapa extends AppCompatActivity {

    private static final String MAP_NAME = "Icebox"; // Nome do mapa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapa_icebox);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Encontre todos os ImageButtons no layout e configure os listeners
        setupAgentButton(R.id.btnBrimstoneIcebox, AgentsBrimstone.class);
        setupAgentButton(R.id.btnphoenixIcebox, AgentsPhoenix.class);
        setupAgentButton(R.id.btnSageIcebox, AgentsSage.class);
        setupAgentButton(R.id.btnSovaIcebox, AgentsSova.class);
        setupAgentButton(R.id.btnViperIcebox, AgentsViper.class);
        setupAgentButton(R.id.btnCypherIcebox, AgentsCypher.class);
        setupAgentButton(R.id.btnReynaIcebox, AgentsReyna.class);
        setupAgentButton(R.id.btnKilljoyIcebox, AgentsKilljoy.class);
        setupAgentButton(R.id.btnOmenIcebox, AgentsOmen.class);
        setupAgentButton(R.id.btnJettIcebox, AgentsJett.class);
        setupAgentButton(R.id.btnBreachIcebox, AgentsBreach.class);
        setupAgentButton(R.id.btnSkyeIcebox, AgentsSkye.class);
        setupAgentButton(R.id.btnYoruIcebox, AgentsYoru.class);
        setupAgentButton(R.id.btnAstraIcebox, AgentsAstra.class);
        setupAgentButton(R.id.btnKayoIcebox, AgentsKayo.class);
        setupAgentButton(R.id.btnChamberIcebox, AgentsChamber.class);
        setupAgentButton(R.id.btnNeonIcebox, AgentsNeon.class);
        setupAgentButton(R.id.btnFadeIcebox, AgentsFade.class);
        setupAgentButton(R.id.btnHardorIcebox, AgentsHardor.class);
        setupAgentButton(R.id.btnGekkoIcebox, AgentsGekko.class);
        setupAgentButton(R.id.btnDeadlockIcebox, AgentsDeadlock.class);
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
        intent.putExtra("mapName", MAP_NAME); // Passa o nome do mapa como extra
        startActivity(intent);
    }
}
