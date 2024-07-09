package com.example.valorantguia.TelaPrincipal;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import com.example.valorantguia.R;
import com.example.valorantguia.database.DataBase;
import com.example.valorantguia.database.Invocador;
import com.example.valorantguia.database.InvocadorDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DialogFragmentExample extends DialogFragment {

    private EditText editTextText, editTextText2;
    private Button btnSave;
    private OnInvocadorSavedListener listener;

    public DialogFragmentExample() {
        // Required empty public constructor
    }

    public void setOnInvocadorSavedListener(OnInvocadorSavedListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        // Configurar ações dos botões e campos de entrada aqui, se necessário
        editTextText = view.findViewById(R.id.editTextText);
        editTextText2 = view.findViewById(R.id.editTextText2);
        btnSave = view.findViewById(R.id.btnSave);

        // Configurar ação para fechar o diálogo
        ImageButton btnClose = view.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> dismiss());

        // Configurar ação para salvar os dados
        btnSave.setOnClickListener(v -> saveData());

        return view;
    }

    private void saveData() {
        String nameInvocador = editTextText.getText().toString();
        String tag = editTextText2.getText().toString();

        if (nameInvocador.isEmpty() || tag.isEmpty()) {
            Toast.makeText(getContext(), "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
            return;
        }

        Invocador invocador = new Invocador();
        invocador.nameInvocador = nameInvocador;
        invocador.tag = tag;

        // Usar ExecutorService para inserir o invocador no banco de dados em uma thread separada
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                // Obter instância do banco de dados usando Room
                Context context = requireContext();
                DataBase db = Room.databaseBuilder(context, DataBase.class, "Base De Dados").build();

                // Obter DAO do Invocador
                InvocadorDao invocadorDao = db.invocadorDao();

                // Inserir o invocador no banco de dados
                invocadorDao.insert(invocador);

                // Atualizar a UI na thread principal se necessário
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(getContext(), "Invocador salvo com sucesso!", Toast.LENGTH_SHORT).show();

                    if (listener != null) {
                        listener.onInvocadorSaved(invocador);
                    }

                    dismiss(); // Fecha o DialogFragmentExample após salvar os dados
                });
            } catch (Exception e) {
                // Tratamento de exceção, se necessário
                e.printStackTrace();
            }
        });
    }

    public interface OnInvocadorSavedListener {
        void onInvocadorSaved(Invocador invocador);
    }
}
