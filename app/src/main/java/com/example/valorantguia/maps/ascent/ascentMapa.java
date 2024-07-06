package com.example.valorantguia.maps.ascent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;


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

public class ascentMapa extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mapa_ascent);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


        // Encontre todos os ImageButtons no layout e configure os listeners
        setupAgentButton(R.id.btnBrimstoneAscent, AgentsBrimstone.class);
        setupAgentButton(R.id.btnPhoenixAscent, AgentsPhoenix.class);
        setupAgentButton(R.id.btnSageAscent, AgentsSage.class);
        setupAgentButton(R.id.btnSovaAscent, AgentsSova.class);
        setupAgentButton(R.id.btnViperAscent, AgentsViper.class);
        setupAgentButton(R.id.btnCypherAscent, AgentsCypher.class);
        setupAgentButton(R.id.btnReynaAscent, AgentsReyna.class);
        setupAgentButton(R.id.btnKilljoyAscent, AgentsKilljoy.class);
        setupAgentButton(R.id.btnOmenAscent, AgentsOmen.class);
        setupAgentButton(R.id.btnJettAscent, AgentsJett.class);
        setupAgentButton(R.id.btnBreachAscent, AgentsBreach.class);
        setupAgentButton(R.id.btnSkyeAscent, AgentsSkye.class);
        setupAgentButton(R.id.btnYoruAscent, AgentsYoru.class);
        setupAgentButton(R.id.btnAstraAscent, AgentsAstra.class);
        setupAgentButton(R.id.btnKayoAscent, AgentsKayo.class);
        setupAgentButton(R.id.btnChamberAscent, AgentsChamber.class);
        setupAgentButton(R.id.btnNeonAscent, AgentsNeon.class);
        setupAgentButton(R.id.btnFadeAscent, AgentsFade.class);
        setupAgentButton(R.id.btnHardorAscent, AgentsHardor.class);
        setupAgentButton(R.id.btnGekkoAscent, AgentsGekko.class);
        setupAgentButton(R.id.btnDeadlockAscent, AgentsDeadlock.class);

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
