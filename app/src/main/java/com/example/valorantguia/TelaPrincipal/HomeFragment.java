package com.example.valorantguia.TelaPrincipal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.valorantguia.R;
import com.example.valorantguia.database.DataBase;
import com.example.valorantguia.database.Mapa;
import com.example.valorantguia.maps.ascent.ascentMapa;
import com.example.valorantguia.maps.bind.bindMapa;
import com.example.valorantguia.maps.icebox.iceboxMapa;
import com.example.valorantguia.maps.split.splitMapa;
import com.example.valorantguia.maps.sunset.sunsetMapa;

public class HomeFragment extends Fragment {

    ImageButton btnMapaBind, btnMapaSunset, btnMapaIcebox, btnMapaAscent, btnMapaSplit;
    private SharedPreferences sharedPreferences;
    private DataBase db;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences("dialog_prefs", Context.MODE_PRIVATE);

        // Inicializa o banco de dados
        db = Room.databaseBuilder(requireContext(), DataBase.class, "valorant_db").allowMainThreadQueries().build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnMapaBind = view.findViewById(R.id.btnMapaBind);
        btnMapaSunset = view.findViewById(R.id.btnMapaSunset);
        btnMapaIcebox = view.findViewById(R.id.btnMapaIcebox);
        btnMapaAscent = view.findViewById(R.id.btnMapaAscent);
        btnMapaSplit = view.findViewById(R.id.btnMapaSplit);

        // Configurar os listeners dos botões
        btnMapaSunset.setOnClickListener(v -> {
            sunsetMapaClic();
            Log.d("HomeFragment", "Sunset button clicked");
        });

        btnMapaIcebox.setOnClickListener(v -> {
            iceboxMapaClic();
            Log.d("HomeFragment", "Icebox button clicked");
        });

        btnMapaBind.setOnClickListener(v -> {
            bindMapaClic();
            Log.d("HomeFragment", "Bind button clicked");
        });

        btnMapaAscent.setOnClickListener(v -> {
            ascentMapaClic();
            Log.d("HomeFragment", "Ascent button clicked");
        });

        btnMapaSplit.setOnClickListener(v -> {
            splitMapaClic();
            Log.d("HomeFragment", "Split button clicked");
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Exibir o diálogo se ainda não foi exibido
        if (!isDialogShown()) {
            showCustomDialog();
            Log.d("HomeFragment", "Dialog shown");
        } else {
            Log.d("HomeFragment", "Dialog already shown");
        }
    }

    private void showCustomDialog() {
        DialogFragmentExample dialogFragment = new DialogFragmentExample();
        FragmentManager fragmentManager = getChildFragmentManager();
        dialogFragment.show(fragmentManager, "CustomDialogFragment");

        // Marcar o diálogo como exibido
        markDialogShown();
    }

    private boolean isDialogShown() {
        return sharedPreferences.getBoolean("dialog_shown", false);
    }

    private void markDialogShown() {
        sharedPreferences.edit().putBoolean("dialog_shown", true).apply();
    }

    private void sunsetMapaClic() {
        Intent intent = new Intent(requireActivity(), sunsetMapa.class);
        startActivity(intent);
    }

    private void bindMapaClic() {
        Intent intent = new Intent(requireActivity(), bindMapa.class);
        startActivity(intent);
    }

    private void iceboxMapaClic() {
        Intent intent = new Intent(requireActivity(), iceboxMapa.class);
        startActivity(intent);
    }

    private void ascentMapaClic() {
        Intent intent = new Intent(requireActivity(), ascentMapa.class);
        startActivity(intent);
    }

    private void splitMapaClic() {
        Intent intent = new Intent(requireActivity(), splitMapa.class);
        startActivity(intent);
    }
}
