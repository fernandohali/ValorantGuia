package com.example.valorantguia;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _isMapaSunsetClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> _isMapaIceboxClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> _isMapaBindClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> _isMapaAscentClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> _isMapaSplitClicked = new MutableLiveData<>(false);

    private final LiveData<Boolean> isMapaSunsetClicked = _isMapaSunsetClicked;
    private final LiveData<Boolean> isMapaIceboxClicked = _isMapaIceboxClicked;
    private final LiveData<Boolean> isMapaBindClicked = _isMapaBindClicked;
    private final LiveData<Boolean> isMapaAscentClicked = _isMapaAscentClicked;
    private final LiveData<Boolean> isMapaSplitClicked = _isMapaSplitClicked;

    // Métodos para definir o estado do clique para cada mapa
    public void setMapaSunsetClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaSunsetClicked.getValue()) && clicked) {
            _isMapaSunsetClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Sunset selecionado");
        } else if (!clicked) {
            _isMapaSunsetClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaSunsetClicked() {
        Log.d("SharedViewModel", "getMapaSunsetClicked: " + isMapaSunsetClicked.getValue());
        return isMapaSunsetClicked;
    }

    public void setMapaIceboxClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaIceboxClicked.getValue()) && clicked) {
            _isMapaIceboxClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Icebox selecionado");
        } else if (!clicked) {
            _isMapaIceboxClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaIceboxClicked() {
        Log.d("SharedViewModel", "getMapaIceboxClicked: " + isMapaIceboxClicked.getValue());
        return isMapaIceboxClicked;
    }

    public void setMapaBindClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaBindClicked.getValue()) && clicked) {
            _isMapaBindClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Bind selecionado");
        } else if (!clicked) {
            _isMapaBindClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaBindClicked() {
        Log.d("SharedViewModel", "getMapaBindClicked: " + isMapaBindClicked.getValue());
        return isMapaBindClicked;
    }

    public void setMapaAscentClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaAscentClicked.getValue()) && clicked) {
            _isMapaAscentClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Ascent selecionado");
        } else if (!clicked) {
            _isMapaAscentClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaAscentClicked() {
        Log.d("SharedViewModel", "getMapaAscentClicked: " + isMapaAscentClicked.getValue());
        return isMapaAscentClicked;
    }

    public void setMapaSplitClicked(boolean clicked) {
        if (Boolean.FALSE.equals(isMapaSplitClicked.getValue()) && clicked) {
            _isMapaSplitClicked.setValue(true);
            Log.d("SharedViewModel", "Mapa Split selecionado");
        } else if (!clicked) {
            _isMapaSplitClicked.setValue(false);
        }
    }

    public LiveData<Boolean> getMapaSplitClicked() {
        Log.d("SharedViewModel", "getMapaSplitClicked: " + isMapaSplitClicked.getValue());
        return isMapaSplitClicked;
    }
}
