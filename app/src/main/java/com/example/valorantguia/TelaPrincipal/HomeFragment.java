package com.example.valorantguia.TelaPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.valorantguia.R;
import com.example.valorantguia.SharedViewModel;
import com.example.valorantguia.maps.ascent.ascentMapa;
import com.example.valorantguia.maps.bind.bindMapa;
import com.example.valorantguia.maps.icebox.iceboxMapa;
import com.example.valorantguia.maps.split.splitMapa;
import com.example.valorantguia.maps.sunset.sunsetMapa;

public class HomeFragment extends Fragment {

    ImageButton btnMapaBind, btnMapaSunset, btnMapaIcebox, btnMapaAscent, btnMapaSplit;
    private SharedViewModel sharedViewModel;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Encontrar os ImageButton pelos IDs no layout inflado
        btnMapaBind = view.findViewById(R.id.btnMapaBind);
        btnMapaSunset = view.findViewById(R.id.btnMapaSunset);
        btnMapaIcebox = view.findViewById(R.id.btnMapaIcebox);
        btnMapaAscent = view.findViewById(R.id.btnMapaAscent);
        btnMapaSplit = view.findViewById(R.id.btnMapaSplit);

        // Configurar os listeners dos ImageButtons
        btnMapaSunset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sunsetMapaClic();
                Log.d("HomeFragment", "Sunset button clicked");
                sharedViewModel.setMapaSunsetClicked(true);
            }
        });

        btnMapaIcebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iceboxMapaClic();
                Log.d("HomeFragment", "Icebox button clicked");
                sharedViewModel.setMapaIceboxClicked(true);
            }
        });

        btnMapaBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindMapaClic();
                Log.d("HomeFragment", "Bind button clicked");
                sharedViewModel.setMapaBindClicked(true);
            }
        });

        btnMapaAscent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ascentMapaClic();
                Log.d("HomeFragment", "Ascent button clicked");
                sharedViewModel.setMapaAscentClicked(true);
            }
        });

        btnMapaSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                splitMapaClic();
                Log.d("HomeFragment", "Split button clicked");
                sharedViewModel.setMapaSplitClicked(true);
            }
        });

        return view;
    }

    private void bindMapaClic() {
        Intent intent = new Intent(requireActivity(), bindMapa.class);
        startActivity(intent);
    }

    private void sunsetMapaClic() {
        Intent intent = new Intent(requireActivity(), sunsetMapa.class);
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
