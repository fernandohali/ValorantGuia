package com.example.valorantguia.maps.AgentsMapas;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.view.View; // Importação necessária para o objeto View

import androidx.appcompat.app.AppCompatActivity;

import com.example.valorantguia.R;

public class AgentsBrimstone extends AppCompatActivity {

    private WebView webView1;
    private WebView webView2;
    private ImageButton btnAttackBrimstone;
    private ImageButton btnButtonINCENDIARIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_brimstone);

        // Encontrando os WebViews no layout XML
        webView1 = findViewById(R.id.video_Attack_brimstone_sunset1);
        webView2 = findViewById(R.id.video_Attack_brimstone_sunset2);

        // Encontrando os ImageButtons no layout XML
        btnAttackBrimstone = findViewById(R.id.btnAttackBrimstone);
        btnButtonINCENDIARIO = findViewById(R.id.BtnButtonINCENDIARIO);

        // Configurando os WebViews para carregar vídeos do YouTube
        configureWebView(webView1, "https://www.youtube.com/embed/uXKPmTghKNE");
        configureWebView(webView2, "https://www.youtube.com/embed/z3sgtrAU_LY");

        // Configurando o clique no botão BtnButtonINCENDIARIO
        btnButtonINCENDIARIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser realizada quando o botão BtnButtonINCENDIARIO for clicado
                btnButtonINCENDIARIO.setSelected(!btnButtonINCENDIARIO.isSelected()); // Toggle the selection state

                // Verifica se todas as condições são atendidas para mostrar o vídeo
                if (btnAttackBrimstone.isSelected() && btnButtonINCENDIARIO.isSelected()) {
                    webView1.setVisibility(View.VISIBLE);
                    webView2.setVisibility(View.VISIBLE);
                } else {
                    webView1.setVisibility(View.GONE);
                    webView2.setVisibility(View.GONE);
                }
            }
        });

        // Configurando o clique no botão de ataque
        btnAttackBrimstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação a ser realizada quando o botão de ataque for clicado
                btnAttackBrimstone.setSelected(!btnAttackBrimstone.isSelected()); // Toggle the selection state

                // Verifica se todas as condições são atendidas para mostrar o vídeo
                if (btnAttackBrimstone.isSelected() && btnButtonINCENDIARIO.isSelected()) {
                    webView1.setVisibility(View.VISIBLE);
                    webView2.setVisibility(View.VISIBLE);
                } else {
                    webView1.setVisibility(View.GONE);
                    webView2.setVisibility(View.GONE);
                }
            }
        });
    }

    // Método para configurar um WebView para carregar um vídeo do YouTube
    private void configureWebView(WebView webView, String videoUrl) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilita JavaScript (necessário para o YouTube)
        webView.setWebViewClient(new WebViewClient()); // Para evitar abrir o navegador externo ao clicar

        // Carrega o vídeo no WebView
        webView.loadUrl(videoUrl);
    }

    // Sobrescreva onDestroy para evitar vazamentos de memória ao parar a reprodução do vídeo
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView1 != null) {
            webView1.destroy();
        }
        if (webView2 != null) {
            webView2.destroy();
        }
    }
}
