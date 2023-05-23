package com.example.myapplication.ui.notifications;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.CfgItemBinding;

import java.util.List;

public class MyCFGAdapter extends RecyclerView.Adapter<MyCFGAdapter.MyHolder> {

    List<String> data;
    List<Integer> checked;

    List<Integer> element;

    public MyCFGAdapter(List<String> data, List<Integer> checked, List<Integer> element) {
        this.data = data;
        this.checked = checked;
        this.element = element;
    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CfgItemBinding binding = CfgItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(data.get(position));
        if (element.get(position)==1) holder.required_element.setText("Optional element");
        if (checked.get(position) == 2) {
            holder.title_switch.setChecked(true);
            holder.title_switch.setClickable(false);
        } else if (checked.get(position) == 1) holder.title_switch.setChecked(true);
        holder.item.setOnClickListener(view -> {
            if (checked.get(position) != 2) {
                holder.title_switch.setChecked(!holder.title_switch.isChecked());
                if (checked.get(position) == 1) checked.set(position, 0);
                else checked.set(position, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public Switch title_switch;

        public View item;

        public TextView required_element;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            title_switch = itemView.findViewById(R.id.title_switch);
            item = itemView.findViewById(R.id.item);
            required_element = itemView.findViewById(R.id.required_element);
        }
    }
}