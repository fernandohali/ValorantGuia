package com.example.valorantguia.maps.bind;

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

public class bindMapa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapa_bind);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Encontre todos os ImageButtons no layout e configure os listeners
        setupAgentButton(R.id.btnBrimstoneBind, AgentsBrimstone.class);
        setupAgentButton(R.id.btnphoenixBind, AgentsPhoenix.class);
        setupAgentButton(R.id.btnSageBind, AgentsSage.class);
        setupAgentButton(R.id.btnSovaBind, AgentsSova.class);
        setupAgentButton(R.id.btnViperBind, AgentsViper.class);
        setupAgentButton(R.id.btnCypherBind, AgentsCypher.class);
        setupAgentButton(R.id.btnReynaBind, AgentsReyna.class);
        setupAgentButton(R.id.btnKilljoyBind, AgentsKilljoy.class);
        setupAgentButton(R.id.btnOmenBind, AgentsOmen.class);
        setupAgentButton(R.id.btnJettBind, AgentsJett.class);
        setupAgentButton(R.id.btnBreachBind, AgentsBreach.class);
        setupAgentButton(R.id.btnSkyeBind, AgentsSkye.class);
        setupAgentButton(R.id.btnYoruBind, AgentsYoru.class);
        setupAgentButton(R.id.btnAstraBind, AgentsAstra.class);
        setupAgentButton(R.id.btnKayoBind, AgentsKayo.class);
        setupAgentButton(R.id.btnChamberBind, AgentsChamber.class);
        setupAgentButton(R.id.btnNeonBind, AgentsNeon.class);
        setupAgentButton(R.id.btnFadeBind, AgentsFade.class);
        setupAgentButton(R.id.btnHardorBind, AgentsHardor.class);
        setupAgentButton(R.id.btnGekkoBind, AgentsGekko.class);
        setupAgentButton(R.id.btnDeadlockBind, AgentsDeadlock.class);

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