package com.example.valorantguia.maps.AgentsMapas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.valorantguia.R;
import com.example.valorantguia.SharedViewModel;

public class AgentsBrimstone extends AppCompatActivity {

    private static final int REQUEST_MODIFY_AUDIO_SETTINGS = 123; // substitua 123 pelo valor que desejar
    private WebView webView_Attack_Incendiaria_brimstone_sunset1;
    private WebView webView_Attack_Incendiaria_brimstone_sunset2;
    private WebView webView_Attack_Incendiaria_brimstone_icebox1;
    private WebView webView_Attack_Incendiaria_brimstone_icebox2;
    private ImageButton btnAttackBrimstone;
    private ImageButton btnButtonINCENDIARIO;

    private TextView textMapaSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_brimstone);



        // Solicitar permissão MODIFY_AUDIO_SETTINGS se não estiver concedida
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MODIFY_AUDIO_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.MODIFY_AUDIO_SETTINGS}, REQUEST_MODIFY_AUDIO_SETTINGS);
        }

        // Encontrando os WebViews no layout XML
        webView_Attack_Incendiaria_brimstone_sunset1 = findViewById(R.id.video_Attack_brimstone_sunset1);
        webView_Attack_Incendiaria_brimstone_sunset2 = findViewById(R.id.video_Attack_brimstone_sunset2);
        webView_Attack_Incendiaria_brimstone_icebox1 = findViewById(R.id.video_Attack_brimstone_icebox1);
        webView_Attack_Incendiaria_brimstone_icebox2 = findViewById(R.id.video_Attack_brimstone_icebox2);

        // Encontrando os ImageButtons no layout XML
        btnAttackBrimstone = findViewById(R.id.btnAttackBrimstone);
        btnButtonINCENDIARIO = findViewById(R.id.btnButtonINCENDIARIO);

        // Encontrando o TextView para exibir o nome do mapa selecionado
        textMapaSelecionado = findViewById(R.id.textMapaSelecionado);

        // Configurando os WebViews para carregar vídeos do YouTube
        configureWebView_Attack_Incendiaria_brimstone_sunset(webView_Attack_Incendiaria_brimstone_sunset1, "https://www.youtube.com/embed/uXKPmTghKNE");
        configureWebView_Attack_Incendiaria_brimstone_sunset(webView_Attack_Incendiaria_brimstone_sunset2, "https://www.youtube.com/embed/z3sgtrAU_LY");

        // Icebox
        configureWebView_Attack_Incendiaria_brimstone_icebox(webView_Attack_Incendiaria_brimstone_icebox1, "https://www.youtube.com/embed/M5-M4TKI8MY");
        configureWebView_Attack_Incendiaria_brimstone_icebox(webView_Attack_Incendiaria_brimstone_icebox2, "https://www.youtube.com/embed/OqjFpDqGCac");



        // Configurando o clique no botão de ataque
        btnAttackBrimstone.setOnClickListener(v -> {
            btnAttackBrimstone.setSelected(!btnAttackBrimstone.isSelected());

        });

        // Configurando o clique no botão INCENDIARIO
        btnButtonINCENDIARIO.setOnClickListener(v -> {
            btnButtonINCENDIARIO.setSelected(!btnButtonINCENDIARIO.isSelected());

        });

    }

    // Método para filtrar e mostrar os vídeos do Sunset
    private void filterVideosSunset() {
        boolean isAttackSelected = btnAttackBrimstone.isSelected();
        boolean isIncendiarioSelected = btnButtonINCENDIARIO.isSelected();

        if (isAttackSelected && isIncendiarioSelected) {
            webView_Attack_Incendiaria_brimstone_sunset1.setVisibility(View.VISIBLE);
            webView_Attack_Incendiaria_brimstone_sunset2.setVisibility(View.VISIBLE);
        } else {
            webView_Attack_Incendiaria_brimstone_sunset1.setVisibility(View.GONE);
            webView_Attack_Incendiaria_brimstone_sunset2.setVisibility(View.GONE);
        }
    }

    // Método para filtrar e mostrar os vídeos do Icebox
    private void filterVideosIcebox() {
        boolean isAttackSelected = btnAttackBrimstone.isSelected();
        boolean isIncendiarioSelected = btnButtonINCENDIARIO.isSelected();

        if (isAttackSelected && isIncendiarioSelected) {
            webView_Attack_Incendiaria_brimstone_icebox1.setVisibility(View.VISIBLE);
            webView_Attack_Incendiaria_brimstone_icebox2.setVisibility(View.VISIBLE);
        } else {
            webView_Attack_Incendiaria_brimstone_icebox1.setVisibility(View.GONE);
            webView_Attack_Incendiaria_brimstone_icebox2.setVisibility(View.GONE);
        }
    }

    // Métodos de configuração de WebView para carregar vídeos do YouTube
    @SuppressLint("SetJavaScriptEnabled")
    private void configureWebView_Attack_Incendiaria_brimstone_sunset(WebView webView, String videoUrl) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(videoUrl);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void configureWebView_Attack_Incendiaria_brimstone_icebox(WebView webView, String videoUrl) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(videoUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Libera recursos dos WebViews ao destruir a atividade
        if (webView_Attack_Incendiaria_brimstone_sunset1 != null) {
            webView_Attack_Incendiaria_brimstone_sunset1.destroy();
        }
        if (webView_Attack_Incendiaria_brimstone_sunset2 != null) {
            webView_Attack_Incendiaria_brimstone_sunset2.destroy();
        }
        if (webView_Attack_Incendiaria_brimstone_icebox1 != null) {
            webView_Attack_Incendiaria_brimstone_icebox1.destroy();
        }
        if (webView_Attack_Incendiaria_brimstone_icebox2 != null) {
            webView_Attack_Incendiaria_brimstone_icebox2.destroy();
        }
    }

    // Lidar com a resposta da solicitação de permissão
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_MODIFY_AUDIO_SETTINGS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida
            } else {
                // Permissão negada
                // Aqui você pode lidar com o caso de o usuário não conceder a permissão MODIFY_AUDIO_SETTINGS
            }
        }
    }
}
