package com.example.valorantguia.maps.AgentsMapas;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.valorantguia.R;

public class AgentsBrimstone extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_brimstone);

        // Encontrando o WebView no layout XML
        webView = findViewById(R.id.video_Attack_sunset);

        // Configurando o WebView para carregar o vídeo do YouTube
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilita JavaScript (necessário para o YouTube)
        webView.setWebViewClient(new WebViewClient()); // Para evitar abrir o navegador externo ao clicar

        // URL do vídeo do YouTube
        String videoUrl = "https://www.youtube.com/embed/uXKPmTghKNE"; // Substitua pelo seu URL do YouTube

        // Carrega o vídeo no WebView
        webView.loadUrl(videoUrl);
    }

    // Sobrescreva onDestroy para evitar vazamentos de memória ao parar a reprodução do vídeo
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }
}