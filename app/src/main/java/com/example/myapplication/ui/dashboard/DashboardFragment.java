package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    List<String> titles = new ArrayList<>();

    List<Integer> icons = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        titles.add("Car");
        icons.add(R.drawable.shop_car);
        titles.add("Arduino UNO");
        icons.add(R.drawable.arduino_uno);
        titles.add("Piranha UNO");
        icons.add(R.drawable.piranha);
        titles.add("LiDAR");
        icons.add(R.drawable.lidar);
        titles.add("Sound module");
        icons.add(R.drawable.speaker);
        titles.add("Engine");
        icons.add(R.drawable.engine);
        titles.add("Servo");
        icons.add(R.drawable.servo);
        titles.add("Wi-Fi module");
        icons.add(R.drawable.esp);
        titles.add("STL");
        icons.add(R.drawable.stl);
        titles.add("Machine body");
        icons.add(R.drawable.body);
        titles.add("Batteries");
        icons.add(R.drawable.batteries);
        titles.add("Engines Shield");
        icons.add(R.drawable.l298p);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.recyclerView.setAdapter(new MyBuyAdapter(titles, icons));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}