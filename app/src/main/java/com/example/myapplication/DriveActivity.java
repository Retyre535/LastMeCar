package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityDriveBinding;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DriveActivity extends AppCompatActivity {

    ActivityDriveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.gasButton.setOnClickListener(view -> {
            Thread thread1 = new Thread(new MyThread1());
            thread1.start();
        });
        binding.brakeButton.setOnClickListener(view -> {
            Thread thread2 = new Thread(new MyThread2());
            thread2.start();
        });
        binding.leftButton.setOnClickListener(view -> {
            Thread thread3 = new Thread(new MyThread3());
            thread3.start();
        });
        binding.rightButton.setOnClickListener(view -> {
            Thread thread4 = new Thread(new MyThread4());
            thread4.start();
        });
        /*binding.play.setOnClickListener(view -> {
            Thread thread5 = new Thread(new MyThread5());
            thread5.start();
        });*/
        binding.brake.setOnClickListener(view -> {
            Thread thread6 = new Thread(new MyThread6());
            thread6.start();
        });
    }
    class MyThread1 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/up");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }

    class MyThread2 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/down");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }

    class MyThread3 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/left");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }

    class MyThread4 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/right");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }

    class MyThread5 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/play");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }
    class MyThread6 implements Runnable{

        @Override
        public void run() {
            GetExample example = new GetExample();
            String response = null;
            try {
                response = example.run("http://192.168.4.1/noplay");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(response);
        }

    }

    public class GetExample {
        final OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder().url(url).build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }
    }
}