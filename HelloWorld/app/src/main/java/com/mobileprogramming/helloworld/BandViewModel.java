package com.mobileprogramming.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mobileprogramming.helloworld.Band;
import com.mobileprogramming.helloworld.BandRepository;

import java.util.List;

public class BandViewModel extends ViewModel {

    private final MutableLiveData<String> selectedBand = new MutableLiveData<>();

    private final BandRepository mRepository = BandRepository.getInstance();

    public void selectBand(String bandName) {
        this.selectedBand.setValue(bandName);
    }

    public LiveData<String> getSelectedBand() {
        return this.selectedBand;
    }

    public List<String> getBandList() {
        return this.mRepository.getBands();
    }

    public Band getBandDetails(String name) {
        return this.mRepository.getBandDetails(name);
    }
}
