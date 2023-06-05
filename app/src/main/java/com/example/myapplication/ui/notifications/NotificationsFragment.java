package com.example.myapplication.ui.notifications;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NotificationsViewModel.class);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<String> data = new ArrayList<>();
        List<Integer> checked = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        data.add("Controller (Arduino UNO)");
        checked.add(2);
        element.add(0);
        data.add("Engines");
        checked.add(2);
        element.add(0);
        data.add("Batteries");
        checked.add(2);
        element.add(0);
        data.add("Wi-Fi module");
        checked.add(2);
        element.add(0);
        data.add("Collision avoidance module");
        checked.add(2);
        element.add(0);
        data.add("Sound module");
        checked.add(2);
        element.add(0);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        binding.recyclerView.setAdapter(new MyCFGAdapter(data, checked, element));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}