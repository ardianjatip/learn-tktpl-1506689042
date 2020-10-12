package com.mobileprogramming.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import com.mobileprogramming.helloworld.R;
import com.mobileprogramming.helloworld.BandDetailFragment;
import com.mobileprogramming.helloworld.BandListFragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            BandListFragment fragment = new BandListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment, BandListFragment.TAG)
                    .commit();
        }
    }

    public void showBandDetailFragment() {
        BandDetailFragment fragment = new BandDetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, BandDetailFragment.TAG)
                .addToBackStack(BandDetailFragment.TAG)
                .commit();
    }
}