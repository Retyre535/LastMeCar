package com.example.myapplication.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DescriptionActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.BuyItemBinding;

import java.util.List;

public class MyBuyAdapter extends RecyclerView.Adapter<MyBuyAdapter.MyHolder> {

    List<String> titles;
    List<Integer> icons;

    public MyBuyAdapter(List<String> titles, List<Integer> icons) {
        this.titles = titles;
        this.icons = icons;
    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuyItemBinding binding = BuyItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.item.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DescriptionActivity.class);
            intent.putExtra("key", position);
            view.getContext().startActivity(intent);
        });
        holder.icon.setImageResource(icons.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView icon;
        public View item;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
            item = itemView.findViewById(R.id.item);
        }
    }
}