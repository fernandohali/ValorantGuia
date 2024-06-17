package com.example.valorantguia;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.valorantguia.TelaPrincipal.AgentsFragment;
import com.example.valorantguia.TelaPrincipal.HomeFragment;
import com.example.valorantguia.databinding.ActivityTelaPrincipalBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TelaPrincipalActivity extends AppCompatActivity {

    ActivityTelaPrincipalBinding binding;
    DrawerLayout drawerLayout;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

        // Exibir HomeFragment como padrão
        replaceFragment(new HomeFragment());
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = new Fragment();
        if (item.getItemId() == R.id.home) {
            fragment = new HomeFragment();
        } else if (item.getItemId() == R.id.agents) {
            fragment = new AgentsFragment();
        } else if (item.getItemId() == R.id.nav_menu) {

        } else {
            return false;
        }
        replaceFragment(fragment);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}
