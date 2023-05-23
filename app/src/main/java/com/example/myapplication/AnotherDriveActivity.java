package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityAnotherDriveBinding;

public class AnotherDriveActivity extends AppCompatActivity {

    ActivityAnotherDriveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnotherDriveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}