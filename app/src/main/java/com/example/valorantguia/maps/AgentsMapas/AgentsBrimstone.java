package com.example.valorantguia.maps.AgentsMapas;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.valorantguia.R;
import com.example.valorantguia.SharedViewModel;

public class AgentsBrimstone extends AppCompatActivity {

    private WebView webView1;
    private WebView webView2;
    private ImageButton btnAttackBrimstone;
    private ImageButton btnButtonINCENDIARIO;
    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_brimstone);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        // Encontrando os WebViews no layout XML
        webView1 = findViewById(R.id.video_Attack_brimstone_sunset1);
        webView2 = findViewById(R.id.video_Attack_brimstone_sunset2);

        // Encontrando os ImageButtons no layout XML
        btnAttackBrimstone = findViewById(R.id.btnAttackBrimstone);
        btnButtonINCENDIARIO = findViewById(R.id.btnButtonINCENDIARIO);

        // Configurando os WebViews para carregar vídeos do YouTube
        configureWebView(webView1, "https://www.youtube.com/embed/uXKPmTghKNE");
        configureWebView(webView2, "https://www.youtube.com/embed/z3sgtrAU_LY");

        sharedViewModel.getMapaSunsetClicked().observe(this, isClicked -> {
            // Verifica se o estado do botão Sunset está true
            if (isClicked != null && isClicked) {
                filterVideos();
            } else {
                webView1.setVisibility(View.GONE);
                webView2.setVisibility(View.GONE);
            }
        });

        // Configurando o clique no botão de ataque
        btnAttackBrimstone.setOnClickListener(v -> {
            btnAttackBrimstone.setSelected(!btnAttackBrimstone.isSelected());
            sharedViewModel.setMapaSunsetClicked(btnAttackBrimstone.isSelected());
            filterVideos();
        });

        // Configurando o clique no botão INCENDIARIO
        btnButtonINCENDIARIO.setOnClickListener(v -> {
            btnButtonINCENDIARIO.setSelected(!btnButtonINCENDIARIO.isSelected());
            sharedViewModel.setMapaSunsetClicked(btnButtonINCENDIARIO.isSelected());
            filterVideos();
        });
    }

    // Método para filtrar e mostrar os vídeos
    private void filterVideos() {
        boolean isMapaSunsetClicked = Boolean.TRUE.equals(sharedViewModel.getMapaSunsetClicked().getValue());
        boolean isAttackSelected = btnAttackBrimstone.isSelected();
        boolean isIncendiarioSelected = btnButtonINCENDIARIO.isSelected();

        if (isMapaSunsetClicked && isAttackSelected && isIncendiarioSelected) {
            webView1.setVisibility(View.VISIBLE);
            webView2.setVisibility(View.VISIBLE);
        } else {
            webView1.setVisibility(View.GONE);
            webView2.setVisibility(View.GONE);
        }
    }

    // Método para configurar um WebView para carregar um vídeo do YouTube
    private void configureWebView(WebView webView, String videoUrl) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(videoUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Certifica-se de destruir os WebViews para liberar recursos
        if (webView1 != null) {
            webView1.destroy();
        }
        if (webView2 != null) {
            webView2.destroy();
        }
    }
}
