package com.mobileprogramming.helloworld;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.mobileprogramming.helloworld.databinding.BandDetailsBinding;
import com.mobileprogramming.helloworld.BandViewModel;
import com.mobileprogramming.helloworld.MainActivity;
import com.mobileprogramming.helloworld.databinding.BandsBinding;

public class BandListFragment extends Fragment {

    public static final String TAG = "BandListFragment";

    private BandsBinding mBinding;

    private BandViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.mBinding = BandsBinding.inflate(inflater, container, false);
        return this.mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(BandViewModel.class);

        this.mBinding.bandListView.setAdapter(
                new ArrayAdapter<>(
                        this.getActivity(),
                        android.R.layout.simple_list_item_1,
                        this.mViewModel.getBandList()
                )
        );

        this.mBinding.bandListView.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            this.mViewModel.selectBand(textView.getText().toString());
            ((MainActivity) requireActivity()).showBandDetailFragment();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding = null;
    }
}

