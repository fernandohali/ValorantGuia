package com.example.valorantguia;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isMapaSunsetClicked = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isMapaIceboxClicked = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isMapaBindClicked = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isMapaAscentClicked = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isMapaSplitClicked = new MutableLiveData<>(true);

    // Métodos para definir o estado do clique para cada mapa
    public void setMapaSunsetClicked(boolean clicked) {
        if (clicked) {
            isMapaSunsetClicked.setValue(true);
            isMapaIceboxClicked.setValue(false); // Garante que apenas um dos mapas está selecionado
            isMapaBindClicked.setValue(false);
            isMapaAscentClicked.setValue(false);
            isMapaSplitClicked.setValue(false);
            Log.d("SharedViewModel", "Mapa Sunset selecionado");
        }
    }

    public LiveData<Boolean> getMapaSunsetClicked() {
        Log.d("SharedViewModel", "getMapaSunsetClicked: " + isMapaSunsetClicked.getValue());
        return isMapaSunsetClicked;
    }

    public void setMapaIceboxClicked(boolean clicked) {
        if (clicked) {
            isMapaIceboxClicked.setValue(true);
            isMapaSunsetClicked.setValue(false); // Garante que apenas um dos mapas está selecionado
            isMapaBindClicked.setValue(false);
            isMapaAscentClicked.setValue(false);
            isMapaSplitClicked.setValue(false);
            Log.d("SharedViewModel", "Mapa Icebox selecionado");
        }
    }

    public LiveData<Boolean> getMapaIceboxClicked() {
        Log.d("SharedViewModel", "getMapaIceboxClicked: " + isMapaIceboxClicked.getValue());
        return isMapaIceboxClicked;
    }

    public void setMapaBindClicked(boolean clicked) {
        if (clicked) {
            isMapaBindClicked.setValue(true);
            isMapaSunsetClicked.setValue(false); // Garante que apenas um dos mapas está selecionado
            isMapaIceboxClicked.setValue(false);
            isMapaAscentClicked.setValue(false);
            isMapaSplitClicked.setValue(false);
            Log.d("SharedViewModel", "Mapa Bind selecionado");
        }
    }

    public LiveData<Boolean> getMapaBindClicked() {
        Log.d("SharedViewModel", "getMapaBindClicked: " + isMapaBindClicked.getValue());
        return isMapaBindClicked;
    }

    public void setMapaAscentClicked(boolean clicked) {
        if (clicked) {
            isMapaAscentClicked.setValue(true);
            isMapaSunsetClicked.setValue(false); // Garante que apenas um dos mapas está selecionado
            isMapaIceboxClicked.setValue(false);
            isMapaBindClicked.setValue(false);
            isMapaSplitClicked.setValue(false);
            Log.d("SharedViewModel", "Mapa Ascent selecionado");
        }
    }

    public LiveData<Boolean> getMapaAscentClicked() {
        Log.d("SharedViewModel", "getMapaAscentClicked: " + isMapaAscentClicked.getValue());
        return isMapaAscentClicked;
    }

    public void setMapaSplitClicked(boolean clicked) {
        if (clicked) {
            isMapaSplitClicked.setValue(true);
            isMapaSunsetClicked.setValue(false); // Garante que apenas um dos mapas está selecionado
            isMapaIceboxClicked.setValue(false);
            isMapaBindClicked.setValue(false);
            isMapaAscentClicked.setValue(false);
            Log.d("SharedViewModel", "Mapa Split selecionado");
        }
    }

    public LiveData<Boolean> getMapaSplitClicked() {
        Log.d("SharedViewModel", "getMapaSplitClicked: " + isMapaSplitClicked.getValue());
        return isMapaSplitClicked;
    }
}
