package com.example.valorantguia.TelaPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.valorantguia.R;
import com.example.valorantguia.maps.bind.bindMapa;
import com.example.valorantguia.maps.sunset.sunsetMapa;
import com.example.valorantguia.maps.icebox.iceboxMapa;
import com.example.valorantguia.maps.ascent.ascentMapa;
import com.example.valorantguia.maps.split.splitMapa;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    ImageButton btnMapaBind, btnMapaSunset, btnMapaIcebox, btnMapaAscent, btnMapaSplit;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        btnMapaBind.setOnClickListener(v -> bindMapaClic());
        btnMapaSunset.setOnClickListener(v -> sunsetMapaClic());
        btnMapaIcebox.setOnClickListener(v -> iceboxMapaClic());
        btnMapaAscent.setOnClickListener(v -> ascentMapaClic());
        btnMapaSplit.setOnClickListener(v -> splitMapaClic());

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
