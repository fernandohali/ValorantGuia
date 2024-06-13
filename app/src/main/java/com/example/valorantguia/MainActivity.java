package com.example.valorantguia;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.valorantguia.TelaPrincipal.AgentesFragment;
import com.example.valorantguia.TelaPrincipal.HomeFragment;
import com.example.valorantguia.databinding.ActivityTelaPrincipalBinding;

public class MainActivity extends AppCompatActivity {

    ActivityTelaPrincipalBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            replaceFragment(new HomeFragment());
            return true;
        } else if (item.getItemId() == R.id.agentes) {
            replaceFragment(new AgentesFragment());
            return true;
        }
        return false;
    }
}
