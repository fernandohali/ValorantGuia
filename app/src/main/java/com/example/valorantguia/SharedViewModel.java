package com.example.valorantguia;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isMapaSunsetClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isMapaIceboxClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isMapaBindClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isMapaAscentClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isMapaSplitClicked = new MutableLiveData<>(false);


    // Métodos para definir o estado do clique para cada mapa
    public void setMapaSunsetClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaSunsetClicked.getValue()) && clicked) {
            isMapaSunsetClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Sunset selecionado");
        } else if (!clicked) {
            isMapaSunsetClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaSunsetClicked() {
        Log.d("SharedViewModel", "getMapaSunsetClicked: " + isMapaSunsetClicked.getValue());

        return isMapaSunsetClicked;
    }

    public void setMapaIceboxClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaIceboxClicked.getValue()) && clicked) {
            isMapaIceboxClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Icebox selecionado");
        } else if (!clicked) {
            isMapaIceboxClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaIceboxClicked() {
        Log.d("SharedViewModel", "getMapaIceboxClicked: " + isMapaIceboxClicked.getValue());
        return isMapaIceboxClicked;
    }

    public void setMapaBindClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaBindClicked.getValue()) && clicked) {
            isMapaBindClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Bind selecionado");
        } else if (!clicked) {
            isMapaBindClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaBindClicked() {
        Log.d("SharedViewModel", "getMapaBindClicked: " + isMapaBindClicked.getValue());
        return isMapaBindClicked;
    }

    public void setMapaAscentClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaAscentClicked.getValue()) && clicked) {
            isMapaAscentClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Ascent selecionado");
        } else if (!clicked) {
            isMapaAscentClicked.setValue(false);
        }    }

    public LiveData<Boolean> getMapaAscentClicked() {
        Log.d("SharedViewModel", "getMapaAscentClicked: " + isMapaAscentClicked.getValue());
        return isMapaAscentClicked;
    }

    public void setMapaSplitClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaSplitClicked.getValue()) && clicked) {
            isMapaSplitClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Split selecionado");
        } else if (!clicked) {
            isMapaSplitClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaSplitClicked() {
        Log.d("SharedViewModel", "getMapaSplitClicked: " + isMapaSplitClicked.getValue());
        return isMapaSplitClicked;
    }
}
