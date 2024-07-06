package com.example.valorantguia.maps.split;

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

public class splitMapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapa_split);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Encontre todos os ImageButtons no layout e configure os listeners
        setupAgentButton(R.id.btnBrimstoneSplit, AgentsBrimstone.class);
        setupAgentButton(R.id.btnPhoenixSplit, AgentsPhoenix.class);
        setupAgentButton(R.id.btnSageSplit, AgentsSage.class);
        setupAgentButton(R.id.btnSovaSplit, AgentsSova.class);
        setupAgentButton(R.id.btnViperSplit, AgentsViper.class);
        setupAgentButton(R.id.btnCypherSplit, AgentsCypher.class);
        setupAgentButton(R.id.btnReynaSplit, AgentsReyna.class);
        setupAgentButton(R.id.btnKilljoySplit, AgentsKilljoy.class);
        setupAgentButton(R.id.btnOmenSplit, AgentsOmen.class);
        setupAgentButton(R.id.btnJettSplit, AgentsJett.class);
        setupAgentButton(R.id.btnBreachSplit, AgentsBreach.class);
        setupAgentButton(R.id.btnSkyeSplit, AgentsSkye.class);
        setupAgentButton(R.id.btnYoruSplit, AgentsYoru.class);
        setupAgentButton(R.id.btnAstraSplit, AgentsAstra.class);
        setupAgentButton(R.id.btnKayoSplit, AgentsKayo.class);
        setupAgentButton(R.id.btnChamberSplit, AgentsChamber.class);
        setupAgentButton(R.id.btnNeonSplit, AgentsNeon.class);
        setupAgentButton(R.id.btnFadeSplit, AgentsFade.class);
        setupAgentButton(R.id.btnHardorSplit, AgentsHardor.class);
        setupAgentButton(R.id.btnGekkoSplit, AgentsGekko.class);
        setupAgentButton(R.id.btnDeadlockSplit, AgentsDeadlock.class);

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