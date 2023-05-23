package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.widget.Toast;

import com.example.myapplication.AnotherDriveActivity;
import com.example.myapplication.DriveActivity;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.wifi.setOnClickListener(View -> {
            Intent intentWifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
            Toast.makeText(getContext(), "Connect to Wi-Fi \"Robot_535\", if there is any problem, turn off mobile data.", Toast.LENGTH_SHORT).show();
            startActivity(intentWifi);
        });
        binding.drive.setOnClickListener(View -> {
            boolean ch = binding.titleSwitch.isChecked();
            if (!ch) {
                Intent intent = new Intent(getContext(), DriveActivity.class);
                startActivity(intent);
            }
            else {
                Intent intent1 = new Intent(getContext(), AnotherDriveActivity.class);
                startActivity(intent1);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}