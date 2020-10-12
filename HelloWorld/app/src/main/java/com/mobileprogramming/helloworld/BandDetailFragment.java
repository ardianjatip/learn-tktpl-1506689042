package com.mobileprogramming.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.mobileprogramming.helloworld.databinding.BandDetailsBinding;
import com.mobileprogramming.helloworld.Band;
import com.mobileprogramming.helloworld.BandViewModel;

public class BandDetailFragment extends Fragment {

    private BandViewModel mViewModel;

    private BandDetailsBinding mBinding;

    public static final String TAG = "BandDetailFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(BandViewModel.class);
        this.mViewModel.getSelectedBand().observe(this, item -> {
            Band band = mViewModel.getBandDetails(item);
            this.setBandDetails(band);
        });
    }

    private void setBandDetails(Band band) {
        this.mBinding.name.setText(band.getName());
        String yearText = "Year Formed: " + band.getYearFormed();
        String originText = "Origin: " + band.getOrigin();
        String genreText = "Genre: " + band.getGenre();
        this.mBinding.yearFormed.setText(yearText);
        this.mBinding.origin.setText(originText);
        this.mBinding.genre.setText(genreText);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.mBinding = BandDetailsBinding.inflate(inflater, container, false);
        return this.mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding = null;
    }
}
